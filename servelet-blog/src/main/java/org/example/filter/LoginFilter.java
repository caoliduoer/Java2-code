package org.example.filter;

import org.example.model.JSONUtil;
import org.example.util.JSONResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//配置用户同意会话管理的过滤器：匹配所有请求路径
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * 用户统一会话过滤器：匹配所有请求路径
     * 服务资源路径：/login不用校验Session，其他都要校验，不通过，则返回401，响应内容随便
     * 前端资源：/jsp校验session，不通过重定向到登录页面
     * /js/,/static/,/view/全部不校验
     * */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
    * 每次http请求匹配到过滤器路径时，会执行该过滤器的doFilter
    * 如果往下执行，是调用filterChain.doFilter(request,response)
     * 否则自行处理
    * */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse resp=(HttpServletResponse) response;
        String servletPath=req.getServletPath();//获取当前请求的服务路径。

        //不需要登录允许访问:往下执行
        if(servletPath.startsWith("/js1/")||servletPath.startsWith("/static/")||servletPath.startsWith("/view/")||servletPath.equals("/login/")){//后面跟/表示结束
            chain.doFilter(request,response);
        }else{
            //获取session对象，没有就为空
            HttpSession session=req.getSession(false);
            //验证用户有没有登录，如果没有登录，就根据前端或者后端做相应的操作。
            if(session==null||session.getAttribute("user")==null){
                //前端重定向到登录页面
                if(servletPath.startsWith("/jsp/")){
                    resp.sendRedirect(basePath(req)+"/static/view/login.html");
                    //绝对路径的格式
                }else{//后端返回401
                    resp.setStatus(401);
                    resp.setCharacterEncoding("UTF-8");
                    resp.setContentType("application/json");
                    JSONResponse json=new JSONResponse();
                    json.setCode("LOG000");
                    json.setMessage("用户没有登录，不允许访问");
                    PrintWriter pw=resp.getWriter();
                    pw.println(JSONUtil.serialize(json));
                    pw.flush();
                    pw.close();
                }
            }else{
                chain.doFilter(request,response);//已经登录，允许访问敏感资源
            }
        }
    }
    /**
     * 根据http请求，动态获取访问路径（服务路径之前的）
     *
     * */
    public static String basePath(HttpServletRequest req){
        String schema=req.getScheme();//Http
        String host=req.getServerName();//主机或域名
        int port=req.getServerPort();//端口
        String contentpath=req.getContextPath();//应用上下文路径
        return schema+"://"+host+":"+port+contentpath;
    }
    @Override
    public void destroy() {

    }
}
