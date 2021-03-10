package org.example.servlet;


import netscape.javascript.JSUtil;
import org.example.dao.ArticleDAO;
import org.example.model.Article;
import org.example.model.JSONUtil;
import org.example.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;

@WebServlet("/articleAdd")
public class ArticleAddServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session=req.getSession(false);
        //从会话中取用户名、
        User user=(User) session.getAttribute("user") ;

        //请求数据类型是：application/json,需要使用输入流获取。

        InputStream is=req.getInputStream();//反序列化
        Article a= JSONUtil.deserialize(is,Article.class);//文章对象里面取数据
        a.setUserId(user.getId());
        int num= ArticleDAO.insert(a);
        return null;
    }
}
