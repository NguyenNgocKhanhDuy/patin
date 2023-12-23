package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.Color;
import vn.hcmuaf.edu.fit.bean.ImageProduct;
import vn.hcmuaf.edu.fit.bean.Product2;
import vn.hcmuaf.edu.fit.bean.Size;
import vn.hcmuaf.edu.fit.dao.ColorDao;
import vn.hcmuaf.edu.fit.dao.ImageProductDao;
import vn.hcmuaf.edu.fit.dao.SizeDao;
import vn.hcmuaf.edu.fit.services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;


@WebServlet(name = "ProductDetail", value = "/productDetail")
public class ProductDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productID;

        try {
            productID = Integer.parseInt(request.getParameter("productID"));
        }catch (NumberFormatException e) {
            productID = 1;
        }

        request.setAttribute("productID", productID);

        Product2 product = ProductService.getInstance().getProduct(productID);
        request.setAttribute("product", product);

        String info = product.getInformation().replace("%", "<br>");
        product.setInformation(info);

        List<ImageProduct> listImg = ImageProductDao.getInstance().getAllImage(productID);
        request.setAttribute("listImg", listImg);

        List<Color> colors = ColorDao.getInstance().getProductColor(productID);
        request.setAttribute("colors", colors);

        List<Size> sizes = SizeDao.getInstance().getProductSize(productID);
        request.setAttribute("sizes", sizes);

        List<Product2> orderProduct = ProductService.getInstance().getRandomProduct(4);
        request.setAttribute("orderProducts", orderProduct);

        request.setAttribute("totalQuantity", ProductService.getInstance().getTotalQuantity(productID));

        request.setAttribute("type", request.getAttribute("type"));
        request.setAttribute("information", request.getAttribute("information"));

        request.getRequestDispatcher("product_detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;
    }
}