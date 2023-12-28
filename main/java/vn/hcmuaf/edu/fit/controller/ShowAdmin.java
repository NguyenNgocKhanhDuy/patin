package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.Bill;
import vn.hcmuaf.edu.fit.bean.Category;
import vn.hcmuaf.edu.fit.bean.Product2;
import vn.hcmuaf.edu.fit.bean.User;
import vn.hcmuaf.edu.fit.dao.CategoryDao;
import vn.hcmuaf.edu.fit.services.BillService;
import vn.hcmuaf.edu.fit.services.ProductService;
import vn.hcmuaf.edu.fit.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;


@WebServlet(name = "ShowAdmin", value = "/showAdmin")
public class ShowAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> allUser = UserService.getInstance().getAllUser();
        request.setAttribute("allUser", allUser);


        int currentPage;
        try {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }catch (NumberFormatException e) {
            currentPage = 1;
        }

        String href = "showAdmin?";
        request.setAttribute("href", href);

        double productPerPage = 5.0;

        int totalPage = (int) Math.ceil(allUser.size() / productPerPage);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("currentPage", currentPage);

        List<User> users = UserService.getInstance().getUserPerPage(currentPage, (int) productPerPage);
        request.setAttribute("users", users);

        List<Product2> allProduct = ProductService.getInstance().getAllProduct();
        request.setAttribute("allProduct", allProduct);

        List<Category> categories = CategoryDao.getInstance().getAllCategory();
        request.setAttribute("allCategory", categories);

        List<Bill> bills = BillService.getInstance().getAllBill();
        request.setAttribute("allBills", bills);

        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}