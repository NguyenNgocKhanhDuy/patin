package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.services.MailService;
import vn.hcmuaf.edu.fit.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;


@WebServlet(name = "VerifyEmail", value = "/doVerifyEmail")
public class VerifyEmail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long timeEnd = System.currentTimeMillis();
        long timeStart = Long.parseLong(request.getParameter("timeStart"));
        String email = (String) request.getSession().getAttribute("email");
        if (MailService.getInstance().isValidCode(timeStart, timeEnd)){
            UserService.getInstance().verifyMail(email);
            request.getRequestDispatcher("/patin/login.jsp").forward(request, response);
        }else {
            request.setAttribute("type", "error");
            request.setAttribute("information", "Mã xác minh không đúng");
            request.getRequestDispatcher("/patin/verifyEmail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}