package com.duo.service.user;

import com.duo.dao.BaseDao;
import com.duo.dao.user.UserDao;
import com.duo.dao.user.UserDaoImpl;
import com.duo.pojo.User;
import org.junit.Test;

import java.sql.Connection;

public class UserServiceImpl  implements  UserService{

    //业务层都会调用dao层，所以要引入Dao层
    private UserDao userDao;
    public  UserServiceImpl(){
        userDao=new UserDaoImpl();
    }
    public User login(String userCode, String password) {
        Connection connection=null;
        User user=null;

        try {
            connection= BaseDao.getConnection();
            //业务层调用对应的数据库操作
            userDao.getLoginUser(connection,userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;

    }
    @Test
    public  void test(){
        UserServiceImpl userService=new UserServiceImpl();
        User admin=userService.login("admin","123456");
        System.out.println(admin.getuserPassword());
    }

}
