package Lumiamuyu.controller;

import Lumiamuyu.pojo.User;
import Lumiamuyu.service.IUserService;
import Lumiamuyu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/doUserDelete")
public class DoUserDeleteServlet extends HttpServlet {
    private IUserService service =new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        int id = Integer.parseInt(req.getParameter("id"));
        int userId = user.getId();
        if (id!=userId){
            service.delete(id);
        }else {
            System.out.println("No you can not");
        }
        resp.sendRedirect("userDelete");
    }
}
