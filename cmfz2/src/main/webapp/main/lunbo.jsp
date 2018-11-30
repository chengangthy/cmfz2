<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/27
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>
</head>
<body>
<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-edit',
        text: "添加",
        handler: function () {
            $("#insertdiv").dialog("open")


        }
    }, '-', {
        iconCls: 'icon-help',
        text: "删除",
        handler: function () {
            //alert('帮助按钮')
            var degetSelections = $("#dg").edatagrid("getSelected")
            //alert(degetSelections)
            if(degetSelections==null){
               // alert("dada")
                $.messager.alert("删除","请选中要删除的数据","warning");
            }else{
                $.messager.confirm("删除","你确定要删除吗",function(r){
                    if(r){
                        //alert("执行")
                        //var ids = new Array(degetSelections.length);
                        //alert(degetSelections);
                        var id=degetSelections.id;
                        $.ajax({
                            url:"deleteView",
                            data:{"id":id},
                            traditional:true,
                            success:function(data){
                                //alert(data)
                                if(data){
                                    $("#dg").datagrid("reload");
                                }else{
                                    $.messager.alert("删除","删除失败","error");
                                }
                            }
                        });

                    }
                });
            }

        }
    }, '-', {
        text: "修改",
        iconCls: 'icon-help',
        handler: function () {
            /*获取选中行*/
            var row = $("#dg").edatagrid("getSelected")
            if (row == null) {
                $.messager.show({
                    title: '警告',
                    msg: '请选中修改行。',
                    showType: 'show',
                    style: {
                        right: '',
                        top: document.body.scrollTop + document.documentElement.scrollTop,
                        bottom: ''
                    }
                });
            } else {
                /*将当前行变成可编辑模式*/
                var index = $("#dg").edatagrid("getRowIndex", row);
                $("#dg").edatagrid("editRow", index);
            }

        }
    }, '-', {
        text: "保存",
        iconCls: 'icon-help',
        handler: function () {
            $("#dg").edatagrid("saveRow");

        }
    }];


            $(function(){
                $("#dg").edatagrid({
                    url:"selectView",
                    updateUrl:"updateView",
                    toolbar: toolbar,
                    pagination:true,
                    fit: true,
                    fitColumns: true,
                    pageSize: 3,
                    pageList: [3, 6, 9],
                    view: detailview,
                    columns:[[
                         {title:"标题",field:"title"},
                         {title:"状态",field:"status",editor:{
                                 type:"text",
                                 options:{
                                     required:true
                                 }
                             }},
                         {title:"路径",field:"imgPath"},
                         {title:"时间",field:"date"},
                    ]],

                    detailFormatter: function (rowIndex, rowData) {
                        return '<table><tr>' +
                            '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/img/' + rowData.imgPath + '" style="height:50px;"></td>' +
                            '<td style="border:0">' +
                            '<p>时间: ' + rowData.date + '</p>' +
                            '<p>:描述:' + rowData.desc + '</p>' +
                            '</td>' +
                            '</tr></table>';
                    }

                });
            });



            function insertform(){
                alert("tadawd")
                $("#insertform").form("submit",{
                    url:"insertView",
                    success:function(data){
                        if(data=="true"){
                            $("#insertdiv").dialog("close");
                            $("#dg").datagrid("reload");
                        }else{
                            alert("添加失败")
                        }
                    }
                });
            }

</script>
<table id="dg"></table>
<div id="insertdiv" class="easyui-dialog" data-options="closed:true">
    <form id="insertform" method="post" enctype="multipart/form-data">
        标题<input id="insin2" name="title" type="text"><br/>
        描述<input id="insin3" name="desc" type="text"><br/>
        照片<input id="insin4" name="uploadFile" type="file">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="insertform()">添加</a>
    </form>
</div>
</body>
</html>
