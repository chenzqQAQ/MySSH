<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/16
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
    <style>
        /*table, tr, td {*/
        /*border: 1px black solid;*/
        /*border-collapse: collapse;*/
        /*}*/
    </style>
</head>
<body>
<s:i18n name="golbal_zh_CN">
    <s:form action="deptUpdate" method="POST">

        <s:textfield name="deptEntity.deptno" key="deptno" value="%{dept.deptno}" readonly="true"/>

        <s:textfield name="deptEntity.dname" key="dname" value="%{dept.dname}"/>

        <s:textfield name="deptEntity.loc" key="loc" value="%{dept.loc}"/>

        <s:submit value="%{getText('update')}"/>
        <a href="<%=path%>/deptlist.action">部门列表</a>
    </s:form>
</s:i18n>
</body>
</html>
