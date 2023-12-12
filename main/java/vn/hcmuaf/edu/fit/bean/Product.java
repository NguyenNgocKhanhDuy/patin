package vn.hcmuaf.edu.fit.bean;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private int minPrice;
    private int maxPrice;
    private double salePercent;
    private String img;
    private int hot;
    private String information;

    public Product() {
    }

    public Product(int id, String name, int minPrice, int maxPrice, double salePercent, String img, int hot, String information) {
        this.id = id;
        this.name = name;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.salePercent = salePercent;
        this.img = img;
        this.hot = hot;
        this.information = information;
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

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(double salePercent) {
        this.salePercent = salePercent;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", salePercent=" + salePercent +
                ", img='" + img + '\'' +
                ", hot=" + hot +
                ", information='" + information + '\'' +
                '}';
    }
}
