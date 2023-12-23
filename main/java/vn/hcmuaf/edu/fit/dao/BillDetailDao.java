package vn.hcmuaf.edu.fit.dao;

import vn.hcmuaf.edu.fit.db.JDBIConnector;

import java.io.Serializable;

public class BillDetailDao implements Serializable {
    private static BillDetailDao instance;

    public BillDetailDao() {
    }

    public static BillDetailDao getInstance() {
        if (instance == null) instance = new BillDetailDao();
        return instance;
    }

    public void insertBillDetail(int idBill, int idProduct, int idSize, int idColor, int quantity, int price){
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO bill_detail(bill_id, product_id, size_id, color_id, quantity, price) VALUES (:bill, :product, :size, :color, :quantity, :price)")
                    .bind("bill", idBill).bind("product", idProduct).bind("size", idSize).bind("color", idColor).bind("quantity", quantity).bind("price", price)
                    .execute();
        });
    }
}
