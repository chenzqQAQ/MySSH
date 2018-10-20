<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/11
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎<s:property value="userName"/>,登陆成功！
<a href="deptlist">sssss</a><br/>
<s:i18n name="golbal_zh_CN">
    <s:text name="username"/>
</s:i18n>
</body>
</html>
