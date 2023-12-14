package vn.hcmuaf.edu.fit.dao;


import vn.hcmuaf.edu.fit.bean.Product;
import vn.hcmuaf.edu.fit.db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDao {
    private static ProductDao instance;

    public ProductDao() {
    }

    public static ProductDao getInstance() {
        if (instance == null) instance = new ProductDao();
        return instance;
    }

    public List<Product> hotProduct() {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, product.sale_percent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                    "FROM product_detail JOIN product on product_detail.id_product = product.id JOIN image_product on product.id = image_product.id_product " +
                    "WHERE image_product.id = 1 and product.hot = 1 " +
                    "GROUP BY product.id " +
                    "LIMIT 5 ").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getAllProduct() {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, product.sale_percent, MIN(product_detail.price)*(1 - product.sale_percent) as minPrice, MAX(product_detail.price)*(1 - product.sale_percent) as maxPrice, image_product.url as img " +
                    "FROM product_detail JOIN product on product_detail.id_product = product.id JOIN image_product on product.id = image_product.id_product " +
                    "WHERE image_product.id = 1 " +
                    "GROUP BY product.id ").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> search(String find) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.name, image_product.url as img " +
                    "FROM product JOIN image_product on product.id = image_product.id_product " +
                    "WHERE image_product.id = 1 and product.name like ? " +
                    "LIMIT 3")
                    .bind(0, find).mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getProductPerPage(int start) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice, product.sale_percent, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 " +
                            "GROUP BY product.id " +
                            "LIMIT ?, 15")
                    .bind(0, start).mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getProductPerPageByCategory(int start, int category) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice, product.sale_percent, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id = product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 and category_detail.id_category = :category " +
                            "GROUP BY product.id " +
                            "LIMIT :start, 15")
                    .bind("start", start).bind("category", category)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }


    public List<Product> getProductSortPerPage(int start, String type) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice, product.sale_percent, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 " +
                            "GROUP BY product.id " +
                            "ORDER BY minPrice " +type+" "+
                            "LIMIT :start, 15")
                    .bind("start", start).mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getProductSortPerPageByCategory(int start, int category, String type) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice, product.sale_percent, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id = product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 and category_detail.id_category = :category " +
                            "GROUP BY product.id " +
                            "ORDER BY minPrice " +type+" "+
                            "LIMIT :start, 15")
                    .bind("start", start).bind("category", category)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
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

    public List<Product> getProductPerPageSortPrice(int start, String type, int min, int max) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice, product.sale_percent, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min && maxPrice <= :max " +
                            "ORDER BY minPrice "+type+" "+
                            "LIMIT :start, 15")
                    .bind("start", start).bind("min", min).bind("max", max)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getProductPerPageSortPriceByCategory(int start, String type, int min, int max, int category) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice, product.sale_percent, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 AND category_detail.id_category = :category " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min && maxPrice <= :max " +
                            "ORDER BY minPrice "+type+" "+
                            "LIMIT :start, 15")
                    .bind("start", start).bind("min", min).bind("max", max).bind("category", category)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getProductPerPageFilterPrice(int start, int min, int max) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice, product.sale_percent, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max " +
                            "LIMIT :start, 15")
                    .bind("min", min).bind("max", max).bind("start", start)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getProductPerPageFilterPriceByCategory(int start, int min, int max, int category) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice, product.sale_percent, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 AND category_detail.id_category = :category " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min && maxPrice <= :max " +
                            "LIMIT :start, 15")
                    .bind("start", start).bind("min", min).bind("max", max).bind("category", category)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public int countFilterPrice(int min, int max) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max ")
                    .bind("min", min).bind("max", max)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products.size();
    }

    public int countFilterPriceByCategory(int min, int max, int category) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 AND category_detail.id = :category " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max ")
                    .bind("min", min).bind("max", max).bind("category", category)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products.size();
    }

    public List<Product> getProductPerPageSortColor(int start, String type, String[] colors) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice, product.sale_percent, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) " +
                            "GROUP BY product.id " +
                            "ORDER BY minPrice " + type+" "+
                            "LIMIT :start, 15")
                    .bindList("colors", colors).bind("start", start)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getProductPerPageSortColorByCategory(int start, String type, String[] colors, int category) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice, product.sale_percent, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) AND category_detail.id = :category " +
                            "GROUP BY product.id " +
                            "ORDER BY minPrice " + type+" "+
                            "LIMIT :start, 15")
                    .bindList("colors", colors).bind("start", start).bind("category", category)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getProductPerPageFilterColor(int start, String[] colors) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice, product.sale_percent, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) " +
                            "GROUP BY product.id " +
                            "LIMIT :start, 15")
                    .bindList("colors", colors).bind("start", start)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getProductPerPageFilterColorByCategory(int start, String[] colors, int category) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice, product.sale_percent, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) AND category_detail.id = :category " +
                            "GROUP BY product.id " +
                            "LIMIT :start, 15")
                    .bindList("colors", colors).bind("start", start).bind("category", category)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
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
                            "WHERE product_detail.id_color in (<color>) AND category_detail.id = :category ")
                    .bindList("color", colors).bind("category", category)
                    .mapTo(Integer.class).one();
        });
        return i;
    }

    public List<Product> getProductPerPageSortPriceColor(int start, String type, int min, int max, String[] colors) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice, product.sale_percent, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max " +
                            "ORDER BY minPrice " + type+" "+
                            "LIMIT :start, 15")
                    .bindList("colors", colors).bind("start", start)
                    .bind("min", min).bind("max", max)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getProductPerPageSortPriceColorByCategory(int start, String type, int min, int max, String[] colors, int category) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice, product.sale_percent, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) AND category_detail.id = :category " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max " +
                            "ORDER BY minPrice " + type+" "+
                            "LIMIT :start, 15")
                    .bindList("colors", colors).bind("start", start)
                    .bind("min", min).bind("max", max).bind("category", category)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getProductPerPageFilterPriceColor(int start, int min, int max, String[] colors) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice, product.sale_percent, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>)" +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max " +
                            "LIMIT :start, 15")
                    .bindList("colors", colors).bind("start", start)
                    .bind("min", min).bind("max", max)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public List<Product> getProductPerPageFilterPriceColorByCategory(int start, int min, int max, String[] colors, int category) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice, product.sale_percent, image_product.url as img " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) AND category_detail.id = :category " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max " +
                            "LIMIT :start, 15")
                    .bindList("colors", colors).bind("start", start)
                    .bind("min", min).bind("max", max).bind("category", category)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products;
    }

    public int countFilterPriceColor(int min, int max, String[] colors) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max")
                    .bindList("colors", colors)
                    .bind("min", min).bind("max", max)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products.size();
    }

    public int countFilterPriceColorByCategory(int min, int max, String[] colors, int category) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, MAX(product_detail.price) * (1-product.sale_percent) as maxPrice " +
                            "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id =product_detail.id_product JOIN category_detail on category_detail.id_product = product.id " +
                            "WHERE image_product.id = 1 AND product_detail.id_color in (<colors>) AND category_detail.id = :category " +
                            "GROUP BY product.id " +
                            "HAVING minPrice >= :min AND maxPrice <= :max")
                    .bindList("colors", colors)
                    .bind("min", min).bind("max", max).bind("category", category)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        return products.size();
    }
}
