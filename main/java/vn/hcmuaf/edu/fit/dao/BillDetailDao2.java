package vn.hcmuaf.edu.fit.dao;

import vn.hcmuaf.edu.fit.bean.BillDetail;
import vn.hcmuaf.edu.fit.bean.BillDetail2;
import vn.hcmuaf.edu.fit.db.JDBIConnector;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class BillDetailDao2 implements Serializable {
    private static BillDetailDao2 instance;

    public BillDetailDao2() {
    }

    public static BillDetailDao2 getInstance() {
        if (instance == null) instance = new BillDetailDao2();
        return instance;
    }

    public void insertBillDetail(int idBill, int idProduct, int idSize, int idColor, int quantity, int price){
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO bill_detail(bill_id, product_id, size_id, color_id, quantity, price) VALUES (:bill, :product, :size, :color, :quantity, :price)")
                    .bind("bill", idBill).bind("product", idProduct).bind("size", idSize).bind("color", idColor).bind("quantity", quantity).bind("price", price)
                    .execute();
        });
    }

    public List<BillDetail2> getBillDetail(int id){
        List<BillDetail2> billDetails = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT bill.name as bill_name, bill.date as bill_date, user.email as bill_user_email , quantity, price,  size.id as size_id, size.name as size_name, color.id as color_id, color.name as color_name, product.id as product_id, product.name as product_name " +
                    "FROM user JOIN bill on bill.user_id = user.id JOIN bill_detail on bill.id = bill_detail.bill_id JOIN product on product.id = bill_detail.product_id JOIN size ON bill_detail.size_id = size.id JOIN color ON bill_detail.color_id = color.id " +
                    "WHERE bill_id = :id").bind("id", id).mapToBean(BillDetail2.class).stream().collect(Collectors.toList());
        });
        return billDetails;
    }
}
