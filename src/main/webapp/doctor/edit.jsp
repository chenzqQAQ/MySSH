<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<% String path = request.getContextPath();
%>
<html>
<head>
    <title>修改医生---2015</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=path%>/Css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/Css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/Css/style.css"/>
    <script type="text/javascript" src="<%=path%>/Js/jquery.js"></script>
    <%--<script type="text/javascript" src="<%=path%>/Js/jquery.sorted.js"></script>--%>
    <script type="text/javascript" src="<%=path%>/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=path%>/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=path%>/Js/common.js"></script>
    <script type="text/javascript" src="<%=path%>/Js/ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="<%=path%>/Js/My97DatePicker/WdatePicker.js"></script>
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
        $.validator.addMethod("isBlank", function (value, element) {
            var pattern = new RegExp("[`~!@#$^&*=|{}':;',\\[\\]<>《》/?~！@#￥……&*|{}【】‘；：”“'。，、？' ']");
            var reg = /^([0-9]+)$/;//全部为数字

            if (pattern.test(value)) {
                return false;
            } else if (value.indexOf(" ") != -1) {
                return false;
            } else {
                return true;
            }
        }, '不能包含特殊字符');
        var rule = {
            doctorName: {
                required: true,
                minlength: 2,
                isBlank: true
            },
            identifierType: {
                required: true
            }, identifierNum: {
                required: true,
                minlength: 10,
                digits: true
            }, phoneNum: {
                required: true,
                rangelength: [11, 11],
                digits: true
            }, sex: {
                required: true
            }, birthday: {
                required: true
            }, age: {
                required: true
            }, email: {
                required: true,
                email: true
            }, depId: {
                required: true
            }, degree: {
                required: true,
            }
        };
        var message = {
            doctorName: {
                required: "请输入医生姓名",
                minlength: "名字必须二个字符以上"
            },
            identifierType: {
                required: "请选择证件类型"
            }, identifierNum: {
                required: "请输入证件号",
                minlength: "证件号必须8位及以上",
                digits: "证件号必须是整数"

            }, phoneNum: {
                required: "请输入手机号",
                rangelength: "手机号必须11位",
                digits: "手机号号必须是整数"
            }, sex: {
                required: "请选择性别"
            }, birthday: {
                required: "请选择出生日期"
            }, age: {
                required: "请输入年龄"
            }, email: {
                required: "请输入电子邮箱",
                email: "请输入正确的电子邮箱地址"
            }, depId: {
                required: "请选择科室"
            }, degree: {
                required: "请选择学历",
            }
        };
    </script>
    <script type="text/javascript">
        var datepicker = {
            lang: 'zh-cn',
            dateFmt: 'yyyy-MM-dd',
            minDate: '1949-10-1',
            maxDate: new Date(),
            startDate: '1990-1-1',
            readOnly: true,
            highLineWeekDay: true
        };

        function findAllDep() {
            $.ajax({
                url: "<%=path%>/depAjax.action",
                success: function (msg) {
                    var deps = eval("(" + msg + ")");
                    $('#depId').empty();
                    $.each(deps, function (item, dep) {
                        var option = $("<option></option>");
                        option.val(dep['depid']).text(dep['depname']).appendTo($('#depId'));
                    })
                    $("#depId").val(${doctor.dep.depid});
                }

            });
        }

        $(function () {
            $('#backid').click(function () {
                window.location.href = "<%=path%>/docsFind.action";
            });
            findAllDep();
            $("input[name='sex'][value=${doctor.sex}]").prop("checked", "true");
            $("#identifierType").val(${doctor.identifiertype});
            $("#degree").val(${doctor.degree});
            $('#birthday').blur(function () {
                var myyear = $(this).val();
                // console.log(myyear);
                var age = 2018 - parseInt(myyear);
                // console.log(age);
                if (!isNaN(age)) {
                    $('#age').siblings("span").text(age).end()
                        .val(age)
                }
            });
            $('#form1').validate({
                rules: rule,
                messages: message,
                onfocusout: function (element) {
                    $(element).valid();
                },
                errorPlacement: function (error, element) {
                    error.appendTo(element.parent());
                }
            });
            $.validator.setDefaults({
                submitHandler: function () {
                    alert("提交事件");
                }
            });
        });
    </script>
</head>
<body>
<form id="form1" action="<%=path%>/docUpdate.action" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <input type="hidden" name="doctor.docid" value="${doctor.docid}">
            <td width="10%" class="tableleft">姓名</td>
            <td><input type="hidden" name="doctor.doctorname" value="${doctor.doctorname}"/>
                <input type="text" name="doctor.doctorname" value="${doctor.doctorname}" disabled/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件类型</td>
            <td><input type="hidden" name="doctor.identifiertype" value="${doctor.identifiertype}"/>
                <select name="doctor.identifiertype" id="identifierType" disabled>
                    <option value="0">身份证</option>
                    <option value="1">护照</option>
                    <option value="2">军人证</option>
                </select></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">证件号</td>
            <td><input type="hidden" name="doctor.identifiernum" value="${doctor.identifiernum}"/>
                <input type="text" name="doctor.identifiernum" value="${doctor.identifiernum}" disabled/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">手机</td>
            <td><input type="text" name="doctor.phonenum" value="${doctor.phonenum}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">座机</td>
            <td><input type="text" name="doctor.seatphonenum" value="${doctor.seatphonenum}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">性别</td>
            <td><input type="radio" name="doctor.sex" value="1" checked/>男&nbsp;&nbsp;&nbsp;
                <input type="radio" name="doctor.sex" value="0"/>女
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">出生年月</td>
            <td><input type="text" name="doctor.birthday" value="${doctor.birthday}" id="birthday"
                       class="Wdate"
                       onfocus="WdatePicker(datepicker)"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">年龄</td>
            <td>
                <input type="hidden" name="doctor.age" value="${doctor.age}" id="age"/>
                <span>${doctor.age}</span>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">电子邮箱</td>
            <td><input type="text" name="doctor.email" value="${doctor.email}"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">所属科室</td>
            <td>
                <select name="doctor.dep.depid" id="depId">
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">学历</td>
            <td>
                <select name="doctor.degree" id="degree">
                    <option value="0">专科</option>
                    <option value="1">本科</option>
                    <option value="2">博士</option>
                    <option value="3">博士后</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">备注</td>
            <td><textarea name="doctor.remark" id="remark">${doctor.remark}</textarea></td>
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