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

@WebServlet("/regIt")
public class RegItServlet extends HttpServlet {
    private IUserService uService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String passwords = req.getParameter("passwords");
        String email = req.getParameter("email");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        int result = uService.insert(user);
        System.out.println(result);
        if (result>0){
            resp.getWriter().write("1");
        }else {
            resp.getWriter().write("0");
        }
    }
}
