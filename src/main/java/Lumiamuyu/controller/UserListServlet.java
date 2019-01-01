package Lumiamuyu.controller;

import Lumiamuyu.pojo.Role;
import Lumiamuyu.pojo.User;
import Lumiamuyu.service.IRoleService;
import Lumiamuyu.service.IUserService;
import Lumiamuyu.service.RoleServiceImpl;
import Lumiamuyu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
    private IUserService uservice = new UserServiceImpl();
    private IRoleService rservice = new RoleServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = uservice.getUserLists();
        req.setAttribute("list",list);
        List<Role> rlist = rservice.getList();
        req.setAttribute("rlist",rlist);

        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type", "text/html;charset=UTF-8");

        req.getRequestDispatcher("WEB-INF/pages/userlist.jsp").forward(req,resp);
    }
}
