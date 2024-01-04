package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.Bill;
import vn.hcmuaf.edu.fit.services.BillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ShowBillAdmin", value = "/showBillAdmin")
public class ShowBillAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Bill> allBill = BillService.getInstance().getAllBill();
        request.setAttribute("allBill", allBill);


        int currentPage;
        try {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }catch (NumberFormatException e) {
            currentPage = 1;
        }

        String href = "showBillAdmin?";
        request.setAttribute("href", href);

        double productPerPage = 5.0;

        int totalPage = (int) Math.ceil(allBill.size() / productPerPage);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("productPerPage", (int) productPerPage);

        List<Bill> bills = BillService.getInstance().getBillPerPage(currentPage, (int) productPerPage);
        request.setAttribute("bills", bills);

        request.setAttribute("type", request.getAttribute("type"));
        request.setAttribute("information", request.getAttribute("information"));

        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}