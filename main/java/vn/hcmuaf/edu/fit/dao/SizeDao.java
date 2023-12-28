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

    public Size getSizeById(int id) {
        Size size = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * " +
                    "FROM size " +
                    "WHERE id = ?").bind(0, id).mapToBean(Size.class).one();
        });
        return size;
    }

    public List<Size> getAllsize() {
        List<Size> sizes = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM size").mapToBean(Size.class).stream().collect(Collectors.toList());
        });
        return sizes;
    }

    public void insertSize(Size size){
        int id = getAllsize().size() + 1;
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO size(id, name) VALUES (:id, name)").bind("name", size.getName()).bind("id", id).execute();
        });
    }

    public void updateSize(Size size){
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE size SET name = :name WHERE id = :id").bind("name", size.getName()).bind("id", size.getId()).execute();
        });
    }
}
