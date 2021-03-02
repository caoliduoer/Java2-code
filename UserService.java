package com.duo.service.user;

import com.duo.pojo.User;

public interface UserService {
    //用户登录
    public User login(String userCode, String password);
}
