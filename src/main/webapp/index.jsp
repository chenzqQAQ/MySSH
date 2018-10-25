<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/29
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <%--<meta content="text/html;charset=UTF-8"/>--%>
    <title>主页面</title>
</head>
<body>
用户名
<h1>Hello World From Struts2</h1>
<s:i18n name="golbal_zh_CN">
    <s:form action="login">
        <s:text name="czq"/>
        <s:text name="username"/>
        <s:textfield name="user.userName"/>
        <s:submit value="%{getText('submit')}"/>
        <s:property value="message"/>
    </s:form>
</s:i18n>
<a href="<%=path%>/deptlist.action">部门列表</a>
<a href="<%=path%>/registration/add.jsp">挂号</a>
</body>
</html>
