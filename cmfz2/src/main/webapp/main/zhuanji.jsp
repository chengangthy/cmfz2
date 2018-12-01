<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/29
  Time: 11:41
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
    <script type="text/javascript">
        var toolbar = [{
            iconCls: 'icon-edit',
            text: "专辑详情",
            handler: function () {
                var zz= $("#zhuanji").treegrid("getSelected");
                if(zz==null){
                    alert("请选中专辑")
                }else{
                    if(zz.author!=null){
                        $("#xiangqin").dialog("open");
                        $("#aaa1").val(zz.title)
                        $("#aaa2").val(zz.author)
                        $("#imgg").prop("src",'${pageContext.request.contextPath}/img/'+zz.coverimg);
                    }else{
                        alert("选错了")
                    }
                }
            }
        }, '-', {
            iconCls: 'icon-help',
            text: "添加专辑",
            handler: function () {

            }
        }, '-', {
            text: "添加章节",
            iconCls: 'icon-help',
            handler: function () {
                var zj = $("#zhuanji").treegrid("getSelected");
                    //alert(zj.id)
               if(zj==null){
                    alert("请选中专辑")
                }else{
                    if(zj.author!=null){
                        $("#insertzhangjie").dialog("open")
                        $("#insin3").val(zj.id);
                        //alert($("#insin3").val());
                    }else{
                        alert("选错了")
                    }

                }

            }
        }, '-', {
            text: "下载音频",
            iconCls: 'icon-help',
            handler: function () {
                var zjj = $("#zhuanji").treegrid("getSelected");
               // alert(zjj.id)
               // alert("aaa")
                if(zjj==null){
                    alert("请选中章节")
                }else{
                    if(zjj.duration!=null){
                       location="${pageContext.request.contextPath}/main/download?url="+zjj.downpath+"&title="+zjj.title;
                    }else{
                        alert("选错了")
                    }
                }
            }
        }];





        $(function(){
            $('#zhuanji').treegrid({
                onDblClickRow: function (row) {
                    $("#ssqsq").dialog("open")
                   // alert("aa")
                    $("#audio_id").prop("src","${pageContext.request.contextPath}/upload/"+row.downpath)
                },
                url:'selectAlbum',
                toolbar: toolbar,
                pagination:true,
                idField:'id',
                treeField:'title',
                fit: true,
                fitColumns: true,
                lines:true,
                animate:true,
                pageSize: 15,
                pageList: [5, 15, 20],
                columns:[[
                    {field:'title',title:'名称',width:80},
                    {field:'downpath',title:'下载路径',width:60,align:'right'},
                    {field:'size',title:'章节大小',width:80},
                    {field:'duration',title:'时长',width:80}
                ]],
            });


        //详情的对话框
        $('#xiangqin').dialog({
            title: '专辑详情',
            width: 400,
            height: 200,
        });

        //播放
            $('#ssqsq').dialog({
                title: '播放',
                width: 400,
                height: 200,
            });

        });

        //添加章节
        function insertzhangjie(){
            //alert($("#insin3").val());
            $('#insertformzhangjie').form("submit", {
                url:"insertSection",
                success:function(data){
                    if(data=="true"){
                        $("#insertzhangjie").dialog("close")
                        $("#zhuanji").treegrid("reload");
                    }else{
                        alert("错误");
                    }
                }
        });

        }

    </script>
</head>
<body>
<%--专辑tree--%>
<table id="zhuanji" style="width:600px;height:400px"></table>

<div id="insertzhangjie" class="easyui-dialog" data-options="closed:true">
    <form id="insertformzhangjie" method="post" enctype="multipart/form-data">
        选择文件<input id="insin1" name="chapter" type="file"><br/>
        标题<input id="insin2" name="title" type="text" ><br/>
        <input id="insin3" type="hidden" name="albumid" >
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="insertzhangjie()">添加</a>
    </form>
</div>

<%--详情对话框--%>
    <div id="xiangqin" class="easyui-dialog" data-options="closed:true">
        <form>
        标题<input id="aaa1" type="text" value=""></br>
        作者<input id="aaa2" type="text" value=""></br>
        照片<img src="" id="imgg" width="50" height="50">
        </form>
    </div>


<div id="ssqsq" class="easyui-dialog" data-options="closed:true">
    <audio id="audio_id" src="" autoplay="autoplay" controls="controls" loop="loop"></audio>
</div>

</body>
</html>
