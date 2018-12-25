package Lumiamuyu.controller;

import Lumiamuyu.service.BrandServiceImpl;
import Lumiamuyu.service.IBrandService;
import Lumiamuyu.service.IProductService;
import Lumiamuyu.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doBrandDelete")
public class DoBrandDelete extends HttpServlet {
    private IBrandService bservice = new BrandServiceImpl();
    private IProductService pservice = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("brandId"));
        bservice.delete(id);
        bservice.dele(id);
        resp.sendRedirect("brandDelete");
    }
}
