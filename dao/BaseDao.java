package com.duo.dao;

import com.sun.deploy.panel.IProperty;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//操作数据库的公共类
public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
//静态代码块，类夹杂的时候就初始化了
    static {
        Properties properties=new Properties();
        //5通过类加载器读取对应的资源
        InputStream is=BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        try{
            properties.load(is);
        }catch (IOException e){
            e.printStackTrace();
        }
        driver =properties.getProperty("driver");
        url =properties.getProperty("url");
        username =properties.getProperty("username");
        password =properties.getProperty("password");

    }
    //读取数据库的连接
    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName(driver);
             connection=DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    //编写查询公共类
    public static ResultSet execute(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet,String sql,Object[] params) throws SQLException {
        //预编译的sql
        preparedStatement=connection.prepareStatement(sql);

        for(int i=0;i<params.length;i++){
            //占位符是从1开始，但是数组是从0开始；
            preparedStatement.setObject(i+1,params[i]);
        }
          resultSet=preparedStatement.executeQuery(sql);
        return  resultSet;
    }
    //编写增删改的公共方法
    public  static  int execute(Connection connection, String sql, Object[] params, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement=connection.prepareStatement(sql);

        for(int i=0;i<params.length;i++){
            //占位符是从1开始，但是数组是从0开始；
            preparedStatement.setObject(i+1,params[i]);
        }
        int updateRows=preparedStatement.executeUpdate();
        return  updateRows;
    }

    //释放资源
    public static boolean closeResource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){

        boolean flag=true;
        if(resultSet!=null){
            try {
                resultSet.close();
                //gc回收
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
                //gc回收
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        if(connection!=null){
            try {
                connection.close();
                //gc回收
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        return flag;
    }



}
