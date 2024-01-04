package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.ImageProduct;
import vn.hcmuaf.edu.fit.bean.Product;
import vn.hcmuaf.edu.fit.dao.ImageProductDao;
import vn.hcmuaf.edu.fit.services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;


@WebServlet(name = "ShowProductDetailAdmin", value = "/showProductDetailAdmin")
public class ShowProductDetailAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            List<Product> productDetail = ProductService.getInstance().getAllProductDetail(id);

            String text = productDetail.get(0).getInformation();
            request.setAttribute("text", "- "+text.replace("%", "\n- ").trim());

            String info = productDetail.get(0).getInformation().replace("%", "<br>- ");
            productDetail.get(0).setInformation(info);

            request.setAttribute("productDetail", productDetail);

            List<ImageProduct> imageProducts = ImageProductDao.getInstance().getAllImage(id);
            request.setAttribute("images", imageProducts);

            request.getRequestDispatcher("admin.jsp").forward(request, response);

        }catch (NumberFormatException e){
            request.setAttribute("type", "error");
            request.setAttribute("information", "Lỗi null");
            request.getRequestDispatcher("showColorAdmin").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}