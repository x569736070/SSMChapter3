package com.yuntu.dao;

import com.yuntu.pojo.User;
import com.yuntu.utils.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 通过userCode获取User
     * @param userCode
     * @return
     * @throws Exception
     */
    public User getLoginUser(@Param("userCode") String userCode)throws Exception;

    List<User> getPageAll(PageUtil<User> pageUtil) throws Exception;

    int getCount() throws Exception;
}
