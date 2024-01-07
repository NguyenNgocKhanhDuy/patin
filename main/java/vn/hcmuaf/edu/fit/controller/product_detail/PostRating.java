package vn.hcmuaf.edu.fit.controller.product_detail;

import vn.hcmuaf.edu.fit.dao.RatingDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;


@WebServlet(name = "PostRating", value = "/postRating")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
public class PostRating extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        ServletContext servletContext = getServletContext();
        File root = new File(servletContext.getRealPath("/") + "data/");
        if (!root.exists()) root.mkdirs();
        System.out.println(root.getAbsolutePath());
        for (Part part : request.getParts()) {
            part.write(root.getAbsolutePath() + "/" + fileName);
            RatingDao.getInstance().insert("data/" + fileName);
        }
        response.getWriter().println("Upload success");
    }
}