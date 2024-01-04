package vn.hcmuaf.edu.fit.dao;

import vn.hcmuaf.edu.fit.bean.ImageProduct;
import vn.hcmuaf.edu.fit.bean.ImageProduct2;
import vn.hcmuaf.edu.fit.db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class ImageProductDao2 {
    private static ImageProductDao2 instance;

    public ImageProductDao2() {
    }

    public static ImageProductDao2 getInstance() {
        if (instance == null) instance = new ImageProductDao2();
        return instance;
    }

    public List<ImageProduct2> getAllImage(int productId) {
        List<ImageProduct2> imageProducts = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT id, url FROM image_product WHERE id_product = ?")
                    .bind(0, productId).mapToBean(ImageProduct2.class).stream().collect(Collectors.toList());
        });
        return imageProducts;
    }
}
