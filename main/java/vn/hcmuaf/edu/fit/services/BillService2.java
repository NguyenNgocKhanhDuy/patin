package vn.hcmuaf.edu.fit.services;

import vn.hcmuaf.edu.fit.bean.*;
import vn.hcmuaf.edu.fit.cart.Cart;
import vn.hcmuaf.edu.fit.cart.CartKey;
import vn.hcmuaf.edu.fit.dao.BillDao;
import vn.hcmuaf.edu.fit.dao.BillDao2;
import vn.hcmuaf.edu.fit.dao.BillDetailDao;
import vn.hcmuaf.edu.fit.dao.BillDetailDao2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BillService2 {
    private static BillService2 instance;

    public BillService2() {
    }

    public static BillService2 getInstance() {
        if (instance == null) instance = new BillService2();
        return instance;
    }

    public boolean addBill(Bill2 bill) {
//        LocalDateTime date = getCurrentDate();

//        ArrayList<CartKey> keys = new ArrayList<>();
//        String s = "";
//        for (CartKey key: cart.getData().keySet()) {
//            keys.add(key);
//            s += key.getId();
//        }
//
//        String name = "DH"+id+"P"+s+"U"+user;
//        BillDao.getInstance().insertBill(id, name, date, state, paymnet, note, user);
//
//        for (int i = 0; i < keys.size(); i++) {
//            Product product = cart.getData().get(keys.get(i)).getProduct();
//            int quantity = cart.getData().get(keys.get(i)).getQuantity();
//            BillDetailDao.getInstance().insertBillDetail(id, product.getId(), keys.get(i).getSize(), keys.get(i).getColor(), quantity, quantity * product.getMinPrice());
//        }

        return BillDao2.getInstance().addBill(bill) == 1 ? true : false;

    }

    public String generateName(Bill2 bill, List<BillDetail2> listBillDetail) {
        String s = "";
        for (BillDetail2 b: listBillDetail) {
            s += "P"+b.getProduct().getProductDetail().getProduct().getId();
        }
        return "DH"+bill.getId()+s+"U"+bill.getUser().getId();
    }

    public boolean updateName(String name, int id){
        return BillDao2.getInstance().updateName(name, id) != 1 ? false : true;
    }

    public boolean addBillDetail(List<BillDetail2> listBillDetail) {
        boolean flag = true;
        for (BillDetail2 b: listBillDetail) {
            flag = BillDetailDao2.getInstance().addBillDetail(b) == 0 ? false : true;
            if (flag == false) return flag;
        }
        return flag;
    }


    public Bill2 getNewBill(int user) {
        return BillDao2.getInstance().getNewBill(user);
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

    public Bill getBill(int id){
        return BillDao.getInstance().getBill(id);
    }

    public List<BillDetail> getBillDetail(int id){
        return BillDetailDao.getInstance().getBillDetail(id);
    }

    public List<BillDetail2> getAllBillDetail(int id){
        return BillDetailDao2.getInstance().getAllBillDetail(id);
    }

}
