package org.example.servlet;

import org.example.dao.LoginDAO;
import org.example.exception.AppException;
import org.example.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-11-29
 * Time: 16:33
 **/
@WebServlet("/login")
public class LoginServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        User user= LoginDAO.query(userName);
        if(user==null){
            throw new AppException("LOG002","用户名不存在");
        }
        if(!user.getPassword().equals(password)){
            throw new AppException("LOG003","用户名或密码错误");

        }
        //TODO
        HttpSession session=req.getSession();
        session.setAttribute("user",user);
        return user;

        /*if ("abc".equals(userName)){
           // resp.sendRedirect("jsp/articleList.jsp");
            return null;
        }else {
            throw new AppException("LOG001","用户名密码错误");
        }*/
    }
}
