package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.Product;
import vn.hcmuaf.edu.fit.bean.ProductMain;
import vn.hcmuaf.edu.fit.dao.ProductDao2;
import vn.hcmuaf.edu.fit.services.ProductService;
import vn.hcmuaf.edu.fit.services.ProductService2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;


@WebServlet(name = "Home", value = "/home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Product> listHotProduct = ProductService.getInstance().getHotProduct();
//        List<Product> listProduct = ProductService.getInstance().getProductHome();

        List<ProductMain> listHotProduct = ProductService2.getInstance().getHotProduct();
        List<ProductMain> listProduct = ProductService2.getInstance().getProductHome();

        request.setAttribute("hotProducts", listHotProduct);
        request.setAttribute("products", listProduct);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}