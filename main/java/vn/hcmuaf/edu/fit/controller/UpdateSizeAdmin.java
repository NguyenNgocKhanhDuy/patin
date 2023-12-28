package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.Size;
import vn.hcmuaf.edu.fit.dao.SizeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "UpdateSizeAdmin", value = "/updateSizeAdmin")
public class UpdateSizeAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        String name = request.getParameter("name");


        if (name == null){
            request.setAttribute("type", "error");
            request.setAttribute("information", "Lỗi");
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }else {
            try {
                id = Integer.parseInt(request.getParameter("id"));

                Size size = SizeDao.getInstance().getSizeById(id);
                size.setName(name);
                SizeDao.getInstance().updateSize(size);

                request.setAttribute("type", "success");
                request.setAttribute("information", "Cập nhật thành công");
                request.getRequestDispatcher("showAdmin").forward(request, response);
            }catch (NumberFormatException e ){
                request.setAttribute("type", "error");
                request.setAttribute("information", "Lỗi");
                request.getRequestDispatcher("showAdmin").forward(request, response);
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}