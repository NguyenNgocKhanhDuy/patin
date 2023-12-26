package vn.hcmuaf.edu.fit.dao;

import vn.hcmuaf.edu.fit.bean.Bill;
import vn.hcmuaf.edu.fit.db.JDBIConnector;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BillDao {
    private static BillDao instance;

    public BillDao() {
    }

    public static BillDao getInstance() {
        if(instance == null) instance = new BillDao();
        return instance;
    }

    public int billSize(){
        Integer i = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT COUNT(*) FROM bill").mapTo(Integer.class).one();
        });
        return i;
    }

    public void insertBill(int id, String name, LocalDateTime date, String state, String payment, String note, int user) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO bill(id, name, date, state, payment, note, user_id) VALUES (:id, :name, :date, :state, :payment, :note, :user)")
                    .bind("id", id).bind("name", name).bind("date", date).bind("state", state).bind("payment", payment)
                    .bind("note", note).bind("user", user).execute();
        });
    }


    public Bill getNewBill(int idUser) {
        Bill bill = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM bill WHERE user_id = :user ORDER BY date DESC LIMIT 1").bind("user", idUser).mapToBean(Bill.class).one();
        });
        return bill;
    }

    public List<Bill> getAllBill(){
        List<Bill> bills = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM bill").mapToBean(Bill.class).stream().collect(Collectors.toList());
        });
        return bills;

    }

}
