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

@WebServlet("/doUserUpdate")
public class DoUserUpdateServlet extends HttpServlet {
    private IUserService uservice = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String email = req.getParameter("email");
        int rid= Integer.parseInt(req.getParameter("rId"));
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        user.setPassword(pwd);
        user.setEmail(email);
        user.setRid(rid);
        uservice.update(user);
        resp.sendRedirect("userUpdateView");
    }
}
