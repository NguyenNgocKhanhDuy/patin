package db;

import com.mysql.cj.jdbc.MysqlDataSource;
import model.Category;
import model.Product;
import org.jdbi.v3.core.Jdbi;

import java.sql.SQLException;
import java.util.ArrayList;
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
        String[] s = {"0", "2", "0"};

        String txt = "";
        for (int i = 0; i < s.length; i++) {
            txt += s[i]+", ";
        }

        ArrayList<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");


        List<Product> products = JDBiConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product.id, product.name, MIN(product_detail.price) as price, image_product.url, product_detail.id_color as color " +
                    "FROM image_product JOIN product on image_product.id_product = product.id JOIN product_detail ON product.id = product_detail.id_product " +
                    "WHERE product_detail.id_color in (<color>) " +
                    "GROUP BY product.id " +
                    "LIMIT :start, :end")
                    .bind("start", 0).bind("end", 15).bindList("color", s)
                    .mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        System.out.println(products);
    }

}
