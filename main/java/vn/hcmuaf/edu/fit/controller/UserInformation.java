package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.User;
import vn.hcmuaf.edu.fit.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet(name = "UserInformation", value = "/userInformation")
public class UserInformation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String sex = request.getParameter("gender");
        int day ;
        int month ;
        int year ;
        User user = (User) request.getSession().getAttribute("auth");

        if (fullName == null || phone == null || sex == null || user == null){
            request.setAttribute("type", "error");
            request.setAttribute("information", "Lỗi");
            request.getRequestDispatcher("account.jsp").forward(request, response);
        }

        else if (!"valid".equals(UserService.getInstance().checkFullName(fullName))){
            request.setAttribute("type", "error");
            request.setAttribute("information", UserService.getInstance().checkFullName(fullName));
            request.getRequestDispatcher("account.jsp").forward(request, response);
        }
        else if (!"valid".equals(UserService.getInstance().checkPhone(phone))){
            request.setAttribute("type", "error");
            request.setAttribute("information", UserService.getInstance().checkPhone(phone));
            request.getRequestDispatcher("account.jsp").forward(request, response);
        }else {
            try {
                day = Integer.parseInt(request.getParameter("day"));
                month = Integer.parseInt(request.getParameter("month"));
                year = Integer.parseInt(request.getParameter("year"));

                String information = UserService.getInstance().checkDOB(day, month, year);
                if (!"".equals(information)){
                    request.setAttribute("type", "error");
                    request.setAttribute("information", information);
                    request.getRequestDispatcher("account.jsp").forward(request, response);
                }else {
                    user.setFullName(fullName);
                    user.setPhone(phone);
                    user.setSex(sex);
                    String dob =year+"-"+month+"-"+day;
                    Date date = Date.valueOf(dob);
                    user.setDob(date);
//                    String dob =day+"/"+month+"/"+year+" 00:00";
//                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//                    LocalDateTime dateTime = LocalDateTime.parse(dob, formatter);
//                    user.setDob(dateTime);
                    UserService.getInstance().updateUser(user);
                    request.setAttribute("type", "sucess");
                    request.setAttribute("information", "Cập nhật thông tin thành công");
                    request.getRequestDispatcher("account.jsp").forward(request, response);
                }

            }catch (NumberFormatException e ){
                day = 0;
                month = 0;
                year = 0;
                String information = UserService.getInstance().checkDOB(day, month, year);
                request.setAttribute("type", "error");
                request.setAttribute("information", information);
                request.getRequestDispatcher("account.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}