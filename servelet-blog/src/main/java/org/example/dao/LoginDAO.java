package org.example.dao;

import org.example.exception.AppException;
import org.example.model.User;
import org.example.util.DBUtil;

import javax.xml.transform.Result;
import java.sql.*;

public class LoginDAO {
public static User query(String username){
    Connection c=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

    try {
        c= DBUtil.getConnection();
        String sql="select id,username,password,nickname,sex,birthday,head from user where  username=?";
        ps=c.prepareStatement(sql);
        //设置占位符；
        ps.setString(1,username);

        rs=ps.executeQuery();
        User user=null;
        while(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(username);
            user.setPassword(rs.getString("password"));
            user.setNickname(rs.getString("nickname"));
            user.setSex(rs.getBoolean("sex"));

            java.sql.Date birthday=rs.getDate("birthday");
            //rs.getDate("birthday");
            if(birthday!=null){
               // user.setBirthday(new Date(rs.getDate("birthday").getTime()));
               user.setBirthday(new java.util.Date(birthday.getTime()));
            }
            user.setHead(rs.getString("head"));
        }
        return user;
    } catch (SQLException e) {
        throw new AppException("LOG001","查询用户操作失败",e);
    } finally {
        DBUtil.close(c,ps,rs);
    }

}

}
