package model;

import db.JDBiConnector;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.Nested;


import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class Product implements Serializable {
    private int id;
    private String name;
    private int originPrice;
    private int salePrice;
    private String size;
    private String color;
    private int quantity;
    private int hot;
    private String infomation;
    @Nested
    private ImageProduct image;
    private int idSale;
    private int idAdmin;

    public Product() {
    }

    public Product(int id, String name, int originPrice, int salePrice, String size, String color, int quantity, int hot, String infomation, ImageProduct image, int idSale, int idAdmin) {
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

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
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
            return handle.createQuery("SELECT product.name, product.origin_price, product.sale_price, image_product.url " +
                    "FROM product join image_product on product.id = image_product.id_product " +
                    "WHERE image_product.id = 1").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }
    public List<Product> filterProduct(int min, int max) {
        List<Product> products = JDBiConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.name, product.origin_price, product.sale_price, image_product.url " +
                    "FROM product join image_product on product.id = image_product.id_product " +
                    "WHERE product.sale_price >= :min and product.sale_price <= :max and image_product.id = 1").bind("min", min).bind("max", max).mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getSortProduct(String type) {
        List<Product> products = JDBiConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.name, product.origin_price, product.sale_price, image_product.url " +
                    "FROM product join image_product on product.id = image_product.id_product " +
                    "WHERE image_product.id = 1 " +
                    "ORDER BY product.sale_price "+type).mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }
}
