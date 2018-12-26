package Lumiamuyu.controller;

import Lumiamuyu.pojo.Brand;
import Lumiamuyu.pojo.Product;
import Lumiamuyu.service.BrandServiceImpl;
import Lumiamuyu.service.IBrandService;
import Lumiamuyu.service.IProductService;
import Lumiamuyu.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

@MultipartConfig
@WebServlet("/doAdd")
public class DoAddServlet extends HttpServlet {
    private IBrandService bservice = new BrandServiceImpl();
    private IProductService service = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        /*req.getRequestDispatcher("WEB-INF/pages/imgtest.jsp").forward(req,resp);*/
        Part part = req.getPart("url");
        String str = "C:\\Users\\Lumia\\IdeaProjects\\webManager\\src\\main\\webapp\\img"+part.getSubmittedFileName();
        String url = str.substring(str.indexOf("img"));
        File file = new File(str);
        System.out.println(url);

        OutputStream outputStream = new FileOutputStream(file);

        byte[] b = new byte[1024];
        InputStream inputStream = part.getInputStream();
        int r = inputStream.read(b,0,b.length);
        while (r!=-1){
            outputStream.write(b);
            r = inputStream.read(b,0,b.length);
        }

        int id = Integer.parseInt(req.getParameter("brandId"));
        String name = req.getParameter("name");
        double price =Double.parseDouble(req.getParameter("price"));
        String des = req.getParameter("des");
        int rev =Integer.parseInt(req.getParameter("reverse")) ;
        /*String url1 = req.getParameter("url");*/
        Product p = new Product();
        p.setProductName(name);
        p.setPrice(price);
        p.setUrl(url);
        p.setProductDes(des);
        p.setReverse(rev);
        p.setBrandId(id);
        System.out.println(id);
        service.add(p);
        resp.sendRedirect("list");
    }
}
