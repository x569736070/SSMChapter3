package com.yuntu.service;

import com.yuntu.dao.UserMapper;
import com.yuntu.pojo.User;
import com.yuntu.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User login(String userCode, String userPassword) throws Exception {
		// TODO Auto-generated method stub
		User user = null;
		user = userMapper.getLoginUser(userCode);
		//匹配密码
		if(null != user){
			if(!user.getUserPassword().equals(userPassword))
				user = null;
		}
		return user;
	}

	@Override
	public List<User> getPageAll(PageUtil<User> pageUtil) throws Exception {
		List<User> friendList = new ArrayList<>();
		int count = userMapper.getCount();
		System.out.println("-------count:"+count);
		pageUtil.setCounts(count);
		if (count>0){
			System.out.println("--------------------->0");
			if(pageUtil.getPageindex()>pageUtil.getPagecount()) {
				pageUtil.setPageindex(pageUtil.getPagecount());
			}
			friendList = userMapper.getPageAll(pageUtil);
			pageUtil.setLists(friendList);
		}
		return friendList;
	}

	@Override
	public int getCounts() throws Exception {
		int count = userMapper.getCount();
		return count;
	}

}
