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

        int productPerPage = 15;
        int currentPage = 0;
        try {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));

        }catch (NumberFormatException e) {
            currentPage = 1;
        }

        int totalPage = (int) Math.ceil(product.getAllProduct().size() / productPerPage);

        request.setAttribute("totalPage", totalPage);

        request.setAttribute("currentPage", currentPage);

        String sort = request.getParameter("sort");

        if (sort == null) sort = "";

        if (sort.equals("auto")) {
            request.getRequestDispatcher("sanPham-servlet").forward(request, response);
        } else if (sort.equals("asc")) {
            list = product.sortProduct(sort, currentPage);
            request.setAttribute("selectASC", "selected");
        } else if (sort.equals("desc")) {
            list = product.sortProduct(sort, currentPage);
            request.setAttribute("selectDESC", "selected");
        }


        request.setAttribute("products", list);
        request.getRequestDispatcher("/patin/list_product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}