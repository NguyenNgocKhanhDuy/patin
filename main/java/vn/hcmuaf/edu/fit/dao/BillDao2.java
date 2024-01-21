package vn.hcmuaf.edu.fit.dao;

import vn.hcmuaf.edu.fit.bean.Bill;
import vn.hcmuaf.edu.fit.bean.Bill2;
import vn.hcmuaf.edu.fit.db.JDBIConnector;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BillDao2 {
    private static BillDao2 instance;

    public BillDao2() {
    }

    public static BillDao2 getInstance() {
        if(instance == null) instance = new BillDao2();
        return instance;
    }


    public int addBill(Bill2 bill) {
        Integer i = JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO bill(name, date, status, payment, note, user_id) VALUES (:name, :date, :status, :payment, :note, :user)")
                    .bind("name", bill.getName()).bind("date", bill.getDate()).bind("status", bill.getStatus()).bind("payment", bill.getPayment())
                    .bind("note", bill.getNote()).bind("user", bill.getUser().getId()).execute();
        });
        return i;
    }


    public Bill2 getNewBill(int idUser) {
        Bill2 bill = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM bill WHERE user_id = :user ORDER BY date DESC LIMIT 1").bind("user", idUser).mapToBean(Bill2.class).one();
        });
        return bill;
    }

    public List<Bill2> getAllBill(){
        List<Bill2> bills = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM bill").mapToBean(Bill2.class).stream().collect(Collectors.toList());
        });
        return bills;

    }

    public List<Bill2> getBillPerPage(int start) {
        List<Bill2> bills = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT bill.*, user.email as user_email FROM bill JOIN user ON bill.user_id = user.id LIMIT :start, 5").bind("start", start).mapToBean(Bill2.class).stream().collect(Collectors.toList());
        });
        return bills;
    }

    public Bill2 getBill(int id) {
        Bill2 bill = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT bill.*, user.fullName as user_fullName, user.email as user_email, user.phone as user_phone, user.address as user_address " +
                    "FROM bill JOIN user ON bill.user_id = user.id where bill.id = :id").bind("id", id).mapToBean(Bill2.class).one();
        });
        return bill;
    }

    public int updateName(String name, int id) {
        Integer i = JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE bill SET name = ? WHERE id = ?").bind(0, name).bind(1, id).execute();
        });
        return i;
    }

}
