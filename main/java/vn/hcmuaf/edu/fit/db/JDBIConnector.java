package vn.hcmuaf.edu.fit.db;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;
import vn.hcmuaf.edu.fit.bean.*;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class JDBIConnector {
    Jdbi jdbi;
    static JDBIConnector connector;

    public JDBIConnector() {
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://"+ DBProperties.host()+":"+DBProperties.port()+"/"+DBProperties.dbName());
            dataSource.setUser(DBProperties.user());
            dataSource.setPassword(DBProperties.pass());
            dataSource.setAutoReconnect(true);
            dataSource.setUseCompression(true);
            jdbi = Jdbi.create(dataSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Jdbi get() {
        if (connector == null) connector = new JDBIConnector();
        return connector.jdbi;
    }

    public static void main(String[] args) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, product.sale_percent, MIN(product_detail.price)*(1 - product.sale_percent) as price, image_product.url  " +
                    "FROM product_detail JOIN product on product_detail.product_id = product.id JOIN image_product on product.id = image_product.product_id " +
                    "WHERE image_product.id = 1 and product.hot = 1 " +
                    "GROUP BY product.id " +
                    "LIMIT 5 ").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        System.out.println(products);
    }
}
