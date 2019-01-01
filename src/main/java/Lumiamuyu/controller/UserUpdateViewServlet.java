package Lumiamuyu.controller;

import Lumiamuyu.pojo.User;
import Lumiamuyu.service.BrandServiceImpl;
import Lumiamuyu.service.IBrandService;
import Lumiamuyu.service.IUserService;
import Lumiamuyu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userUpdateView")
public class UserUpdateViewServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = service.getUserLists();
        req.setAttribute("list",list);
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        req.getRequestDispatcher("WEB-INF/pages/userupdate.jsp").forward(req,resp);
    }
}
