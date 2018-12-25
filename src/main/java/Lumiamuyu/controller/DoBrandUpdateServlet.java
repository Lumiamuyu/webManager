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

@WebServlet("/doBrandUpdate")
public class DoBrandUpdateServlet extends HttpServlet {
    private IBrandService service = new BrandServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String des = req.getParameter("des");
        Brand brand = new Brand();
        brand.setBrandId(id);
        brand.setBrandName(name);
        brand.setBrandDes(des);
        service.update(brand);
        resp.sendRedirect("brandUpdateView");
    }
}
