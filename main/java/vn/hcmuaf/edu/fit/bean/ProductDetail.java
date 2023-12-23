package vn.hcmuaf.edu.fit.bean;

import org.jdbi.v3.core.mapper.Nested;

import java.io.Serializable;
import java.util.List;

public class ProductDetail implements Serializable {
    private Size size;
    private Color color;
    private int quantity;
    private int price;

    public ProductDetail() {
    }

    public ProductDetail(Size size, Color color, int quantity, int price) {
        this.size = size;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
    }


    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "size=" + size +
                ", color=" + color +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
