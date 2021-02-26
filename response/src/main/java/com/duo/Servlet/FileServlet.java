package com.duo.Servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //   1. 要获取下载文件的路径
        String realpath=this.getServletContext().getRealPath("/1.png");
        System.out.println("下载文件的路径"+realpath);
     //   2. 下载的文件名是啥
        String filename=realpath.substring(realpath.lastIndexOf("\\")+1);
     //   3. 设置想办法让刘篮球能够支持我们需要的东西Content_Disposition
        resp.setHeader("Content_Disposition","attachment:filename"+filename);
      //  4. 获取下载文件的输入流
        FileInputStream in=new FileInputStream(realpath);
      //  5. 创建缓冲区
        int len=0;
        byte[] buffer=new byte[1024];
       // 6. 获取OutputStream对象
        ServletOutputStream out=resp.getOutputStream();
     //   7. 将FileOutStream流写入到buffer缓冲区
        while ((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }
       // 8. 使用outputStream将缓冲区的数据输出到客户端！

        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
