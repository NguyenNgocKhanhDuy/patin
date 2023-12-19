package vn.hcmuaf.edu.fit.cart;

import vn.hcmuaf.edu.fit.bean.Product;

public class CartProduct {
    private Product product;
    private int quantity;


    public CartProduct() {
    }

    public CartProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartProduct{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    public boolean increase(int num) {
        int temp = quantity;
        temp += num;
        if (product.getQuantity() < temp) return false;
        quantity = temp;
        return true;
    }

    public boolean decreaseOne() {
        int temp = quantity;
        temp--;
        if (temp <= 0) return false;
        quantity = temp;
        return true;
    }

    public boolean increaseOne() {
        int temp = quantity;
        temp++;
        if (temp > product.getQuantity()) return false;
        quantity = temp;
        return true;
    }

//    public boolean update(int num) {
//        if (num > product.getQuantity()) return false;
//        quantity = num;
//        return true;
//    }
}
