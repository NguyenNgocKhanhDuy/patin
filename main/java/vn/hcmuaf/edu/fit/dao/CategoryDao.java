package vn.hcmuaf.edu.fit.dao;

import vn.hcmuaf.edu.fit.bean.Category;
import vn.hcmuaf.edu.fit.bean.Size;
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
        List<Category> selectFromCategory = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM category").mapToBean(Category.class).stream().collect(Collectors.toList());
        });
        return selectFromCategory;
    }

    public Category getCategory(int id) {
        Category category = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT name FROM category WHERE id = ?").bind(0, id).mapToBean(Category.class).one();
        });
        return category;
    }

    public void insertCategory(Category category){
        int id = getAllCategory().size() + 1;
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO category(id, name) VALUES (:id, name)").bind("name", category.getName()).bind("id", id).execute();
        });
    }

    public void updateCategory(Category category){
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE category SET name = :name WHERE id = :id").bind("name", category.getName()).bind("id", category.getId()).execute();
        });
    }

    public List<Category> getCategoryPerPage(int currentPage, int productPerPage) {
        int start;
        if (currentPage > 1) {
            start =  ((currentPage - 1) * productPerPage);
        } else {
            start = 0;
        }
        List<Category> category = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM category LIMIT :start, 5").bind("start", start).mapToBean(Category.class).stream().collect(Collectors.toList());
        });
        return category;
    }
    public void deleteCategory(int id) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("DELETE FROM category WHERE id = ?").bind(0, id).execute();
        });
    }
}
