<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>门诊查询--中软高科-2015</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=path%>/Css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/Css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/Css/style.css"/>
    <script type="text/javascript" src="<%=path%>/Js/jquery.js"></script>
    <%--<script type="text/javascript" src="/his/Js/jquery.sorted.js"></script>--%>
    <script type="text/javascript" src="<%=path%>/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=path%>/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=path%>/Js/common.js"></script>
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
        $(function () {
            $('#newNav').click(function () {
                window.location.href = "<%=path%>/registration/add.jsp";
            });
            $('#exlOutAll').click(function () {
                //全部数据导出
                $.ajax({
                    url: "/his/exlOut",
                    type: "GET",
                    success: function (msg) {
                        var k = eval("(" + msg + ")");
                        console.log(k['message']);
                        if (parseInt(k['message']) === 1) {
                            alert("Excel导出成功");
                            var form = $('#form2');
                            $('input[name=url]').val(k['url']);
                            form.submit();
                        }
                        else {
                            alert("Excel导出失败");
                        }
                    }
                });
                return false;
            })
            $('#exlOut').click(function () {
                //选择部分导出exl
                var alls = document.getElementsByName("check");
                var str = "/his/exlOut?all=All";
                for (var i = 0; i < alls.length; i++) {
                    if (alls[i].checked) {
                        str = str + "&medicalNum=" + alls[i].value;
                    }
                }
                console.log(str);
                $.ajax({
                    url: str,
                    type: "POST",
                    success: function (msg) {
                        var k = eval("(" + msg + ")");
                        console.log(k);
                        if (parseInt(k['message']) === 1) {
                            alert("Excel导出成功");
                            var form = $('#form2');
                            $('input[name=url]').val(k['url']);
                            form.submit();
                        }
                        else {
                            alert("Excel导出失败");
                        }
                    }
                });
                return false;
            })
        });

        function checkall() {
            var alls = document.getElementsByName("check");
            var ch = document.getElementById("checkall");
            var i;
            if (ch.checked) {
                for (i = 0; i < alls.length; i++) {
                    alls[i].checked = true;
                }
            } else {
                for (i = 0; i < alls.length; i++) {
                    alls[i].checked = false;
                }
            }
        }

        function delAll() {
            var alls = document.getElementsByName("check");
            var ids = new Array();
            var str = "/his/registerAction?action=delAll";
            for (var i = 0; i < alls.length; i++) {
                if (alls[i].checked) {
                    ids.push(alls[i].value);
                    str = str + "&medicalNum=" + alls[i].value;
                }
            }
            if (ids.length > 0) {
                console.log(str);
                if (confirm("确认退号?")) {
                    window.location.href = str;
                    alert("退号成功!");
                }
            } else {
                alert("请选中要删除的项");
            }
        }

        //清空查询的条件
        function clearA() {
            $("input[name='medicalNum']").val("");
            $("input[name='docName']").val("");
            $("input[name='depName']").val("");
            $("input[name='time1']").val("");
            $("input[name='time2']").val("");
        }

        $(function () {
            <%--var k = jQuery.parseJSON('${docs}');--%>
        });
    </script>
    <script type="text/javascript">
        var datepicker1 = {
            lang: 'zh-cn',
            dateFmt: 'yyyy-MM-dd',
            minDate: '1980-1-1',
            maxDate: '#F{$dp.$D(\'time2\')||\'%y-%M-%d\'}',
            startDate: '2018-9-20',
            readOnly: true,
            highLineWeekDay: true,
            isShowWeek: true
        };
        var datepicker2 = {
            lang: 'zh-cn',
            dateFmt: 'yyyy-MM-dd',
            minDate: '#F{$dp.$D(\'time1\')}',
            maxDate: new Date(),
            startDate: new Date() || '#F{$dp.$D(\'time1\')}',
            readOnly: true,
            highLineWeekDay: true,
            isShowWeek: true
        };
    </script>
    <script type="text/javascript">
        /**
         * 校验规则
         */
        var rules = {
            medicalNum: {
                number: true,
                maxlength: 15
            }

        };
        /**
         * 错误提示信息
         */
        var messages = {
            medicalNum: {
                number: "请输入数字",
                maxlength: "请输入合理病历号"
            }
        };
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
                        element.after(error);
                        // error.appendTo(element);
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
</head>
<body>
<form id="form2" action="/his/down" method="post" hidden>
    <input type="hidden" name="url" value="">
