<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>统计表编辑--${site.name}</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <meta name="description" content="${site.description}"/>
    <meta name="keywords" content="${site.keywords}"/>
    <meta name="author" content="${site.author}"/>
    <link rel="icon" href="${site.logo}">
    <link rel="stylesheet" href="${base}/static/layui/css/layui.css" media="all" />
    <style type="text/css">
        .layui-form-item .layui-inline{ width:33.333%; float:left; margin-right:0; }
        @media(max-width:1240px){
            .layui-form-item .layui-inline{ width:100%; float:none; }
        }
        .layui-form-item .role-box {
            position: relative;
        }
        .layui-form-item .role-box .jq-role-inline {
            height: 100%;
            overflow: auto;
        }

    </style>
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <input value="${wxSysCount.id}" name="id" type="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">打开次数</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxSysCount.openNum}" name="openNum"  placeholder="请输入打开次数">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">访问次数</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxSysCount.seeNum}" name="seeNum"  placeholder="请输入访问次数">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">新访问次数</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxSysCount.newSeeNum}" name="newSeeNum"  placeholder="请输入新访问次数">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">分享次数</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxSysCount.shareNum}" name="shareNum"  placeholder="请输入分享次数">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">时间</label>
        <div class="layui-input-block">
                <input type="text" name="sysTime" id="sysTime" <#if (wxSysCount.sysTime)??>value="${wxSysCount.sysTime?string('yyyy-MM-dd')}"</#if>  lay-verify="date" placeholder="请选择时间" autocomplete="off" class="layui-input">

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addWxSysCount">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>
<script>
    layui.use(['form','jquery','layer','laydate'],function(){
        var form      = layui.form,
                $     = layui.jquery,
                layer = layui.layer;

                          //初始赋值

                          laydate.render({
                            elem: '#sysTime'
<#if (wxSysCount.sysTime)??>
                            ,value: '${wxSysCount.sysTime?string("yyyy-MM-dd")}'
</#if>
                          });


        form.on("submit(addWxSysCount)",function(data){
                               if(null === data.field.sysTime || "" ===data.field.sysTime){
                                delete data.field["sysTime"];
                            }else{
                                data.field.sysTime = new Date(data.field.sysTime);
                            }
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //给角色赋值
            $.post("${base}/wx/wxSysCount/edit",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("统计表编辑成功！",{time:1000},function(){
                        parent.layer.close(parent.editIndex);
                        //刷新父页面
                        parent.location.reload();
                    });
                }else{
                    layer.msg(res.message);
                }
            });
            return false;
        });

    });
</script>
</body>
</html>