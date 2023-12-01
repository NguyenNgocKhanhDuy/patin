package controller;

import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;


@WebServlet(name = "HomeServlet", value = "/home-servlet")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        Category category = new Category();

        List<Category> listCategory = category.getCategory();
        request.setAttribute("category", listCategory);

        List<Product> hotProduct = product.getHotProduct();
        request.setAttribute("hotProduct", hotProduct);

        List<Product> products = product.getProduct(12);
        request.setAttribute("products", products);
        request.getRequestDispatcher("/patin/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}