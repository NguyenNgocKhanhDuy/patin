package vn.hcmuaf.edu.fit.dao;


import vn.hcmuaf.edu.fit.bean.Product;
import vn.hcmuaf.edu.fit.db.JDBIConnector;

import java.util.List;
import java.util.Random;
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
}
