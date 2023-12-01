package db;

import com.mysql.cj.jdbc.MysqlDataSource;
import model.Category;
import model.Product;
import org.jdbi.v3.core.Jdbi;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class JDBiConnector {
    Jdbi jdbi;
    static JDBiConnector connector;

    public JDBiConnector() {
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
        if (connector == null) connector = new JDBiConnector();
        return connector.jdbi;
    }

    public static void main(String[] args) {
        List<Product> products = JDBiConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.name, product.origin_price, product.sale_price, image_product.url " +
                    "FROM product join image_product on product.id = image_product.id_product " +
                    "WHERE product.id <= 12 and image_product.id = 1").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        System.out.println(products);
    }

}
