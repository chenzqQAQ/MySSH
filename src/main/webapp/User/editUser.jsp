<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<% String path = request.getContextPath();
%>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=path%>/Css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/Css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/Css/style.css"/>
    <script type="text/javascript" src="<%=path%>/Js/jquery.js"></script>
    <%--<script type="text/javascript" src="../Js/jquery.sorted.js"></script>--%>
    <script type="text/javascript" src="<%=path%>/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=path%>/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=path%>/Js/common.js"></script>


    <style type="text/css">
        body {
            padding-bottom: 40px;
        }

        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
    </style>
    <script type="text/javascript">
        //异步请求全部角色信息
        $.ajax({
            url: "<%=path%>/roleAjaxAction",
            success: function (msg) {
                var k = eval("(" + msg + ")");
                console.log(k);
                $.each(k, function (index, i) {
                    var option = $('<option></option>');
                    option.text(i['roleName']).val(i['roleID']).appendTo($('#role'));
                })
                document.getElementById('role').value =${user.roleID};
            }
        });
    </script>
</head>
<body>
<form action="<%=path%>/userUpdate.action" method="post" class="definewidth m20">
    <input type="hidden" name="users.userid" value="${users.userid}"/>
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">登录名</td>
            <td><input type="text" name="users.username" value="${users.username}"/></td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td><input type="password" name="users.userpassword" value="${users.userpassword}"/></td>
        </tr>
        <tr>
            <td class="tableleft">真实姓名</td>
            <td><input type="text" name="users.realname" value="${users.realname}"/></td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td><input type="text" name="users.email" value="${users.email}"/></td>
        </tr>
        <tr>
            <td class="tableleft">状态</td>
            <td>
                <input type="radio" name="users.flag" value="0"/> 启用
                <input type="radio" name="users.flag" value="1"/> 禁用
            </td>
            <script>
                document.getElementsByName('users.flag')[${users.flag}].setAttribute("checked", "true");
            </script>
        </tr>
        <tr>
            <td class="tableleft">角色</td>
            <td>
                <select name="role" id="role">
                </select>
            </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">更新</button>&nbsp;&nbsp;<button type="button"
                                                                                                           class="btn btn-success"
                                                                                                           name="backid"
                                                                                                           id="backid">
                返回列表
            </button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<script>
    $(function () {
        $('#backid').click(function () {
            window.location.href = "<%=path%>/userAll.action";
        });
    });
</script>