package Lumiamuyu.controller;

import Lumiamuyu.pojo.Brand;
import Lumiamuyu.service.BrandServiceImpl;
import Lumiamuyu.service.IBrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/doBrandAdd")
public class DoBrandAddServlet extends HttpServlet {
    private IBrandService service = new BrandServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String des = req.getParameter("des");
/*        System.out.println(name +""+des);*/
        Brand brand = new Brand();
        brand.setBrandDes(des);
        brand.setBrandName(name);
        service.insert(brand);
        resp.sendRedirect("brandlist");
    }
}
