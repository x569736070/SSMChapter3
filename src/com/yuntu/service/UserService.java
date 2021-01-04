package com.yuntu.service;

import com.yuntu.pojo.User;
import com.yuntu.utils.PageUtil;

import java.util.List;

public interface UserService {

    /**
     * 用户登录
     * @param userCode
     * @param userPassword
     * @return
     */
    public User login(String userCode, String userPassword) throws Exception;
    List<User> getPageAll(PageUtil<User> pageUtil) throws Exception;
    int getCounts() throws Exception;
}
