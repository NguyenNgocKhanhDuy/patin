package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;


@WebServlet(name = "Cart", value = "/cart")
public class Cart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("auth");
        if (user == null) {
            request.setAttribute("type", "error");
            request.setAttribute("information", "Đăng nhập để tiếp tục");
            request.getRequestDispatcher("productDetail").forward(request, response);
        }else {
            int id = Integer.parseInt(request.getParameter("productID"));
            int size = Integer.parseInt(request.getParameter("size"));
            int color = Integer.parseInt(request.getParameter("colors"));

            response.getWriter().println("id "+id);
            response.getWriter().println("size "+size);
            response.getWriter().println("color "+color);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}