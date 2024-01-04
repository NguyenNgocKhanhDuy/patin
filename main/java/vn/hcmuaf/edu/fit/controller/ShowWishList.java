package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.Product;
import vn.hcmuaf.edu.fit.bean.User;
import vn.hcmuaf.edu.fit.services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;


@WebServlet(name = "ShowWishList", value = "/showWishList")
public class ShowWishList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id ;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            User user = (User) request.getSession().getAttribute("auth");
            List<Product> productList = ProductService.getInstance().getWishList(user.getId(), id);
            request.setAttribute("list", productList);
            request.getRequestDispatcher("wishlist.jsp").forward(request, response);
        }catch (NumberFormatException e){

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}