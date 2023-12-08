package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.services.RegisterService;
import vn.hcmuaf.edu.fit.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;


@WebServlet(name = "Register", value = "/doRegister")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String errorInformation = "";

        errorInformation = RegisterService.getInstance().checkFormLogin(fullName, email, phone);

        if (!errorInformation.equals("")) {
            request.setAttribute("type", "alert");
            request.setAttribute("errorInformation", errorInformation);
        } else {
            if (UserService.getInstance().isUserExists(email)){
                request.setAttribute("type", "error");
                errorInformation = "Đã tồn tại tài khoản sử dụng email";
                request.setAttribute("errorInformation", errorInformation);
            }else {
                response.sendRedirect("/patin_shop/patin/login.jsp");
            }
        }
        request.getRequestDispatcher("/patin/register.jsp").forward(request, response);
    }
}