<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录</title>
</head>
<body>


	        <form action="${pageContext.request.contextPath }/login/dologin.html" method="post" >
				<div class="info">${error }</div>
				<div class="inputbox">
                    <label for="userCode">用户名：</label>
					<input type="text" class="input-text" id="userCode" name="userCode" placeholder="请输入用户名" required/>
				</div>	
				<div class="inputbox">
                    <label for="userPassword">密码：</label>
                    <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" required/>
                </div>
                    <input type="submit" value="登录"/>
                    <input type="reset" value="重置"/>
			</form>
</body>
</html>
