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

    public List<Category> getCategory() {
        List<Category> selectNameFromCategory = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT name FROM category").mapToBean(Category.class).stream().collect(Collectors.toList());
        });
        return selectNameFromCategory;
    }
}
