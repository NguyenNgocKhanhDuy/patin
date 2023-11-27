package controller;

import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;


@WebServlet(name = "ShowHotProductServlet", value = "/showHotProduct-servlet")
public class ShowHotProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Product product = new Product();
        List<Product> list = product.getHotProduct();
        PrintWriter out = response.getWriter();
        for (Product p: list) {
            out.println("<div class=\"product-item\">\n" +
                    "         <a href=\"./ct_sanPham.html\">\n" +
                    "            <img src= \" "+ p.getImage().getUrl() +" \" >\n" +
                    "            <h4 class=\"name\"> "+ p.getName() +" </h4>\n" +
                    "            <span class=\"price-section\"> "+ p.getSalePrice() +"  \n" +
                    "                  <h5 class=\"price\"> "+ p.getOriginPrice() +" </h5>\n" +
                    "            </span> \n" +
                    "            <ul>\n" +
                    "                 <li><i class=\"fa-solid fa-heart like\"></i></li>\n" +
                    "                 <li><i class=\"fa-solid fa-cart-shopping cart\"></i></li>\n" +
                    "            </ul>\n" +
                    "         </a>\n" +
                    "   </div>");
        }
    }

}