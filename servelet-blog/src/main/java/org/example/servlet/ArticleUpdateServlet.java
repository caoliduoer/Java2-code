package org.example.servlet;

import org.example.dao.ArticleDAO;
import org.example.model.Article;
import org.example.model.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        InputStream is=req.getInputStream();
        Article a= JSONUtil.deserialize(is,Article.class);
        int num= ArticleDAO.update(a);//更新操作的返回值
        return null;
    }
}
