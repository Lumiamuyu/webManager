package Lumiamuyu.controller;

import Lumiamuyu.pojo.Brand;
import Lumiamuyu.service.BrandServiceImpl;
import Lumiamuyu.service.IBrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/brandUpdate")
public class BrandUpdateServlet extends HttpServlet {
    private IBrandService service = new BrandServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("brandId"));
        Brand b = service.getOne(id);
        req.setAttribute("b",b);
        req.getRequestDispatcher("WEB-INF/pages/dobrandupdate.jsp").forward(req,resp);
    }

}
