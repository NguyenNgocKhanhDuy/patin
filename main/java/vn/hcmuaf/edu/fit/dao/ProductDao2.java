package vn.hcmuaf.edu.fit.dao;


import vn.hcmuaf.edu.fit.bean.Product;
import vn.hcmuaf.edu.fit.bean.ProductMain;
import vn.hcmuaf.edu.fit.db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDao2 {
    private static ProductDao2 instance;

    public ProductDao2() {
    }

    public static ProductDao2 getInstance() {
        if (instance == null) instance = new ProductDao2();
        return instance;
    }

    public List<ProductMain> hotProduct() {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                    "FROM product_detail JOIN product on product_detail.id_product = product.id JOIN image_product on product.id = image_product.id_product " +
                    "WHERE image_product.id = 1 and product.hot = 1 " +
                    "GROUP BY product.id " +
                    "LIMIT 5 ").mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<ProductMain> getAllProduct() {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                    "FROM product_detail JOIN product on product_detail.id_product = product.id JOIN image_product on product.id = image_product.id_product " +
                    "WHERE image_product.id = 1 " +
                    "GROUP BY product.id ").mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<ProductMain> search(String find) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, image_product.url as img " +
                    "FROM product JOIN image_product on product.id = image_product.id_product " +
                    "WHERE image_product.id = 1 and product.name like ? " +
                    "LIMIT 3")
                    .bind(0, find).mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<ProductMain> getProductPerPage(int start, int quantityPerPage) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 " +
                            "GROUP BY product.id " +
                            "LIMIT ?, ?")
                    .bind(0, start).bind(1, quantityPerPage)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<ProductMain> getProductPerPageByCategory(int start, int category) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id = product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 and category_detail.id_category = :category " +
                            "GROUP BY product.id " +
                            "LIMIT :start, 15")
                    .bind("start", start).bind("category", category)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }


    public List<ProductMain> getProductSortPerPage(int start, String type) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 " +
                            "GROUP BY product.id " +
                            "ORDER BY minPrice " +type+" "+
                            "LIMIT :start, 15")
                    .bind("start", start).mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<ProductMain> getProductSortPerPageByCategory(int start, String type, int category) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id = product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 and category_detail.id_category = :category " +
                            "GROUP BY product.id " +
                            "ORDER BY minPrice " +type+" "+
                            "LIMIT :start, 15")
                    .bind("start", start).bind("category", category)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public int countAll() {
        Integer i = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT COUNT(*) " +
                    "FROM product ").mapTo(Integer.class).one();
        });
        return i;
    }

    public int countAllByCategory(int category) {
        Integer i = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT COUNT(*) " +
                    "FROM product JOIN category_detail on product.id = category_detail.id_product " +
                    "WHERE category_detail.id_category = :category ")
                    .bind("category", category).mapTo(Integer.class).one();
        });
        return i;
    }

    public List<ProductMain> getProductPerPageSortPrice(int start, String type, int min, int max) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min && maxPrice <= :max " +
                            "ORDER BY minPrice "+type+" "+
                            "LIMIT :start, 15")
                    .bind("start", start).bind("min", min).bind("max", max)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<ProductMain> getProductPerPageSortPriceByCategory(int start, String type, int min, int max, int category) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 AND category_detail.id_category = :category " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min && maxPrice <= :max " +
                            "ORDER BY minPrice "+type+" "+
                            "LIMIT :start, 15")
                    .bind("start", start).bind("min", min).bind("max", max).bind("category", category)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<ProductMain> getProductPerPageFilterPrice(int start, int min, int max) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max " +
                            "LIMIT :start, 15")
                    .bind("min", min).bind("max", max).bind("start", start)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<ProductMain> getProductPerPageFilterPriceByCategory(int start, int min, int max, int category) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 AND category_detail.id_category = :category " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min && maxPrice <= :max " +
                            "LIMIT :start, 15")
                    .bind("start", start).bind("min", min).bind("max", max).bind("category", category)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public int countFilterPrice(int min, int max) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max ")
                    .bind("min", min).bind("max", max)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products.size();
    }

    public int countFilterPriceByCategory(int min, int max, int category) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 AND category_detail.id_category = :category " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max ")
                    .bind("min", min).bind("max", max).bind("category", category)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products.size();
    }

    public List<ProductMain> getProductPerPageSortColor(int start, String type, String[] colors) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) " +
                            "GROUP BY product.id " +
                            "ORDER BY minPrice " + type+" "+
                            "LIMIT :start, 15")
                    .bindList("colors", colors).bind("start", start)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<ProductMain> getProductPerPageSortColorByCategory(int start, String type, String[] colors, int category) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) AND category_detail.id_category = :category " +
                            "GROUP BY product.id " +
                            "ORDER BY minPrice " + type+" "+
                            "LIMIT :start, 15")
                    .bindList("colors", colors).bind("start", start).bind("category", category)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<ProductMain> getProductPerPageFilterColor(int start, String[] colors) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) " +
                            "GROUP BY product.id " +
                            "LIMIT :start, 15")
                    .bindList("colors", colors).bind("start", start)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<ProductMain> getProductPerPageFilterColorByCategory(int start, String[] colors, int category) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) AND category_detail.id_category = :category " +
                            "GROUP BY product.id " +
                            "LIMIT :start, 15")
                    .bindList("colors", colors).bind("start", start).bind("category", category)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public int countFilterColor(String[] colors) {
        Integer i = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT COUNT(DISTINCT product.id) " +
                            "FROM product JOIN product_detail on product.id = product_detail.id_product " +
                            "WHERE product_detail.id_color in (<color>) ")
                    .bindList("color", colors).mapTo(Integer.class).one();
        });
        return i;
    }

    public int countFilterColorByCategory(String[] colors, int category) {
        Integer i = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT COUNT(DISTINCT product.id) " +
                            "FROM product JOIN product_detail on product.id = product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE product_detail.id_color in (<color>) AND category_detail.id_category = :category ")
                    .bindList("color", colors).bind("category", category)
                    .mapTo(Integer.class).one();
        });
        return i;
    }

    public List<ProductMain> getProductPerPageSortPriceColor(int start, String type, int min, int max, String[] colors) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max " +
                            "ORDER BY minPrice " + type+" "+
                            "LIMIT :start, 15")
                    .bindList("colors", colors).bind("start", start)
                    .bind("min", min).bind("max", max)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<ProductMain> getProductPerPageSortPriceColorByCategory(int start, String type, int min, int max, String[] colors, int category) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) AND category_detail.id_category = :category " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max " +
                            "ORDER BY minPrice " + type+" "+
                            "LIMIT :start, 15")
                    .bindList("colors", colors).bind("start", start)
                    .bind("min", min).bind("max", max).bind("category", category)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<ProductMain> getProductPerPageFilterPriceColor(int start, int min, int max, String[] colors) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>)" +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max " +
                            "LIMIT :start, 15")
                    .bindList("colors", colors).bind("start", start)
                    .bind("min", min).bind("max", max)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<ProductMain> getProductPerPageFilterPriceColorByCategory(int start, int min, int max, String[] colors, int category) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) AND category_detail.id_category = :category " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max " +
                            "LIMIT :start, 15")
                    .bindList("colors", colors).bind("start", start)
                    .bind("min", min).bind("max", max).bind("category", category)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public int countFilterPriceColor(int min, int max, String[] colors) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max")
                    .bindList("colors", colors)
                    .bind("min", min).bind("max", max)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products.size();
    }

    public int countFilterPriceColorByCategory(int min, int max, String[] colors, int category) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) AND category_detail.id_category = :category " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max")
                    .bindList("colors", colors)
                    .bind("min", min).bind("max", max).bind("category", category)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products.size();
    }

    public ProductMain getProduct(int id) {
        ProductMain product = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, " +
                            "product.hot as product_detail_product_hot, product.sale_percent as product_detail_product_salePercent, " +
                            "product.information as product_detail_product_information, image_product.url as img, " +
                            "MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice " +
                    "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail on product.id = product_detail.id_product " +
                    "WHERE image_product.id = 1 AND  product.id = ?")
                    .bind(0, id).mapToBean(ProductMain.class).one();
        });
        return product;
    }

    public int getTotalQuantity(int id) {
        Integer i = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT SUM(product_detail.quantity) " +
                            "FROM product_detail " +
                            "WHERE product_detail.id_product = ? " +
                            "GROUP BY product_detail.id_product")
                    .bind(0, id).mapTo(Integer.class).one();
        });
        return i;
    }

    public int getPrice(int id, int size, int color) {
        List<Integer> i = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product_detail.price * (1-product.sale_percent) " +
                            "FROM product_detail JOIN product on product_detail.id_product = product.id " +
                            "WHERE id_product = :id AND id_size = :size AND id_color = :color")
                    .bind("id", id).bind("size", size).bind("color", color)
                    .mapTo(Integer.class).list();
        });
        if (i.size() != 1) {
            i.clear();
            i.add(0);
        }
        return i.get(0);
    }

    public int getQuantity(int id, int size, int color) {
        List<Integer> i = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT quantity " +
                            "FROM product_detail " +
                            "WHERE id_product = :id AND id_size = :size AND id_color = :color")
                    .bind("id", id).bind("size", size).bind("color", color)
                    .mapTo(Integer.class).list();
        });
        if (i.size() != 1) {
            i.clear();
            i.add(0);
        }
        return i.get(0);
    }

    public List<ProductMain> getProductDetail(int id) {
        List<ProductMain> product = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product_detail.quantity as product_detail_quantity, image_product.url as img, product_detail.price * (1-product.sale_percent) as product_detail_price, product.sale_percent as product_detail_product_salePercent, product.information as product_detail_product_information, " +
                            "size.id as product_detail_size_id, size.name product_detail_size_name, color.id as product_detail_color_id, color.name as product_detail_color_name " +
                            "FROM  image_product JOIN product on product.id = image_product.id_product JOIN product_detail on product.id = product_detail.id_product JOIN color on color.id = product_detail.id_color JOIN size on size.id = product_detail.id_size " +
                            "WHERE product_detail.id_product = :id AND image_product.id = 1 " +
                            "ORDER BY price asc")
                    .bind("id", id).mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return product;

    }
    public List<ProductMain> getAllProductDetail(int id) {
        List<ProductMain> product = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, " +
                            "product.hot as product_detail_product_hot, product.sale_percent as product_detail_product_salePercent, " +
                            "product.information as product_detail_product_information, " +
                            "product_detail.quantity as product_detail_quantity, product_detail.price as minPrice, " +
                            "size.name as product_detail_size_name, color.name as product_detail_color_name " +
                            "FROM  product JOIN product_detail on product.id = product_detail.id_product JOIN color on color.id = product_detail.id_color JOIN size on size.id = product_detail.id_size " +
                            "WHERE product_detail.id_product = :id " +
                            "ORDER BY minPrice asc")
                    .bind("id", id)
                    .mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return product;

    }

    public List<ProductMain> getWishList(int userID, int productID) {
        List<ProductMain> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id as product_detail_product_id, product.name as product_detail_product_name, product.sale_percent as product_detail_product_salePercent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                    "FROM product_detail JOIN product on product_detail.id_product = product.id JOIN image_product on product.id = image_product.id_product JOIN wish_list on product.id = wish_list.id_product " +
                    "WHERE image_product.id = 1 AND wish_list.id_product = :product AND wish_list.id_user = :user " +
                    "GROUP BY product.id ")
                    .bind("product", productID).bind("user", userID).mapToBean(ProductMain.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public void addWishList(int userID, int productID) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO wish_list(id_user, id_product) VALUES (:user, :product) ")
                    .bind("user", userID).bind("product", productID).execute();
        });
    }
}
