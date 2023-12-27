package vn.hcmuaf.edu.fit.controller;

import com.google.gson.Gson;
import vn.hcmuaf.edu.fit.bean.User;
import vn.hcmuaf.edu.fit.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;


@WebServlet(name = "ShowModalAdmin", value = "/showModalAdmin")
public class ShowModalAdmin extends HttpServlet {
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID;
        try {
            userID = Integer.parseInt(request.getParameter("userID"));
            response.setContentType("application/json");
            User user = UserService.getInstance().getUserByID(userID);
            response.getWriter().println(gson.toJson(user));

        }catch (NumberFormatException e) {
            userID = 0;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}