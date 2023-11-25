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

    public static Jdbi me() {
        if (connector == null) connector = new JDBiConnector();
        return connector.jdbi;
    }

    public static void main(String[] args) {
        List<Category> category = JDBiConnector.me().withHandle(handle -> {
            return handle.createQuery("SELECT name FROM category").mapToBean(Category.class)
                    .stream().collect(Collectors.toList());
        });
        System.out.println(category);
    }

}
