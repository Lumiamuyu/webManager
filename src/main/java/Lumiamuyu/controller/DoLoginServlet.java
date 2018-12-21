package Lumiamuyu.controller;

import Lumiamuyu.pojo.User;
import Lumiamuyu.service.IUserService;
import Lumiamuyu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/doLogin")
public class DoLoginServlet extends HttpServlet {
    private IUserService uservice = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type","text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = uservice.getUser(username);
        /*System.out.println(user);*/
        if (user==null){
            resp.sendRedirect("register");
        }else {
            if (user.getPassword()==password){
                resp.sendRedirect("list");
            }
        }

    }
}
