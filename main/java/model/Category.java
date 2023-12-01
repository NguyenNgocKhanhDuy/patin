package model;

import db.JDBiConnector;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Category implements Serializable {
    private int id;
    private String name;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public List<Category> getCategory() {
        List<Category> category = JDBiConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT name FROM category").mapToBean(Category.class)
                    .stream().collect(Collectors.toList());
        });
        return category;
    }

}
