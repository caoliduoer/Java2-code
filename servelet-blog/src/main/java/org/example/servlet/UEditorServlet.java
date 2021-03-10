package org.example.servlet;

import org.example.util.MyActionEnter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;

/**
 * 做图片上传--富文本编辑器
 * 1.修改idea中的tomcat配置的引用上下文路径，Maven中的finalname
 * 2.修改webapp/static/ueditor.config.js,33行修改
 * 3.（引用上下文+服务路径）
 * 4.实现后端接口（
 * */
@WebServlet("/ueditor")
public class UEditorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      URL url=UEditorServlet.class.getClassLoader().getResource("config.json");//类加载来找到绝对路径。
        //url获取到时，都是编码后的字符串，
        String path= URLDecoder.decode(url.getPath(),"UTF-8");
        //框架提供的富文本编辑器上传功能
        MyActionEnter enter=new MyActionEnter(req,path);
        enter.exec();//执行一下。
        PrintWriter pw=resp.getWriter();
        pw.println(enter.exec());
        pw.flush();
        pw.close();
    }
}
