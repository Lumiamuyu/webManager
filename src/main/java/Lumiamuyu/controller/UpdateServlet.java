package Lumiamuyu.controller;

import Lumiamuyu.pojo.Brand;
import Lumiamuyu.pojo.Product;
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
import java.util.List;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private IProductService service = new ProductServiceImpl();
    private IBrandService bservice = new BrandServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        List<Brand> brand = bservice.getLists();
        req.setAttribute("brand",brand);

        Product p = service.getOne(id);
        req.setAttribute("p",p);
        req.getRequestDispatcher("WEB-INF/pages/doUpdate.jsp").forward(req,resp);
    }
}
