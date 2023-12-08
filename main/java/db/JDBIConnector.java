package db;

import com.mysql.cj.jdbc.MysqlDataSource;
import model.Product;
import org.jdbi.v3.core.Jdbi;
import vn.hcmuaf.edu.fit.bean.User;

import java.sql.SQLException;
import java.util.ArrayList;
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
        List<User> users = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT email, password " +
                                          "FROM user " +
                                          "WHERE verify = 1 and email = ?")
                    .bind(0, "duynguyenngockhanh@gmail.com")
                    .mapToBean(User.class).stream().collect(Collectors.toList());
        });
        System.out.println(users);
    }

}
