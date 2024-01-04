package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.*;
import vn.hcmuaf.edu.fit.dao.ColorDao;
import vn.hcmuaf.edu.fit.dao.ImageProductDao;
import vn.hcmuaf.edu.fit.dao.RatingDao;
import vn.hcmuaf.edu.fit.dao.SizeDao;
import vn.hcmuaf.edu.fit.services.ProductService;
import vn.hcmuaf.edu.fit.services.ProductService2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;


@WebServlet(name = "ShowRatingProduct", value = "/showRatingProduct")
public class ShowRatingProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productID;
        int currentPage;

        try {

            productID = Integer.parseInt(request.getParameter("productID"));
            request.setAttribute("productID", productID);

            try {
                currentPage = Integer.parseInt(request.getParameter("currentPage"));
            }catch (NumberFormatException e){
                currentPage = 1;
            }
            request.setAttribute("currentPage", currentPage);
            int totalPage = (int) Math.ceil((RatingDao.getInstance().getAllRatingOfProduct(productID).size() / (3+0.0)));
            request.setAttribute("totalPage", totalPage);

            String href = "showRatingProduct?productID="+productID;
            request.setAttribute("href", href);


            List<ProductMain> products = ProductService2.getInstance().getProductDetail(productID);
            request.setAttribute("products", products);

            List<Rating> ratings = RatingDao.getInstance().getAllRatingOfProductPerPage(productID, currentPage);
            request.setAttribute("ratings", ratings);
            double totalRate = 0;
            for (int i = 0; i < ratings.size(); i++) {
                totalRate += ratings.get(i).getScore()+0.0;
            }
            totalRate = totalRate / ratings.size();

            request.setAttribute("totalRate", (double) Math.round(totalRate * 10) / 10);


            List<ImageProduct> listImg = ImageProductDao.getInstance().getAllImage(productID);
            request.setAttribute("listImg", listImg);

            List<Color> colors = ColorDao.getInstance().getProductColor(productID);
            request.setAttribute("colors", colors);

            List<Size> sizes = SizeDao.getInstance().getProductSize(productID);
            request.setAttribute("sizes", sizes);

//            List<Product> orderProduct = ProductService.getInstance().getRandomProduct(4);
            List<ProductMain> orderProduct = ProductService2.getInstance().getRandomProduct(4);
            request.setAttribute("orderProducts", orderProduct);

            int totalQuantity = 0;
            for (int i = 0; i < products.size(); i++) {
                totalQuantity += products.get(0).getProductDetail().getQuantity();
            }

            request.setAttribute("totalQuantity", totalQuantity);

            List<ImageRating> listImgRating = RatingDao.getInstance().getImageRatingOfProductPerPage(productID, currentPage);
            request.setAttribute("listImgRating", listImgRating);
            request.setAttribute("hasImg", 0);

            request.setAttribute("type", request.getAttribute("type"));
            request.setAttribute("information", request.getAttribute("information"));

            request.getRequestDispatcher("product_detail.jsp").forward(request, response);

        }catch (NumberFormatException e) {
            request.setAttribute("type", "error");
            request.setAttribute("infomation", "Lỗi");
            request.getRequestDispatcher("listProduct").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}