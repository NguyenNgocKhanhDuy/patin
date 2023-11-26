package controller;

import model.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;


@WebServlet(name = "CategoryServlet", value = "/category-servlet")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain; charset=utf-8");
        Category category = new Category();
        List<Category> listCategory = category.getCategory();
        String nameCate = "";
        for (Category c: listCategory) {
            nameCate += c.getName() +",";
        }
        PrintWriter out = response.getWriter();
        out.write(nameCate.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}