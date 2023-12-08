package model;

import db.JDBIConnector;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class Image implements Serializable {
    private int id;
    private String url;

    public Image() {
    }

    public Image(int id, String url) {
        this.id = id;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Image> getPatin() {
        List<Image> selectNameFromImage = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT url from image_product").mapToBean(Image.class).stream().collect(Collectors.toList());
        });
        return selectNameFromImage;
    }

}
