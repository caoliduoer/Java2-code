package com.duo.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

//验证码
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如何让浏览器自动刷新
        resp.setHeader("refresh","3");
        //在内存中创建一个图片
        BufferedImage image= new BufferedImage(80,20,BufferedImage.TYPE_INT_BGR);
        //德达图片
        Graphics2D g=(Graphics2D)image.getGraphics();//笔
        //设置图片颜色背景
        g.setColor(Color.white);
        g.fillRect(0,0,80,20);
        //给图片写数据
        g.setColor(Color.BLUE);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString(makeNum(),0,20);
        //告诉浏览器，这个请求用图片的方式打开
        resp.setContentType("image/jpeg");
        //网站存在缓存，不让浏览器缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        //把图片写给浏览器
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
//生成随机数
    private String makeNum(){
        Random random=new Random();
        String nu=random.nextInt(999999)+"";
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<6-nu.length();i++){
            sb.append("0");
        }
        nu=sb.toString()+nu;
        return nu;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
