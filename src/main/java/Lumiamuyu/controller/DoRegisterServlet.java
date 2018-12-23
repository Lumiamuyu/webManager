package Lumiamuyu.controller;

import Lumiamuyu.dao.IUserDao;
import Lumiamuyu.pojo.User;
import Lumiamuyu.service.IUserService;
import Lumiamuyu.service.UserServiceImpl;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/doRegister")
public class DoRegisterServlet extends HttpServlet {
    private IUserService uService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String passwords = req.getParameter("passwords");
        String email = req.getParameter("email");

        if (username != ""){
            User user = uService.getUser(username);
            if (user==null){
                resp.getWriter().write("4");//可以注册
                if (password!=""&&passwords!=""){
                    if (password.equals(passwords)){
                        resp.getWriter().write("3");//全匹配进行注册
                    }else{
                        resp.getWriter().write("2");//两次密码输入不一致
                    }
                }
            }else {
                resp.getWriter().write("1");//用户已存在
            }
        }

    }
}
