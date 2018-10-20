<%@ page import="com.you.bean.Department" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<%
    String path = request.getContextPath();
    Department department;
%>
<head>
    <title>挂号</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=path%>/Css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/Css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/Css/style.css"/>
    <script type="text/javascript" src="<%=path%>/Js/jquery.js"></script>
    <%--<script type="text/javascript" src="../Js/jquery.sorted.js"></script>--%>
    <script type="text/javascript" src="<%=path%>/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=path%>/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=path%>/Js/common.js"></script>
    <script type="text/javascript" src="<%=path%>/Js/ckeditor/ckeditor.js"></script>
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
    <script type="text/javascript">
        /**
         * 进入页面时，更新全部科室信息
         */
        function findAllDep() {
            $.ajax({
                url: "<%=path%>/depAjax.action",
                success: function (msg) {
                    /*                    console.log("ajax请求成功，开始执行成功后的回调函数");
                                        console.log(msg);*/
                    var deps = eval("(" + msg + ")");
                    $('#depName').empty();
                    $.each(deps, function (item, dep) {
                        /*                        console.log(dep['depid']);
                                                console.log(dep['depname']);*/
                        var option = $("<option></option>");
                        option.val(dep['depid']).text(dep['depname']).appendTo($('#depName'));
                    })
                    //全部科室信息添加后,选取首位科室id去将该科室的全部医生显示到页面上
                    updateDocName();
                }

            });
        }

        /**
         * 当科室确定是，更新该科室的医生信息
         */
        function updateDocName() {
            $.ajax({
                url: "<%=path%>/docAjax.action",
                data: {
                    "department.depid": $("#depName").val()
                },
                success: function (msg) {
                    console.log("ajax请求成功，开始执行成功后的回调函数");
                    var docs = eval("(" + msg + ")");
                    $('#docName').empty();
                    $.each(docs, function (item, doc) {
                        console.log(doc['doctorName']);
                        var option = $("<option></option>");
                        option.val(doc['docid']).text(doc['doctorname']).appendTo($('#docName'));
                    })
                }

            })
        }

        /**
         * 校验规则
         */
        var rules = {
            registerName: {
                required: true,
                minlength: 2
            },
            identifierNum: {
                required: true,
                minlength: 6,
                number: true
            },
            socialSecurityNum: {
                required: true,
                minlength: 10,
                number: true
            }, phoneNum: {
                required: true,
                minlength: 8,
                number: true
            }, age: {
                required: true,
                number: true

            },
            expenseFlag: {
                required: true
            },
            sex: {
                required: true
            },
            czFlag: {
                required: true
            },
            depName: {
                required: true
            },
            docName: {
                required: true
            }

        };
        /**
         * 错误提示信息
         */
        var messages = {
            registerName: {
                required: "请输入用户名",
                minlength: "用户名必需由2个及以上字母组成"
            },
            identifierNum: {
                required: "请输入证件号",
                minlength: "证件号长度不能小于 6 个数字",
                number: "情输入数字"
            },
            socialSecurityNum: {
                required: "请输入社保号",
                minlength: "社保号长度不能小于 10 个数字",
                number: "情输入数字"
            },
            phoneNum: {
                required: "请输入联系电话",
                minlength: "联系电话长度不能小于8个数字",
                number: "情输入数字"
            },
            age: {
                required: "请输入年龄",
                number: "情输入数字"

            },
            expenseFlag: {
                required: "请输入自费信息"
            },
            sex: {
                required: "请输入性别"
            },
            czFlag: {
                required: "请输入初复诊信息"
            },
            depName: {
                required: "请选择科室"
            },
            docName: {
                required: "请选择医生"
            }
        };
        /**
         * 启动校验框架
         */
        $(function () {
            $("#form1").validate(
                {
                    // "debug": true,
                    //失去焦点验证
                    onfocusout: function (element) {
                        $(element).valid();
                    },
                    "rules": rules,
                    "messages": messages,
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
        })
    </script>
    <script type="text/javascript">
        $(function () {
            console.log("jQuery可用")
            $('#backid').click(function () {
                window.location.href = "<%=path%>/registerList.action";
            });
            $('#depName').change(function () {
                updateDocName();
            });
            //页面加载后，异步查询全部科室
            findAllDep();
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
<form id="form1" action="<%=path%>/registerAdd.action" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">姓名</td>
            <td><input type="text" name="register.registername" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件类型</td>
            <td><select name="register.identifiertype">
                <option value="0">身份证</option>
                <option value="1">护照</option>
                <option value="2">军人证</option>
            </select></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件号</td>
            <td><input type="text" name="register.identifiernum" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">社保号</td>
            <td><input type="text" name="register.socialsecuritynum" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">挂号费</td>
            <td><input type="text" name="free" value="5"/>元</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">联系电话</td>
            <td><input type="text" name="register.phonenum" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">是否自费</td>
            <td><input type="radio" name="register.expenseflag" value="0" checked/>否&nbsp;&nbsp;&nbsp;
                <input type="radio" name="register.expenseflag" value="1"/>是
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">性别</td>
            <td><input type="radio" name="register.sex" value="1" checked/>男&nbsp;&nbsp;&nbsp;
                <input type="radio" name="register.sex" value="0"/>女
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">年龄</td>
            <td><input type="text" name="register.age" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">职业</td>
            <td><input type="text" name="register.profession" value=""/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">初复诊</td>
            <td><input type="radio" name="register.czflag" value="0" checked/>初诊&nbsp;&nbsp;&nbsp;
                <input type="radio" name="register.czflag" value="1"/>复诊
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">所挂科室</td>
            <td><select id="depName">
                <option>急诊科</option>
                <option>骨科</option>
                <option>血液科</option>
            </select></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">指定医生</td>
            <td><select name="register.doctor.docid" id="docName">
                <option>程俊</option>
                <option>欧阳雨露</option>
                <option>王博</option>
            </select></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">备注</td>
            <td><textarea name="register.remark"></textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <center>
                    <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button
                        type="button" class="btn btn-success" name="backid" id="backid">返回列表
                </button>
                </center>
            </td>
        </tr>
    </table>
</form>
</body>
</html>