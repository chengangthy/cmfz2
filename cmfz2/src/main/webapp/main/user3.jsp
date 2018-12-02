<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/30
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>
    <script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/china.js"></script>
    <script type="text/javascript">
        var toolbar = [{
            iconCls: 'icon-edit',
            text: "导入上传",
            handler: function () {
                $("#myexcel").dialog("open")
            }
        },
         '-', {
            text: "导出下载",
            iconCls: 'icon-help',
            handler: function (){
                location="${pageContext.request.contextPath}/main/exceldaochu";
            }
        }];
        $(function () {
            $(function(){
                $("#userdg").datagrid({
                    url:"selectUser",
                    toolbar: toolbar,
                    pagination:true,
                    pageSize: 3,
                    pageList: [3, 6, 9],
                    columns:[[
                        {title:"名字",field:"username",width:"100"},
                        {title:"法名",field:"dharmaName",width:"100"},
                        {title:"省份",field:"province",width:"100"},
                    ]],
                    fit: true,
                    fitColumns: true,
                });
            });
        })
        $("#excelform").form("submit",{
            url:"exceldaoru",
            success:function(data){
                alert(data)
            }


        });

        //导入

    </script>
</head>
</body>
<table id="userdg"></table>
<div id="myexcel" class="easyui-dialog" data-options="closed:true">
    <form id="excelform" method="post" enctype="multipart/form-data">
        excel导入<<input type="file" name="excelaa" id="excelbb">>
    </form>
</div>
</body>
</html>
