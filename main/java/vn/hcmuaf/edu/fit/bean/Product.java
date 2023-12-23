package vn.hcmuaf.edu.fit.bean;

import org.jdbi.v3.core.mapper.Nested;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private int id;
    private String name;
    private int hot;
    private double salePercent;
    private String information;
    @Nested
    private ProductDetail product_detail;
    @Nested
    private ImageProduct ImageProduct;

    public Product() {
    }

    public Product(int id, String name, int hot, double salePercent, String information, ProductDetail product_detail, ImageProduct ImageProduct) {
        this.id = id;
        this.name = name;
        this.hot = hot;
        this.salePercent = salePercent;
        this.information = information;
        this.product_detail = product_detail;
        this.ImageProduct = ImageProduct;
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

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public double getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(double salePercent) {
        this.salePercent = salePercent;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
    @Nested()
    public ProductDetail getProduct_detail() {
        return product_detail;
    }
    @Nested()
    public void setProduct_detail(ProductDetail product_detail) {
        this.product_detail = product_detail;
    }

    @Nested
    public ImageProduct getImageProduct() {
        return ImageProduct;
    }
    @Nested

    public void setImageProduct(ImageProduct ImageProduct) {
        this.ImageProduct = ImageProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hot=" + hot +
                ", salePercent=" + salePercent +
                ", information='" + information + '\'' +
                ", product_detail=" + product_detail +
                ", ImageProduct=" + ImageProduct +
                '}';
    }
}
