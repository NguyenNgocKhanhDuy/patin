package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.services.MailService;
import vn.hcmuaf.edu.fit.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;


@WebServlet(name = "SendMailContact", value = "/sendMailContact")
public class SendMailContact extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullname");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        String information = UserService.getInstance().checkForm(fullName, email);

        if (!"".equals(information)){
            request.setAttribute("type", "error");
            request.setAttribute("information", information);
            request.getRequestDispatcher("contact.jsp").forward(request, response);
        }

        String editMess = "From: "+fullName+"\nEmail: "+email+"\n"+message;

        MailService.getInstance().sendMail("21130035@st.hcmuaf.edu.vn", editMess);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}