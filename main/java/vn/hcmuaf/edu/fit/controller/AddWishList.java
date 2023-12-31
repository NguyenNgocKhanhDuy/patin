package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.User;
import vn.hcmuaf.edu.fit.services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;


@WebServlet(name = "AddWishList", value = "/addWishList")
public class AddWishList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;

        try {
            id = Integer.parseInt(request.getParameter("productID"));

            User user = (User) request.getSession().getAttribute("auth");

            if (user == null) {
                request.setAttribute("type", "error");
                request.setAttribute("information", "Đăng nhập để tiếp tục");
                request.getRequestDispatcher("productDetail?productID="+id).forward(request, response);
            }else {
                ProductService.getInstance().addWishList(user.getId(), id);
                response.sendRedirect("showWishList?id="+id);
            }

        }catch (NumberFormatException e ){

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}