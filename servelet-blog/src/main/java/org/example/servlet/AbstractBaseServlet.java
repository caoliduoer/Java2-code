package org.example.servlet;

import org.example.exception.AppException;
import org.example.model.JSONUtil;
import org.example.util.JSONResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-11-29
 * Time: 16:07
 **/
public abstract class AbstractBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        //Session会话管理：除登录和注册接口，其他都需要登陆后访问
        //通过req.getServletPath()获取请求访问路径
        //TODO
        JSONResponse json=new JSONResponse();//是为了前后端统一的数据格式，都使用统一的进行
        //调用子类重写的方法
        try{

            Object data= process(req,resp);
            //子类的process方法执行完没有跑异常，表示业务执行层高
            json.setSuccess(true);
            json.setData(data);
            //process(req, resp);
        }catch (Exception e){
            //异常处理 JDBC异常，Jason处理异常，用户名不存在，密码错误
            e.printStackTrace();
            //json.setsuccess
            String str = "未知错误";
            String code="UNKNOWN";
            if (e instanceof AppException){
                code=((AppException)e).getCode();
                str =  e.getMessage();
            }
           json.setCode(code);
            json.setMessage(str);

        }PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(json));
        pw.flush();
        pw.close();

    }
    protected abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
