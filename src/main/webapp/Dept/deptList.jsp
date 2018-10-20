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
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>少时诵诗书</title>
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
            <s:text name="deptno"/>
        </td>
        <td>
            <s:text name="dname"/>
        </td>
        <td>
            <s:text name="loc"/>
        </td>
        <td>
            <s:text name="empname"/>
        </td>
        <td>
            <s:text name="do"/>
        </td>
    </tr>
    <c:forEach items="${depList}" var="dept">
        <tr>
            <td>
                    ${dept.deptno}
            </td>
            <td>
                    ${dept.dname}
            </td>
            <td>
                    ${dept.deptno}
            </td>
            <td>
                    ${dept.loc}
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
            <td>
                <s:property value="%{#dept.loc}"/>
            </td>
            <td>
                <s:iterator value="%{#dept.empEntities}" var="emp" status="empIndex">
                    <s:property value="%{#emp.ename}"/>
                </s:iterator>
            </td>
            <td>
                <a href="<%=path%>/deptFind.action?deptno=${dept.deptno}">更改</a>
            </td>
        </tr>
    </s:iterator>--%>
</table>
<a href="<%=path%>/Dept/deptAdd.jsp">部门增加</a>
</body>
</html>
