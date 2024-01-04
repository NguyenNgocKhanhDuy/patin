package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.Bill;
import vn.hcmuaf.edu.fit.bean.BillDetail;
import vn.hcmuaf.edu.fit.services.BillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ShowBillDetailAdmin", value = "/showBillDetailAdmin")
public class ShowBillDetailAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            Bill bill = BillService.getInstance().getBill(id);
            request.setAttribute("bill", bill);
            List<BillDetail> billDetail = BillService.getInstance().getBillDetail(id);
            request.setAttribute("billDetail", billDetail);

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