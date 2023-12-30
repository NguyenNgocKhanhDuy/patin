package vn.hcmuaf.edu.fit.dao;


import vn.hcmuaf.edu.fit.bean.Size;
import vn.hcmuaf.edu.fit.bean.User;
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

    public List<Size> getSizePerPage(int currentPage, int productPerPage) {
        int start;
        if (currentPage > 1) {
            start =  ((currentPage - 1) * productPerPage);
        } else {
            start = 0;
        }
        List<Size> size = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM size LIMIT :start, 5").bind("start", start).mapToBean(Size.class).stream().collect(Collectors.toList());
        });
        return size;
    }

    public void deleteSize(int id) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("DELETE FROM size WHERE id = ?").bind(0, id).execute();
        });
    }

    public int getIdByName(String name){
        Integer i = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT id FROM size WHERE name like ?").bind(0, "%" + name.trim().replace(" ", "%") + "%").mapTo(Integer.class).one();
        });
        return i;
    }
}
