package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.services.MailService;
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
        String pass = request.getParameter("pass");
        String confirmPass = request.getParameter("confirmPass");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String information = "";

        information = RegisterService.getInstance().checkFormLogin(fullName, email, phone);

        if (!information.equals("")) {
            request.setAttribute("type", "alert");
        } else {
            String status = RegisterService.getInstance().register(email, pass, confirmPass, fullName, address, phone);
            if (status.equals("Đăng ký thành công")){
                request.getSession().setAttribute("timeStart", RegisterService.getInstance().getCurrentTime());
                request.getSession().setAttribute("email", email);
                request.getRequestDispatcher("verifyEmail.jsp").forward(request, response);
            }else {
                request.setAttribute("type", "error");
            }
            information = status;
        }
        request.setAttribute("information", information);
        request.setAttribute("email", email);
        request.setAttribute("pass", pass);
        request.setAttribute("confirmPass", confirmPass);
        request.setAttribute("fullname", fullName);
        request.setAttribute("address", address);
        request.setAttribute("phone", phone);

        request.getRequestDispatcher("register.jsp").forward(request, response);

    }
}