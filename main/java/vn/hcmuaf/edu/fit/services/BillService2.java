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

    public List<Bill2> getAllBill() {
        return BillDao2.getInstance().getAllBill();
    }

    public List<Bill2> getAllBillByUser(int id) {
        return BillDao2.getInstance().getAllBillByUser(id);
    }

    public List<Bill2> getAllBillByUserAndStatus(int id, String status) {
        return BillDao2.getInstance().getAllBillByUserAndStatus(id, status);
    }

    public LocalDateTime getCurrentDate() {
        LocalDateTime localDate = LocalDateTime.now();
        return localDate;
    }

    public List<Bill2> getBillPerPage(int currentPage, int productPerPage){
        int start;
        if (currentPage > 1) {
            start =  ((currentPage - 1) * productPerPage);
        } else {
            start = 0;
        }
        return BillDao2.getInstance().getBillPerPage(start);
    }

    public List<Bill2> getBillPerPageByUser(int currentPage, int productPerPage, int id){
        int start;
        if (currentPage > 1) {
            start =  ((currentPage - 1) * productPerPage);
        } else {
            start = 0;
        }
        return BillDao2.getInstance().getBillPerPageByUser(start, id);
    }

    public List<Bill2> getBillPerPageByUserAndStatus(int currentPage, int productPerPage, int id, String status){
        int start;
        if (currentPage > 1) {
            start =  ((currentPage - 1) * productPerPage);
        } else {
            start = 0;
        }
        return BillDao2.getInstance().getBillPerPageByUserAndStatus(start, id, status);
    }

    public Bill2 getBill(int id){
        return BillDao2.getInstance().getBill(id);
    }

    public List<BillDetail2> getBillDetail(int id){
        return BillDetailDao2.getInstance().getAllBillDetail(id);
    }

    public List<BillDetail2> getAllBillDetail(int id){
        return BillDetailDao2.getInstance().getAllBillDetail(id);
    }


    public boolean updateStatusBill(int id, String status) {
        return BillDao2.getInstance().updateStatusBill(id, status);
    }

    public boolean deleteBill(int id) {
        return BillDao2.getInstance().deleteBill(id) && BillDetailDao2.getInstance().deleteAllBillDetail(id);
    }
}
