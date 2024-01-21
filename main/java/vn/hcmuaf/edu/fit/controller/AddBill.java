package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.*;
import vn.hcmuaf.edu.fit.cart.Cart;
import vn.hcmuaf.edu.fit.cart.CartKey;
import vn.hcmuaf.edu.fit.cart.CartProduct;
import vn.hcmuaf.edu.fit.dao.ProductDao2;
import vn.hcmuaf.edu.fit.services.BillService;
import vn.hcmuaf.edu.fit.services.BillService2;
import vn.hcmuaf.edu.fit.services.ProductService2;
import vn.hcmuaf.edu.fit.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "AddBill", value = "/addBill")
public class AddBill extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String note = request.getParameter("note");

        if (note == null) note = "";


        String information = UserService.getInstance().checkForm(fullName, email, phone, address);

        if (!"".equals(information)) {
            request.setAttribute("type", "error");
            request.setAttribute("information", information);
            request.getRequestDispatcher("/payment").forward(request, response);
        } else {
            String payment = request.getParameter("payment");
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            User user = (User) request.getSession().getAttribute("auth");

            if (user == null || cart == null) {
                request.setAttribute("type", "error");
                request.setAttribute("information", "Lỗi");
                request.getRequestDispatcher("showCart").forward(request, response);
            } else {
                request.setAttribute("payment", payment);
                user.setFullName(fullName);
                user.setPhone(phone);
                user.setAddress(address);
                UserService.getInstance().updateUser(user);
//                BillService.getInstance().insertBill(payment, note, user.getId(), cart);

                Bill2 bill = new Bill2(0, "", BillService2.getInstance().getCurrentDate(), "Đang xử lý", payment, note, user);

                List<BillDetail2> listBill = new ArrayList<>();

                BillService2.getInstance().addBill(bill);

                Bill2 newBill = BillService2.getInstance().getNewBill(user.getId());

                for (CartKey ck : cart.getData().keySet()) {
                    BillDetail2 billDetail = new BillDetail2();
                    ProductMain product = cart.getData().get(ck).getProduct();
                    Size size = new Size();
                    Color color = new Color();
                    size.setId(ck.getSize());
                    color.setId(ck.getColor());

                    billDetail.setBill(newBill);
                    billDetail.setColor(color);
                    billDetail.setSize(size);
                    billDetail.setProduct(product);
                    billDetail.setPrice(product.getProductDetail().getPrice());
                    billDetail.setQuantity(cart.getData().get(ck).getQuantity());

                    ProductService2.getInstance().reduceQuantity(ck.getId(), ck.getSize(), ck.getColor(), cart.getData().get(ck).getQuantity());

                    listBill.add(billDetail);
                }

                BillService2.getInstance().addBillDetail(listBill);
                BillService2.getInstance().updateName(BillService2.getInstance().generateName(newBill, listBill), newBill.getId());

                request.getRequestDispatcher("paymentDetail").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}