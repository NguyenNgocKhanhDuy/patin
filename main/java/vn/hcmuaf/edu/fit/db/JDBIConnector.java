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
        List<Integer> i = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT quantity " +
                            "FROM product_detail " +
                            "WHERE id_product = :id AND id_size = :size AND id_color = :color")
                    .bind("id", 1).bind("size", 5).bind("color", 3)
                    .mapTo(Integer.class).list();
        });
        if (i.size() != 1) {
            i.clear();
            i.add(0);
        }
        System.out.println(i.get(0));
    }



}
