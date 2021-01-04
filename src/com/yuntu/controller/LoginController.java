package com.yuntu.controller;



import com.yuntu.pojo.User;
import com.yuntu.service.UserService;
import com.yuntu.utils.PageUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
private Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/dologin.html",method=RequestMethod.POST)
	public String doLogin(@RequestParam String userCode, @RequestParam String userPassword, HttpServletRequest request, HttpSession session) throws Exception{
		logger.debug("doLogin====================================");
		//调用service方法，进行用户匹配
		User user = userService.login(userCode,userPassword);
		if(null != user){//登录成功
			//放入session
			session.setAttribute("userSession", user);
			//页面跳转（frame.jsp）
			return "redirect:/login/getPage";
		}else{
			//页面跳转（login.jsp）带出提示信息--转发
			request.setAttribute("error", "用户名或密码不正确");
			return "login";
		}
	}

	@RequestMapping(value = "/getPage",method = RequestMethod.GET)
	public String getPage(Integer pageIndex, HttpSession session) throws Exception {
		logger.debug("--------------getPage");
		if (pageIndex == null){
			pageIndex = 1;
		}
		PageUtil<User> pageUtil = new PageUtil<User>();
		pageUtil.setPageindex(pageIndex);
		pageUtil.setPagesize(2);
		userService.getPageAll(pageUtil);
		session.setAttribute("pageUtil",pageUtil);
		return "frame";
	}
}
