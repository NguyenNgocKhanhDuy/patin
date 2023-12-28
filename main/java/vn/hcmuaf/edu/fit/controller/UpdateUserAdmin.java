package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.User;
import vn.hcmuaf.edu.fit.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.Date;


@WebServlet(name = "UpdateUserAdmin", value = "/updateUserAdmin")
public class UpdateUserAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String sex = request.getParameter("gender");
        int day;
        int month;
        int year;
        int role;
        int verify;

        if (fullname == null || address == null || phone == null || sex == null){
            request.setAttribute("type", "error");
            request.setAttribute("information", "Lỗi");
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }else {
            try {
                id = Integer.parseInt(request.getParameter("id"));
                day = Integer.parseInt(request.getParameter("day"));
                month= Integer.parseInt(request.getParameter("month"));
                year = Integer.parseInt(request.getParameter("year"));
                role = Integer.parseInt(request.getParameter("role"));
                verify = Integer.parseInt(request.getParameter("verify"));

                User user = UserService.getInstance().getUserByID(id);
                user.setFullName(fullname);
                user.setAddress(address);
                user.setPhone(phone);
                user.setSex(sex);
                user.setVerify(verify);
                user.setRole(role);
                String dob = year+"-"+month+"-"+day;
                Date date = Date.valueOf(dob);
                user.setDob(date);

                UserService.getInstance().updateUser(user);

                request.setAttribute("type", "success");
                request.setAttribute("information", "Cập nhật thành công");
                request.getRequestDispatcher("showAdmin").forward(request, response);
            }catch (NumberFormatException e ){
                request.setAttribute("type", "error");
                request.setAttribute("information", "Lỗi");
                request.getRequestDispatcher("showAdmin").forward(request, response);
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}