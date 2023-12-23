package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.Bill;
import vn.hcmuaf.edu.fit.bean.User;
import vn.hcmuaf.edu.fit.cart.Cart;
import vn.hcmuaf.edu.fit.cart.CartKey;
import vn.hcmuaf.edu.fit.services.BillService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "PaymentDetail", value = "/paymentDetail")
public class PaymentDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String payment = request.getParameter("payment");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User user = (User) request.getSession().getAttribute("auth");

        if (user == null || cart == null){
            response.getWriter().println("null");
        }else {
            request.setAttribute("payment", payment);
            request.setAttribute("user", user);

            List<CartKey> keys = new ArrayList<>();

            for (CartKey ck: cart.getData().keySet()) {
                keys.add(ck);
            }

            request.setAttribute("data", cart.getData());
            request.setAttribute("keys", keys);

            Bill bill = BillService.getInstance().getNewBill(user.getId());
            request.setAttribute("bill", bill);

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy, hh:mm:ss");
            String date = bill.getDate().format(dateTimeFormatter);
            request.setAttribute("date", date);

            request.getSession().removeAttribute("cart");

            request.getRequestDispatcher("payment_detail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}