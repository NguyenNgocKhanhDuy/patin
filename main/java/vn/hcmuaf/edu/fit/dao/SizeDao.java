package vn.hcmuaf.edu.fit.dao;

import vn.hcmuaf.edu.fit.bean.Size;
import vn.hcmuaf.edu.fit.db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class SizeDao {
    private static SizeDao instance;

    public SizeDao() {
    }

    public static SizeDao getInstance() {
        if (instance == null) instance = new SizeDao();
        return instance;
    }

    public List<Size> getProductSize(int productId) {
        List<Size> sizes = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT DISTINCT size.id, size.name " +
                    "FROM product_detail JOIN size on product_detail.id_size = size.id " +
                    "WHERE product_detail.id_product = ?").bind(0, productId).mapToBean(Size.class).stream().collect(Collectors.toList());
        });
        return sizes;
    }
}
