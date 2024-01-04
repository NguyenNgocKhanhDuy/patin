package vn.hcmuaf.edu.fit.dao;

import vn.hcmuaf.edu.fit.bean.BillDetail;
import vn.hcmuaf.edu.fit.db.JDBIConnector;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<BillDetail> getBillDetail(int id){
        List<BillDetail> billDetails = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT quantity, price,  size.id as size_id, size.name as size_name, color.id as color_id, color.name as color_name, product.id as product_id, product.name as product_name " +
                    "FROM product JOIN bill_detail on product.id = bill_detail.product_id JOIN size ON bill_detail.size_id = size.id JOIN color ON bill_detail.color_id = color.id " +
                    "WHERE bill_id = :id").bind("id", id).mapToBean(BillDetail.class).stream().collect(Collectors.toList());
        });
        return billDetails;
    }
}
