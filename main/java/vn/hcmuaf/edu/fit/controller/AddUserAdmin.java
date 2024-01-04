package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.User;
import vn.hcmuaf.edu.fit.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.Date;


@WebServlet(name = "AddUserAdmin", value = "/addUserAdmin")
public class AddUserAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String sex = request.getParameter("gender");
        int day;
        int month;
        int year;
        int role;
        int verify;

        if (fullname == null || address == null || phone == null || sex == null || email == null || password == null){
            request.setAttribute("type", "error");
            request.setAttribute("information", "Lỗi null");
            request.getRequestDispatcher("showUserAdmin").forward(request, response);
        }else {
            try {
                role = Integer.parseInt(request.getParameter("role"));
                verify = Integer.parseInt(request.getParameter("verify"));
                day = Integer.parseInt(request.getParameter("day"));
                month= Integer.parseInt(request.getParameter("month"));
                year = Integer.parseInt(request.getParameter("year"));


                String dob = year+"-"+month+"-"+day;
                Date date = Date.valueOf(dob);

                User user = new User(0, email, password, verify, fullname, address, phone, sex, date,"", 0, role);
                UserService.getInstance().addUser(user);

                request.setAttribute("type", "success");
                request.setAttribute("information", "Thêm thành công");
                request.getRequestDispatcher("showUserAdmin").forward(request, response);
            }catch (NumberFormatException e ){
                request.setAttribute("type", "error");
                request.setAttribute("information", "Lỗi parse");
                request.getRequestDispatcher("showUserAdmin").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}