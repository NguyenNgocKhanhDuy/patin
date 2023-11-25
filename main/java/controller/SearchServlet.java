package controller;

import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;


@WebServlet(name = "SearchServlet", value = "/search-servlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        String value = request.getParameter("search");
        List<Product> listProduct = product.searchProduct(value);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        int a = 0;
        for (Product p: listProduct) {
            if (a >= 3) break;
            a++;
            out.println("<li>\n" +
                    "      <a href=\"./ct_sanPham.html\">\n" +
                    "          <span class=\"item\">\n" +
                    "                <img src=\" "+ p.getImage().getUrl()+" \" alt=\"\">\n" +
                    "                <p class=\"name\"> "+ p.getName() +" </p>\n" +
                    "          </span>\n" +
                    "      </a>\n" +
                    "  </li>`");
        }
    }

}