package Lumiamuyu.controller;

import Lumiamuyu.pojo.User;
import Lumiamuyu.service.IUserService;
import Lumiamuyu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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

        if (user!=null) {
            /*resp.sendRedirect("register");*/
            if (user.getPassword().equals(password)) {
                resp.getWriter().write("1");
                HttpSession session = req.getSession();
                Cookie ucookie = new Cookie("username", username);
                Cookie pcookie = new Cookie("password", password);
                ucookie.setMaxAge(60 * 60 * 24);
                pcookie.setMaxAge(60 * 60 * 24);
                resp.addCookie(ucookie);
                resp.addCookie(pcookie);
                session.setAttribute("user", user);
                resp.sendRedirect("list");
            } else {
                resp.getWriter().write("3");
            }

        }else {
            resp.getWriter().write("2");
        }
    }
}
