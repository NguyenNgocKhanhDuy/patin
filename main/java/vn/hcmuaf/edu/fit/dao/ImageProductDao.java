package vn.hcmuaf.edu.fit.dao;

import vn.hcmuaf.edu.fit.bean.ImageProduct;
import vn.hcmuaf.edu.fit.db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class ImageProductDao {
    private static ImageProductDao instance;

    public ImageProductDao() {
    }

    public static ImageProductDao getInstance() {
        if (instance == null) instance = new ImageProductDao();
        return instance;
    }

    public List<ImageProduct> getAllImage(int productId) {
        List<ImageProduct> imageProducts = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT id, url FROM image_product WHERE id_product = ?")
                    .bind(0, productId).mapToBean(ImageProduct.class).stream().collect(Collectors.toList());
        });
        return imageProducts;
    }
}
