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
@WebServlet("/editIt")
public class EditItServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newpwd = req.getParameter("newpwd");
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("user");
        u.setPassword(newpwd);
        int result = service.editPwd(u);
        System.out.println(result);
        if (result>0){
            resp.getWriter().write("1");
        }else {
            resp.getWriter().write("0");
        }
    }
}
