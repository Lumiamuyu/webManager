package Lumiamuyu.controller;

import Lumiamuyu.pojo.Product;
import Lumiamuyu.pojo.ResultData;
import Lumiamuyu.pojo.User;
import Lumiamuyu.service.IProductService;
import Lumiamuyu.service.IUserService;
import Lumiamuyu.service.ProductServiceImpl;
import Lumiamuyu.service.UserServiceImpl;
import Lumiamuyu.utilTest.CookiesUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private IProductService iservice = new ProductServiceImpl();
    private IUserService uservice = new UserServiceImpl();
    private IProductService pservice = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Product> lists = iservice.getLists();
        req.setAttribute("lists", lists);

        int pageNo = req.getParameter("pageNo")==null?1:Integer.parseInt(req.getParameter("pageNo"));
        int pageSize=3;

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

        if(text==""||text==null){
            ResultData data  = iservice.getLists(pageNo,pageSize);
            data.setUrl("delete","");
            req.setAttribute("data",data);
            if (user==null){
                User user1 = uservice.getUser(username);
                session.setAttribute("user",user1);
                req.getRequestDispatcher("WEB-INF/pages/delete.jsp").forward(req,resp);

            }else {
                req.getRequestDispatcher("WEB-INF/pages/delete.jsp").forward(req,resp);
            }
        }else{
            ResultData data = iservice.getLists(pageNo,pageSize,text);
            String params="&text="+text;
            data.setUrl("delete",params);
            req.setAttribute("text",text);
            req.setAttribute("data",data);
            if (user==null){
                User user1 = uservice.getUser(username);
                session.setAttribute("user",user1);
                req.getRequestDispatcher("WEB-INF/pages/delete.jsp").forward(req,resp);

            }else {
                req.getRequestDispatcher("WEB-INF/pages/delete.jsp").forward(req,resp);
            }
        }






/*        if (user==null){
            User user1 = uservice.getUser(username);
            session.setAttribute("user",user1);
            req.getRequestDispatcher("WEB-INF/pages/delete.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("WEB-INF/pages/delete.jsp").forward(req,resp);
        }*/

    }


/*    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String text =req.getParameter("text");
        text="%"+text+"%";
        *//*System.out.println(text);*//*
        if (text==""){
            List<Product> lists = pservice.getLists();
            req.setAttribute("lists", lists);
            req.getRequestDispatcher("WEB-INF/pages/delete.jsp").forward(req, resp);
        }else{
            List<Product> lists = pservice.getResult(text);
            req.setAttribute("lists", lists);
            req.getRequestDispatcher("WEB-INF/pages/delete.jsp").forward(req, resp);
        }


    }*/
}
