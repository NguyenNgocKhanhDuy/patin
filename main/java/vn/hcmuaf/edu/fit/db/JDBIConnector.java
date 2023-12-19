package vn.hcmuaf.edu.fit.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.result.ResultIterable;
import vn.hcmuaf.edu.fit.bean.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        Product product = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, image_product.url as img, MIN(product_detail.price) * (1-product.sale_percent) as minPrice, size.name as size, color.name as color " +
                            "FROM  image_product JOIN product on product.id = image_product.id_product JOIN product_detail on product.id = product_detail.id_product JOIN color on color.id = product_detail.id_color JOIN size on size.id = product_detail.id_size " +
                            "WHERE product_detail.id_product = :id AND product_detail.id_size = :size AND product_detail.id_color = :color")
                    .bind("id", 1).bind("size", 1).bind("color", 3)
                    .mapToBean(Product.class).one();
        });
        System.out.println(product);
    }



}
