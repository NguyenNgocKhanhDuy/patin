package vn.hcmuaf.edu.fit.controller;

import com.google.gson.Gson;
import model.Category;
import vn.hcmuaf.edu.fit.dao.CategoryDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ShowCategory", value = "/showCategory")
public class ShowCategory extends HttpServlet {
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> listCategory = CategoryDao.getInstance().getCategory();
        response.setContentType("application/json");
        response.getWriter().println(gson.toJson(listCategory));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}