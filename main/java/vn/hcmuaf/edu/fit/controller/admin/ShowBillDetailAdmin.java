package vn.hcmuaf.edu.fit.controller.admin;

import vn.hcmuaf.edu.fit.bean.*;
import vn.hcmuaf.edu.fit.services.BillService;
import vn.hcmuaf.edu.fit.services.BillService2;
import vn.hcmuaf.edu.fit.services.PermissionsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ShowBillDetailAdmin", value = "/showBillDetailAdmin")
public class ShowBillDetailAdmin extends HttpServlet {
    String rsName = "bill";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("auth");
        if (user == null) request.getRequestDispatcher("login.jsp").forward(request, response);
        else {
            int per = PermissionsService.getPermissionsService().checkAccess(rsName, user.getId());
            request.setAttribute("per", per);
            int id;
            try {
                id = Integer.parseInt(request.getParameter("id"));
                Bill2 bill = BillService2.getInstance().getBill(id);
                request.setAttribute("bill", bill);
                List<BillDetail2> billDetail = BillService2.getInstance().getBillDetail(id);
                request.setAttribute("billDetail", billDetail);

                request.getRequestDispatcher("admin.jsp").forward(request, response);

            }catch (NumberFormatException e){
                request.setAttribute("type", "error");
                request.setAttribute("information", "Lỗi null");
                request.getRequestDispatcher("showColorAdmin").forward(request, response);
            }
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}