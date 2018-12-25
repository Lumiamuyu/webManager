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

@WebServlet("/brandlist")
public class BrandListServlet extends HttpServlet {
    private IBrandService service = new BrandServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> lists = service.getLists();
        req.setAttribute("lists", lists);

        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type", "text/html;charset=UTF-8");

        req.getRequestDispatcher("WEB-INF/pages/brandlist.jsp").forward(req,resp);
    }
}
