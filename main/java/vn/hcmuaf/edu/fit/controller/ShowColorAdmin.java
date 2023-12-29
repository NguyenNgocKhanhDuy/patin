package vn.hcmuaf.edu.fit.controller;

import vn.hcmuaf.edu.fit.bean.Color;
import vn.hcmuaf.edu.fit.dao.ColorDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "ShowColorAdmin", value = "/showColorAdmin")
public class ShowColorAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().println("color");

        List<Color> allColor = ColorDao.getInstance().getAllColor();
        request.setAttribute("allColor", allColor);


        int currentPage;
        try {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }catch (NumberFormatException e) {
            currentPage = 1;
        }

        String href = "showColorAdmin?";
        request.setAttribute("href", href);

        double productPerPage = 5.0;

        int totalPage = (int) Math.ceil(allColor.size() / productPerPage);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("productPerPage", (int) productPerPage);

        List<Color> colors = ColorDao.getInstance().getColorPerPage(currentPage, (int) productPerPage);
        request.setAttribute("colors", colors);

        request.setAttribute("type", request.getAttribute("type"));
        request.setAttribute("information", request.getAttribute("information"));

        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}