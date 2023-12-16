package vn.hcmuaf.edu.fit.dao;

import vn.hcmuaf.edu.fit.bean.Color;
import vn.hcmuaf.edu.fit.db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class ColorDao {
    private static ColorDao instance;

    public ColorDao() {
    }

    public static ColorDao getInstance() {
        if (instance == null) instance = new ColorDao();
        return instance;
    }

    public List<Color> getProductColor(int productId) {
        List<Color> colors = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT DISTINCT color.id, color.name " +
                    "FROM product_detail JOIN color on product_detail.id_color = color.id " +
                    "WHERE product_detail.id_product = ?").bind(0, productId).mapToBean(Color.class).stream().collect(Collectors.toList());
        });
        return colors;
    }
}
