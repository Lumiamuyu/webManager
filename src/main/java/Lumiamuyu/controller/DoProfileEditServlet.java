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

@WebServlet("/doprofileedit")
public class DoProfileEditServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String prepwd = req.getParameter("prepwd");
        String newpwd = req.getParameter("newpwd");
        String newpwds = req.getParameter("newpwds");

        HttpSession session = req.getSession();
/*        System.out.println(session.getAttribute("user"));*/
        User user = (User)session.getAttribute("user");
        int userId = user.getId();//取得外部登录的id
        String uname = user.getUsername();

        User u= service.getUser(uname);
        String oldpwd = u.getPassword();

        if (u.getId().equals(userId)){
            if ((prepwd.equals(oldpwd))&&(newpwd!="")&&(newpwd!=" ")){
                resp.getWriter().write("1");//旧密码匹配，可以执行下一步
                if (newpwd.equals(newpwds)){
                    resp.getWriter().write("3");//两次输入密码一致，可以进行密码修改
                }else {
                    resp.getWriter().write("4");//两次密码输入不一致
                }
            }else {
                resp.getWriter().write("2");//原密码错误
            }
        }
    }
}
