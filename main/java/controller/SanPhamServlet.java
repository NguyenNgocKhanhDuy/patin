package controller;

import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "SanPhamServlet", value = "/sanPham-servlet")
public class SanPhamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        Category category = new Category();

        List<Category> listCategory = category.getCategory();
        request.setAttribute("category", listCategory);

        List<Product> hotProduct = product.getHotProduct();
        request.setAttribute("hotProduct", hotProduct);

        int productPerPage = 15;
        int currentPage = 0;
        try {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));

        }catch (NumberFormatException e) {
            currentPage = 1;
        }

        request.setAttribute("currentPage", currentPage);

        List<Product> products = new ArrayList<>();

        String sort = request.getParameter("sort");
        int min;
        int max;

        try {
            min = Integer.parseInt(request.getParameter("input-min"));
            max = Integer.parseInt(request.getParameter("input-max"));
        }catch (NumberFormatException e ) {
            min = 0;
            max = 15000000;
        }

        boolean isFilterColor = false;
        String[] colors = request.getParameterValues("color");
        if (colors == null) {
            colors = new String[6];
            for (int i = 0; i < colors.length; i++) {
                colors[i] = "0";
            }
        }

        for (int i = 0; i < colors.length; i++) {
            if (!colors[i].equals("0")) {
                isFilterColor = true;
                break;
            }
        }

        if (sort == null) sort = "";

//        if (!sort.equals("")) {
            if ((min != 0 || max != 15000000) && isFilterColor == false) {
                products = product.filterProduct(sort, 1, min, max);
            } else if (isFilterColor == true && (min == 0 && max == 15000000)) {
                products = product.filterColorProduct(sort, 1, colors);
            } else if ((min != 0 || max != 15000000) && isFilterColor == true){
                products = product.filterPriceColorProduct(sort, 1,colors, min, max);
            }else{
                products = product.sortProduct(sort, currentPage);
            }
            if (sort.equals("asc")){
                request.setAttribute("selectASC", "selected");
            }else if (sort.equals("desc")){
                request.setAttribute("selectDESC", "selected");
            }
//        }
//        else if (sort.equals("desc")) {
//            if ((min != 0 || max != 15000000)  && isFilterColor == false) {
//                products = product.filterProduct(sort, 1, min, max);
//            } else if (isFilterColor == true && (min == 0 && max == 15000000)) {
//                products = product.filterColorProduct(sort, 1, colors);
//            } else if ((min != 0 || max != 15000000) && isFilterColor == true) {
//                products = product.filterPriceColorProduct(sort, 1,colors, min, max);
//            } else {
//                products = product.sortProduct(sort, currentPage);
//            }
//            request.setAttribute("selectDESC", "selected");
//        }
//        else {
//            if ((min != 0 || max != 15000000)  && isFilterColor == false) {
//                products = product.filterProduct("", 1, min, max);
//            } else if (isFilterColor == true && (min == 0 && max == 15000000)) {
//                products = product.filterColorProduct("", 1, colors);
//            } else if ((min != 0 || max != 15000000) && isFilterColor == true) {
//                products = product.filterPriceColorProduct("", 1,colors, min, max);
//            } else {
//                products = product.getProduct(currentPage);
//            }
//        }

        int totalPage = (int) Math.ceil(products.size() / productPerPage);

        request.setAttribute("totalPage", totalPage);

        request.setAttribute("min", min);
        request.setAttribute("max", max);

        request.setAttribute("sort", sort);

        request.setAttribute("products", products);

        request.getRequestDispatcher("/patin/sanPham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}