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
import java.util.List;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private IBrandService bservice = new BrandServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Brand> brand = bservice.getLists();
        req.setAttribute("brand",brand);
        req.getRequestDispatcher("WEB-INF/pages/add.jsp").forward(req,resp);
    }
}
