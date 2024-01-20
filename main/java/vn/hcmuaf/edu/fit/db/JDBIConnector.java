package vn.hcmuaf.edu.fit.db;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;
import vn.hcmuaf.edu.fit.bean.*;
import vn.hcmuaf.edu.fit.dao.*;
import vn.hcmuaf.edu.fit.services.ProductService2;
import vn.hcmuaf.edu.fit.services.RatingService;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        System.out.println(ProductDao2.getInstance().getAllProductDetailOnlyOne(1, 1, 3));
    }
}
