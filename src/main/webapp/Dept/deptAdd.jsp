<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/16
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<%
    String path=request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:i18n name="golbal_zh_CN">
    <s:form action="deptAdd" method="POST">
        <s:textfield name="deptEntity.dname" key="dname"/>
        <s:textfield name="deptEntity.loc" key="loc"/>
        <s:submit value="%{getText('add')}"/>
        <s:property value="message"/>
    </s:form>
</s:i18n>
</body>
</html>
