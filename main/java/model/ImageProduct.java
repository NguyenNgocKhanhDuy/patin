package model;

import java.io.Serializable;

public class ImageProduct implements Serializable {
    private int id;
    private String url;
    private int id_product;

    public ImageProduct() {
    }

    public ImageProduct(int id, String url, int id_product) {
        this.id = id;
        this.url = url;
        this.id_product = id_product;
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

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    @Override
    public String toString() {
        return "ImageProduct{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", id_product=" + id_product +
                '}';
    }
}
