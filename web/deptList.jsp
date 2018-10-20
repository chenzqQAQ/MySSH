<%@ page import="com.you.bean.DeptEntity" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/15
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <style>
        table, tr, td {
            border: 1px black solid;
            border-collapse: collapse;
        }
    </style>
</head>
<body><s:i18n name="golbal_zh_CN">
    <s:text name="username"/>
</s:i18n>
<table>
    <tr>
        <td>
            部门编号
        </td>
        <td>
            部门名称
        </td>
    </tr>
    <%
        List<DeptEntity> depList= (List<DeptEntity>) request.getAttribute("depList");
        System.out.println("前台取值长度"+depList.size());
    %>
    <c:forEach items="${depList}" var="dept">
        <tr>
            <td>
                ${dept.deptno}
            </td>
            <td>
                ${dept.dname}
            </td>
        </tr>
    </c:forEach>
    <%--<s:iterator value="depts" var="dept" status="deptIndex">
        <tr>
            <td>
                <s:property value="%{#dept.deptno}"/>
            </td>
            <td>
                <s:property value="%{#dept.dname}"/>
            </td>
        </tr>
    </s:iterator>--%>
</table>
</body>
</html>
