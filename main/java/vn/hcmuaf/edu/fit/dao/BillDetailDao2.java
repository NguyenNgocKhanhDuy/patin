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

    public int addBillDetail(BillDetail2 billDetail){
        Integer i = JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO bill_detail(bill_id, product_id, size_id, color_id, quantity, price) VALUES (:bill, :product, :size, :color, :quantity, :price)")
                    .bind("bill", billDetail.getBill().getId()).bind("product", billDetail.getProduct().getProductDetail().getProduct().getId()).bind("size", billDetail.getSize().getId()).bind("color", billDetail.getColor().getId()).bind("quantity", billDetail.getQuantity()).bind("price", billDetail.getPrice())
                    .execute();
        });
        return i;
    }

    public List<BillDetail2> getAllBillDetail(int id){
        List<BillDetail2> billDetails = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT bill.name as bill_name, bill.date as bill_date, user.email as bill_user_email, user.phone as bill_user_phone, quantity, price, size.id as size_id, size.name as size_name, color.id as color_id, color.name as color_name, product.id as product_product_detail_product_id, product.name as product_product_detail_product_name " +
                    "FROM user JOIN bill on bill.user_id = user.id JOIN bill_detail on bill.id = bill_detail.bill_id JOIN product on product.id = bill_detail.product_id JOIN size ON bill_detail.size_id = size.id JOIN color ON bill_detail.color_id = color.id " +
                    "WHERE bill_id = :id").bind("id", id).mapToBean(BillDetail2.class).stream().collect(Collectors.toList());
        });
        return billDetails;
    }
}
