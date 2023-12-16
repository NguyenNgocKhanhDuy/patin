package vn.hcmuaf.edu.fit.dao;

import vn.hcmuaf.edu.fit.bean.Category;
import vn.hcmuaf.edu.fit.db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryDao {
    private static CategoryDao instance;

    public CategoryDao() {
    }

    public static CategoryDao getInstance() {
        if (instance == null) instance = new CategoryDao();
        return instance;
    }

    public List<Category> getAllCategory() {
        List<Category> selectNameFromCategory = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM category").mapToBean(Category.class).stream().collect(Collectors.toList());
        });
        return selectNameFromCategory;
    }

    public Category getCategory(int id) {
        Category category = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT name FROM category WHERE id = ?").bind(0, id).mapToBean(Category.class).one();
        });
        return category;
    }
}
