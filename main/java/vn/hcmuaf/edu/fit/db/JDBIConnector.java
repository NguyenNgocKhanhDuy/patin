package vn.hcmuaf.edu.fit.db;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;
import vn.hcmuaf.edu.fit.bean.*;

import java.sql.Date;
import java.sql.SQLException;
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

        Date d = Date.valueOf("2023-12-27");


        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE user SET fullname = :fullname, address = :address, phone = :phone, sex = :sex, dob = :dob WHERE id = :id")
                    .bind("id", 11).bind("fullname", "rtt").bind("address", "ijjiqef").bind("phone", "09938123")
                    .bind("sex", "anm").bind("dob", d)
                    .execute();
        });
    }
}
