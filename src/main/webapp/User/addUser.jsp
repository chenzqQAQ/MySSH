<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
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
    <%--<script type="text/javascript" src="<%=path%>/Js/jquery.sorted.js"></script>--%>
    <script type="text/javascript" src="<%=path%>/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=path%>/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=path%>/Js/common.js"></script>
    <script type="text/javascript" src="<%=path%>/Js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="<%=path%>/Js/messages_zh.js"></script>

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
    <script>
        $(function () {
            console.log("jQuery可用");
            $('#backid').click(function () {
                window.location.href = "<%=path%>/userAll.action";
            });
            $('#userName').blur(function () {
                console.log("用户名失去焦点");
                var str = $('#userName').val();
                console.log(str);
                $.ajax({
                    url: "/his/ajaxAction?userName=" + str,
                    type: "GET",
                    dataType: "text",
                    success: function (msg) {
                        console.log(msg);
                        if (msg == 1) {
                            $('#userName').siblings("span#k").text("用户名已存在");
                        } else if (msg == 0) {
                            $('#userName').siblings("span#k").text("用户名可用");
                        }
                        else if (msg == 2) {
                            $('#userName').siblings("span#k").text("用户名不能为空");
                        }
                        // $("<p>结尾</p>").appendTo($('#userName').parent());
                        console.log("执行回调函数");
                    }
                })
                return false;

            })
            $("#form1").validate(
                {
                    // debug: true,
                    onfocusout: function (element) {
                        $(element).valid();
                    },
                    rules: {
                        userName: {
                            required: true,
                            minlength: 4
                        },
                        userPassword: {
                            required: true,
                            minlength: 6
                        },
                        realname: {
                            required: true,
                        },
                        email: {
                            required: true,
                            email: true
                        }
                    },
                    messages: {
                        userName: {
                            required: "请输入用户名",
                            minlength: "用户名必需由4个字母组成"
                        },
                        userPassword: {
                            required: "请输入密码",
                            minlength: "密码长度不能小于 6 个字母"
                        },
                        realname: {
                            required: "请输入真实姓名"
                        },
                        email: "请输入一个正确的邮箱",
                    },
                    errorPlacement: function (error, element) {
                        error.appendTo(element.parent());
                    }
                }
            );
            $.validator.setDefaults({
                submitHandler: function () {
                    alert("提交事件");
                }
            });
            //异步请求全部角色信息
            $.ajax({
                url: "/his/roleAjaxAction",
                success: function (msg) {
                    var k = eval("(" + msg + ")");
                    console.log(k);
                    $.each(k, function (index, i) {
                        var option = $('<option></option>');
                        option.text(i['roleName']).val(i['roleID']).appendTo($('#role'));
                    })
                }
            });
        });
    </script>
    <style>
        label.error {

            padding-left: 16px;

            padding-bottom: 2px;

            font-weight: bold;

            color: #FF0000;
        }
    </style>
</head>
<body>
<form id="form1" action="<%=path%>/userAdd.action" method="post" class="definewidth m20">
    <input type="hidden" name="id" value="{$user.id}"/>
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">登录名</td>
            <td><input type="text" name="users.username" id="userName"/>
                <span id="k"></span>
            </td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td><input type="password" name="users.userpassword"/></td>
        </tr>
        <tr>
            <td class="tableleft">真实姓名</td>
            <td><input type="text" name="users.realname"/></td>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td><input type="text" name="users.email"/></td>
        </tr>
        <tr>
            <td class="tableleft">状态</td>
            <td>
                <input type="radio" name="users.flag" value="0" checked/> 启用
                <input type="radio" name="users.flag" value="1"/> 禁用
            </td>
        </tr>
        <tr>
            <td class="tableleft">角色</td>
            <td>
                <select id="role" name="users.roleid" required>
                    <option value="0">--请选择--</option>
                </select>
            </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">更新</button>&nbsp;&nbsp;
                <button type="button" class="btn btn-success" name="backid" id="backid">
                    返回列表
                </button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>