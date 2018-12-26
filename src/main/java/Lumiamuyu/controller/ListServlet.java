package Lumiamuyu.controller;

import Lumiamuyu.pojo.Brand;
import Lumiamuyu.pojo.Product;
import Lumiamuyu.pojo.ResultData;
import Lumiamuyu.pojo.User;
import Lumiamuyu.service.*;
import Lumiamuyu.utilTest.CookiesUtil;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private IProductService iservice = new ProductServiceImpl();
    private IUserService uservice = new UserServiceImpl();
    private IProductService pservice = new ProductServiceImpl();
    private IBrandService bservice = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = req.getParameter("pageNo")==null?1:Integer.parseInt(req.getParameter("pageNo"));
        int pageSize=3;

        List<Brand> brand = bservice.getLists();
        System.out.println(brand);
        req.setAttribute("brand",brand);


        List<Product> lists = iservice.getLists();
        req.setAttribute("lists", lists);

        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        String text = req.getParameter("text");

        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();
        CookiesUtil.getCookie(cookies);
        Map<String,Cookie> maps = CookiesUtil.getCookie(cookies);
        Cookie cookie = maps.get("username");
        String username = cookie.getValue();
        User user = (User) session.getAttribute("user");



/*        if (user==null){
            User user1 = uservice.getUser(username);
            session.setAttribute("user",user1);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);

        }else {
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
        }*/

        if(text==""||text==null){
            ResultData data  = iservice.getLists(pageNo,pageSize);
            data.setUrl("list","");
            req.setAttribute("data",data);
            if (user==null){
                User user1 = uservice.getUser(username);
                session.setAttribute("user",user1);
                req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);

            }else {
                req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
            }
        }else{
            ResultData data = iservice.getLists(pageNo,pageSize,text);
            String params="&text="+text;
            data.setUrl("list",params);
            req.setAttribute("text",text);
            req.setAttribute("data",data);
            if (user==null){
                User user1 = uservice.getUser(username);
                session.setAttribute("user",user1);
                req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);

            }else {
                req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
            }
        }

/*        if (user==null){
            User user1 = uservice.getUser(username);
            session.setAttribute("user",user1);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);

        }else {
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
        }

        if(text==""||text==null){
            ResultData data  = iservice.getLists(pageNo,pageSize);
            data.setUrl("list","");
            req.setAttribute("data",data);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
        }else{
            ResultData data = iservice.getLists(pageNo,pageSize,text);
            String params="&text="+text;
            data.setUrl("list",params);
            System.out.println(text);
            req.setAttribute("text",text);
            req.setAttribute("data",data);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
        }*/




    }


/*    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String text =req.getParameter("text");
        *//*System.out.println(text);*//*
        if (text==""){
            List<Product> lists = pservice.getLists();
            req.setAttribute("lists", lists);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req, resp);
        }else{
            List<Product> lists = pservice.getResult(text);
            req.setAttribute("lists", lists);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req, resp);
        }


    }*/
}