</form>
<form action="/his/registerFindAction" method="post" class="definewidth m20" id="form1">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">病历号：</td>
            <td><input type="text" name="medicalNum" value="${sessionScope.medicalNum}"/></td>

            <td width="10%" class="tableleft">主治医生：</td>
            <td><input type="text" name="docName" value="${sessionScope.docName}"/></td>

            <td width="10%" class="tableleft">科室：</td>
            <td><input type="text" name="depName" value="${sessionScope.depName}"/></td>
        </tr>
        <tr>

            <td width="10%" class="tableleft">挂号时间：</td>

            <td colspan="5">
                <input type="text" id="time1" name="time1" class="Wdate" autocomplete="off"
                       onfocus="WdatePicker(datepicker1)" value="${sessionScope.time1}"/>&nbsp;至&nbsp;
                <input type="text" id="time2" name="time2" class="Wdate" autocomplete="off"
                       onfocus="WdatePicker(datepicker2)" value="${sessionScope.time2}"/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="submit" class="btn btn-primary">查询</button>
                <button class="btn btn-primary" type="button" onclick="clearA();return false">清空</button>

            </td>
        </tr>
    </table>
</form>

<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>门诊编号</th>
        <th>病人姓名</th>
        <th>主治医生</th>
        <th>挂号时间</th>
        <th>挂号科室</th>
        <th>状态</th>
        <script>
        </script>
        <% String[] p = {"已挂号", "已就诊", "已取药", "已退号"};
            request.setAttribute("p", p);
        %>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${registerList}" var="register" varStatus="id">
        <tr>
            <td style="vertical-align:middle;"><input type="checkbox" name="check" value="${register.medicalnum}"></td>
            <td style="vertical-align:middle;">${register.medicalnum}
            </td>
            <td style="vertical-align:middle;">${register.registername}
            </td>
            <td style="vertical-align:middle;">
                    ${register.doctor.doctorname}
            </td>
            <td style="vertical-align:middle;">
                未知时间
            </td>
            <td style="vertical-align:middle;">
                    ${register.doctor.dep.depname}
            </td>
            <td style="vertical-align:middle;">${register.flag}
            </td>
            <td style="vertical-align:middle;">
                <a href="/his/registerAction?action=find&medicalNum=${register.medicalnum}">详情>>>
                </a>&nbsp;&nbsp;&nbsp;
                <c:if test="${register.flag!=3}">
                    <a href="<%=path%>/registerFind.action?register.medicalnum=${register.medicalnum}">更改</a>&nbsp;&nbsp;&nbsp;
                    <a href="/his/registerAction?action=del&medicalNum=${register.medicalnum}">退号</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>

<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <th colspan="5">
            <div class="inline pull-right page">
                <c:set value="${page.pageNo>1?page.pageNo-1:1}" var="up" scope="page"/>
                <c:set value="${page.pageNo<page.totalPage?page.pageNo+1:page.totalPage}" var="down" scope="page"/>

                <a href='/his/registerFindAction?pageNo=1'>第一页</a> <a
                    href='/his/registerFindAction?pageNo=${up}'>上一页</a>
                <span class='current'>${page.pageNo}</span>
                <a href='/his/registerFindAction?pageNo=${down}'>下一页</a>
                <a href='/his/registerFindAction?pageNo=${page.totalPage}'>最后一页</a>
                &nbsp;&nbsp;&nbsp;共<span class='current'>${page.totalCount}</span>条记录<span
                    class='current'> ${page.pageNo}/${page.totalPage} </span>页
            </div>
            <div>
                <button type="button" class="btn btn-success" id="newNav">门诊挂号</button>&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-success" id="delPro" onClick="delAll();">退号</button>&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-success" id="exlOutAll">全部导出Excel</button>
                <button type="button" class="btn btn-success" id="exlOut">选中部分导出Excel</button>
                <button type="button" class="btn btn-success" id="delPro2">打印</button>

            </div>

        </th>
    </tr>
</table>

</body>
</html>
