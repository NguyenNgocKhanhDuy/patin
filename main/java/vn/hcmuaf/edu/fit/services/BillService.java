package vn.hcmuaf.edu.fit.services;

import vn.hcmuaf.edu.fit.bean.Bill;
import vn.hcmuaf.edu.fit.bean.Product2;
import vn.hcmuaf.edu.fit.cart.Cart;
import vn.hcmuaf.edu.fit.cart.CartKey;
import vn.hcmuaf.edu.fit.dao.BillDao;
import vn.hcmuaf.edu.fit.dao.BillDetailDao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BillService {
    private static BillService instance;

    public BillService() {
    }

    public static BillService getInstance() {
        if (instance == null) instance = new BillService();
        return instance;
    }

    public int billSize() {
        return BillDao.getInstance().billSize();
    }

    public void insertBill(String paymnet, String note, int user, Cart cart) {
        String state = "Đang xử lý";
        LocalDateTime date = getCurrentDate();
        int id = billSize()+1;

        ArrayList<CartKey> keys = new ArrayList<>();
        String s = "";
        for (CartKey key: cart.getData().keySet()) {
            keys.add(key);
            s += key.getId();
        }

        String name = "DH"+id+"P"+s+"U"+user;
        BillDao.getInstance().insertBill(id, name, date, state, paymnet, note, user);

        for (int i = 0; i < keys.size(); i++) {
            Product2 product = cart.getData().get(keys.get(i)).getProduct();
            int quantity = cart.getData().get(keys.get(i)).getQuantity();
            BillDetailDao.getInstance().insertBillDetail(id, product.getId(), keys.get(i).getSize(), keys.get(i).getColor(), quantity, quantity * product.getMinPrice());
        }

    }


    public Bill getNewBill(int user) {
        return BillDao.getInstance().getNewBill(user);
    }

    public List<Bill> getAllBill() {
        return BillDao.getInstance().getAllBill();
    }

    public LocalDateTime getCurrentDate() {
        LocalDateTime localDate = LocalDateTime.now();
        return localDate;
    }

    public List<Bill> getBillPerPage(int currentPage, int productPerPage){
        int start;
        if (currentPage > 1) {
            start =  ((currentPage - 1) * productPerPage);
        } else {
            start = 0;
        }
        return BillDao.getInstance().getBillPerPage(start);
    }

}
