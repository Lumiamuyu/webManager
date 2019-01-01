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

@WebServlet("/userUpdate")
public class UserUpdateServlet extends HttpServlet {
    private IUserService service =new UserServiceImpl();
    private IRoleService rservice = new RoleServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User u = service.getOne(id);
        req.setAttribute("u",u);
        List<Role> role = rservice.getLists();
        req.setAttribute("ro",role);
/*        System.out.println(role);*/
        req.getRequestDispatcher("WEB-INF/pages/douserupdate.jsp").forward(req,resp);
    }
}
