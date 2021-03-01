package com.duo.dao.user;

import com.duo.dao.BaseDao;
import com.duo.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl  implements UserDao{
    public User getLoginUser(Connection connection, String userCode) {

        PreparedStatement pstm=null;
        ResultSet rs=null;
        User user=null;



        if(connection!=null){
            String sql="select * from smbms_user where userCode=?";
            Object[] params={userCode};
            try {
                rs= BaseDao.execute(connection,pstm,rs,sql,params);
                if(rs.next()){
                    user=new User();
                    user.setUserCode(rs.getString("userCode"));
                    user.setUserName(rs.getString("userName"));
                    user.setUserPassword(rs.getString("userPassword"));
                    user.setGender(rs.getInt("gender"));
                    user.setBirthday(rs.getDate("birthday"));
                    user.setPhone(rs.getString("phone"));
                    user.setAddress(rs.getString("address"));
                    user.setUserRole(rs.getInt("userRole"));
                    user.setCreatedBy(rs.getInt("createdBy"));
                    user.setCreationDate(rs.getTimestamp("creationDate"));
                    user.setModifyBy(rs.getInt("modifyBy"));
                    user.setModifyDate(rs.getTimestamp("modifyDate"));
                }
                //user=new User();
                BaseDao.closeResource(null,pstm,rs);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }
}
