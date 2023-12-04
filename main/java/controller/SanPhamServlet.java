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
        List<Product> allProductOfType = new ArrayList<>();

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

        String href = "sanPham-servlet?";

//        if (!sort.equals("")) {
            if ((min != 0 || max != 15000000) && isFilterColor == false) {
                products = product.filterPriceProduct(sort, 1, min, max);
                allProductOfType = product.allFilterPriceProduct(min, max);
                href += "min="+min+"&max="+max;
            } else if (isFilterColor == true && (min == 0 && max == 15000000)) {
                products = product.filterColorProduct(sort, 1, colors);
                allProductOfType = product.allFilterColorProduct(colors);
                String txt = "";
                for (int i = 0; i < colors.length; i++) {
                    if (i==0) txt += "color="+colors[i];
                    txt += "&color="+colors[i];
                }
                href += txt;
            } else if ((min != 0 || max != 15000000) && isFilterColor == true){
                products = product.filterPriceColorProduct(sort, 1,colors, min, max);
                allProductOfType = product.allFilterPriceColorProduct(colors, min, max);
                String txt = "";
                for (int i = 0; i < colors.length; i++) {
                    txt += "&color="+colors[i];
                }
                href += "min="+min+"&max="+max+txt;
            }else{
                products = product.sortProduct(sort, currentPage);
                allProductOfType = product.getAllProduct();
            }
        request.setAttribute("select"+sort, "selected");
//        if (sort.equals("asc")){
//            }else if (sort.equals("desc")){
//                request.setAttribute("select"+sort, "selected");
//            }

        int totalPage = (int) Math.ceil(allProductOfType.size() / productPerPage);

        request.setAttribute("totalPage", totalPage);

        request.setAttribute("href", href);

        ArrayList<String> listColors = new ArrayList<>();
        for (int i = 0; i < colors.length; i++) {
            listColors.add(colors[i]);
        }

        request.setAttribute("colors", listColors);

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