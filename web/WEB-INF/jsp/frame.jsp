<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<c:if test="${empty pageUtil}">
    <jsp:forward page="${pageContext.request.contextPath}/login/getPage"></jsp:forward>
</c:if>--%>
<table border="1">
    <c:forEach items="${pageUtil.lists}" var="u">
        <tr>
            <td>${u.getUserName()}</td>
            <td>${u.getRole().getRoleName()}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="10">当前页[${pageUtil.pageindex}/${pageUtil.pagecount}]
            <c:if test="${pageUtil.pageindex>1}">
                <a href="${pageContext.request.contextPath}/login/getPage?pageIndex=1">首页</a>
                <a href="${pageContext.request.contextPath}/login/getPage?pageIndex=${pageUtil.pageindex-1}">上一页</a>
            </c:if> <c:if test="${pageUtil.pageindex<pageUtil.pagecount}">
                <a href="${pageContext.request.contextPath}/login/getPage?pageIndex=${pageUtil.pageindex+1}">下一页</a>
                <a href="${pageContext.request.contextPath}/login/getPage?pageIndex=${pageUtil.pagecount}">尾页</a>
            </c:if>
        </td>
    </tr>
</table>
</body>
</html>
