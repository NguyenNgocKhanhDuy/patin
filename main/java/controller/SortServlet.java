package controller;

import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "SortServlet", value = "/sort-servlet")
public class SortServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();

        List<Product> list = new ArrayList<>();

        String sort = request.getParameter("sort");

        if (sort == null) sort = "";

        if (sort.equals("auto")) {
            request.getRequestDispatcher("sanPham-servlet").forward(request, response);
        } else if (sort.equals("asc")) {
            list = product.getSortProduct(sort);
            request.setAttribute("selectASC", "selected");
        } else if (sort.equals("desc")) {
            list = product.getSortProduct(sort);
            request.setAttribute("selectDESC", "selected");
        }


        request.setAttribute("products", list);
        request.getRequestDispatcher("/patin/sanPham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}