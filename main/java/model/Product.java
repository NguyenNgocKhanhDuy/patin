package model;

import db.JDBiConnector;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.Nested;
import org.jdbi.v3.core.mapper.reflect.ColumnName;


import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class Product implements Serializable {
    private int id;
    private String name;
    private int originPrice;
    @ColumnName("price")
    private int salePrice;
    private String size;
    @ColumnName("color")
    private int color;
    private int quantity;
    private int hot;
    private String infomation;
    @Nested
    private ImageProduct image;
    private int idSale;
    private int idAdmin;

    public Product() {
    }

    public Product(int id, String name, int originPrice, @ColumnName("price") int salePrice, String size, @ColumnName("color") int color, int quantity, int hot, String infomation, ImageProduct image, int idSale, int idAdmin) {
        this.id = id;
        this.name = name;
        this.originPrice = originPrice;
        this.salePrice = salePrice;
        this.size = size;
        this.color = color;
        this.quantity = quantity;
        this.hot = hot;
        this.infomation = infomation;
        this.image = image;
        this.idSale = idSale;
        this.idAdmin = idAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(int originPrice) {
        this.originPrice = originPrice;
    }

    @ColumnName("price")
    public int getSalePrice() {
        return salePrice;
    }
    @ColumnName("price")
    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @ColumnName("color")
    public int getColor() {
        return color;
    }

    @ColumnName("color")
    public void setColor(int color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public String getInfomation() {
        return infomation;
    }

    public void setInfomation(String infomation) {
        this.infomation = infomation;
    }

    @Nested
    public ImageProduct getImage() {
        return image;
    }

    @Nested
    public void setImage(ImageProduct image) {
        this.image = image;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", originPrice=" + originPrice +
                ", salePrice=" + salePrice +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", quantity=" + quantity +
                ", hot=" + hot +
                ", infomation='" + infomation + '\'' +
                ", image=" + image +
                ", idSale=" + idSale +
                ", idAdmin=" + idAdmin +
                '}';
    }

    public List<Product> searchProduct(String text) {
        String txt = "%"+text.replace(" ", "%")+"%";
        List<Product> products = JDBiConnector.get().withHandle(handle -> {
            return handle.createQuery("select product.name, image_product.url " +
                                          "from product join image_product on product.id = image_product.id_product "+
                                          "where image_product.id = 1 and product.name like ? ")
                    .bind(0, txt).mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getHotProduct() {
        List<Product> products = JDBiConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.name, product.origin_price, product.sale_price, image_product.url " +
                            "from product join image_product on product.id = image_product.id_product " +
                            "WHERE image_product.id = 1 and product.hot = 1 " +
                            "LIMIT 5")
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getAllProduct() {
        List<Product> products = JDBiConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) as price, image_product.url " +
                    "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                    "WHERE image_product.id = 1 " +
                    "GROUP BY product.id").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getProduct(int currentPage) {

        int productPerPage = 15;
        int start;
        int end;

        if (currentPage > 1) {
            start = ((currentPage - 1) * productPerPage) + 1;
            end = (currentPage * productPerPage);
        } else {
            end = productPerPage;
            start = 0;
        }


        List<Product> products = JDBiConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) as price, image_product.url " +
                    "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                    "WHERE product.id >= :start and product.id <= :end " +
                    "GROUP BY product.id ")
                    .bind("start", start).bind("end", end).mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> sortProduct(String type, int currentPage) {
        int productPerPage = 15;
        int start;

        if (currentPage > 1) {
            start = ((currentPage - 1) * productPerPage) + 1;
        } else {
            start = 0;
        }
        List<Product> products;

        if (!type.equals("")){
            products = JDBiConnector.get().withHandle(handle -> {
                return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) as price, image_product.url " +
                                "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id = product_detail.id_product " +
                                "GROUP BY product.id " +
                                "ORDER BY MIN(product_detail.price) "+type+" " +
                                "LIMIT :start, :end")
                        .bind("start", start).bind("end", productPerPage).mapToBean(Product.class).stream().collect(Collectors.toList());
            });
        }else {
            products = JDBiConnector.get().withHandle(handle -> {
                return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) as price, image_product.url " +
                                "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id = product_detail.id_product " +
                                "GROUP BY product.id " +
                                "LIMIT :start, :end")
                        .bind("start", start).bind("end", productPerPage).mapToBean(Product.class).stream().collect(Collectors.toList());
            });
        }


        return products;
    }

    public List<Product> filterPriceProduct(String type, int currentPage, int min, int max) {
        int productPerPage = 15;
        int start;

        if (currentPage > 1) {
            start = ((currentPage - 1) * productPerPage) + 1;
        } else {
            start = 0;
        }

        List<Product> products;

        if (!type.equals("")) {
            products = JDBiConnector.get().withHandle(handle -> {
                return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) as price, image_product.url " +
                                "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id = product_detail.id_product " +
                                "GROUP BY product.id " +
                                "HAVING MIN(product_detail.price) >= :min and MIN(product_detail.price) <= :max " +
                                "ORDER BY MIN(product_detail.price) "+type+" " +
                                "LIMIT :start, :end")
                        .bind("start", start).bind("end", productPerPage)
                        .bind("min", min).bind("max", max)
                        .mapToBean(Product.class).stream().collect(Collectors.toList());
            });
        }else {
            products = JDBiConnector.get().withHandle(handle -> {
                return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) as price, image_product.url " +
                                "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id = product_detail.id_product " +
                                "GROUP BY product.id " +
                                "HAVING MIN(product_detail.price) >= :min and MIN(product_detail.price) <= :max " +
                                "LIMIT :start, :end")
                        .bind("start", start).bind("end", productPerPage)
                        .bind("min", min).bind("max", max)
                        .mapToBean(Product.class).stream().collect(Collectors.toList());
            });
        }

        return products;
    }

    public List<Product> allFilterPriceProduct(int min, int max) {
        List<Product> products = JDBiConnector.get().withHandle(handle -> {
                return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) as price, image_product.url " +
                                "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id = product_detail.id_product " +
                                "GROUP BY product.id " +
                                "HAVING MIN(product_detail.price) >= :min and MIN(product_detail.price) <= :max ")
                        .bind("min", min).bind("max", max)
                        .mapToBean(Product.class).stream().collect(Collectors.toList());
            });

        return products;
    }

    public List<Product> filterColorProduct(String type, int currentPage, String[] color) {
        int productPerPage = 15;
        int start;

        if (currentPage > 1) {
            start = ((currentPage - 1) * productPerPage) + 1;
        } else {
            start = 0;
        }


        List<Product> products;

        if (!type.equals("")) {
            products = JDBiConnector.get().withHandle(handle -> {
                return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) as price, image_product.url " +
                                "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id = product_detail.id_product " +
                                "WHERE product_detail.id_color in (<color>) " +
                                "GROUP BY product.id " +
                                "ORDER BY MIN(product_detail.price) "+type+" " +
                                "LIMIT :start, :end")
                        .bind("start", start).bind("end", productPerPage).bindList("color", color)
                        .mapToBean(Product.class).stream().collect(Collectors.toList());
            });
        }else {
            products = JDBiConnector.get().withHandle(handle -> {
                return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) as price, image_product.url " +
                                "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id = product_detail.id_product " +
                                "WHERE product_detail.id_color in (<color>) " +
                                "GROUP BY product.id " +
                                "LIMIT :start, :end")
                        .bind("start", start).bind("end", productPerPage).bindList("color", color)
                        .mapToBean(Product.class).stream().collect(Collectors.toList());
            });
        }

        return products;
    }

    public List<Product> allFilterColorProduct(String[] color) {
        List<Product> products = JDBiConnector.get().withHandle(handle -> {
                return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) as price, image_product.url " +
                                "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id = product_detail.id_product " +
                                "WHERE product_detail.id_color in (<color>) " +
                                "GROUP BY product.id ")
                        .bindList("color", color)
                        .mapToBean(Product.class).stream().collect(Collectors.toList());
            });
        return products;
    }

    public List<Product> filterPriceColorProduct(String type, int currentPage, String[] color, int min, int max) {
        int productPerPage = 15;
        int start;

        if (currentPage > 1) {
            start = ((currentPage - 1) * productPerPage) + 1;
        } else {
            start = 0;
        }


        List<Product> products;

        if (!type.equals("")) {
            products = JDBiConnector.get().withHandle(handle -> {
                return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) as price, image_product.url " +
                                "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id = product_detail.id_product " +
                                "WHERE product_detail.id_color in (<color>) " +
                                "GROUP BY product.id " +
                                "HAVING MIN(product_detail.price) >= :min and MIN(product_detail.price) <= :max " +
                                "ORDER BY MIN(product_detail.price) "+type+" " +
                                "LIMIT :start, :end")
                        .bind("start", start).bind("end", productPerPage).bindList("color", color)
                        .bind("min", min).bind("max", max)
                        .mapToBean(Product.class).stream().collect(Collectors.toList());
            });
        }else {
            products = JDBiConnector.get().withHandle(handle -> {
                return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) as price, image_product.url " +
                                "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id = product_detail.id_product " +
                                "WHERE product_detail.id_color in (<color>) " +
                                "GROUP BY product.id " +
                                "HAVING MIN(product_detail.price) >= :min and MIN(product_detail.price) <= :max " +
                                "LIMIT :start, :end")
                        .bind("start", start).bind("end", productPerPage).bindList("color", color)
                        .bind("min", min).bind("max", max)
                        .mapToBean(Product.class).stream().collect(Collectors.toList());
            });
        }

        return products;
    }

    public List<Product> allFilterPriceColorProduct(String[] color, int min, int max) {
        List<Product> products = JDBiConnector.get().withHandle(handle -> {
                return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) as price, image_product.url " +
                                "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id = product_detail.id_product " +
                                "WHERE product_detail.id_color in (<color>) " +
                                "GROUP BY product.id " +
                                "HAVING MIN(product_detail.price) >= :min and MIN(product_detail.price) <= :max ")
                        .bindList("color", color)
                        .bind("min", min).bind("max", max)
                        .mapToBean(Product.class).stream().collect(Collectors.toList());
            });
        return products;
    }
}
