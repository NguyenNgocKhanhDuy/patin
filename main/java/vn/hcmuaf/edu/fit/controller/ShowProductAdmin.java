package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.Product;
import vn.hcmuaf.edu.fit.services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ShowProductAdmin", value = "/showProductAdmin")
public class ShowProductAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> allProduct = ProductService.getInstance().getAllProduct();
        request.setAttribute("allProduct", allProduct);


        int currentPage;
        try {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }catch (NumberFormatException e) {
            currentPage = 1;
        }

        String href = "showProductAdmin?";
        request.setAttribute("href", href);

        double productPerPage = 5.0;

        int totalPage = (int) Math.ceil(allProduct.size() / productPerPage);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("productPerPage", (int) productPerPage);

        List<Product> products = ProductService.getInstance().getProductPerPage(currentPage, "", (int) productPerPage);
        request.setAttribute("products", products);

        request.setAttribute("type", request.getAttribute("type"));
        request.setAttribute("information", request.getAttribute("information"));

        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}