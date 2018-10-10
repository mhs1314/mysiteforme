<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>内容-轮播配置编辑--${site.name}</title>
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
    <input value="${wxContentBroadcastConfig.id}" name="id" type="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">面板指示灯 0不显示 1显示</label>
        <div class="layui-input-block">
                <input type="checkbox" name="showPoint"  lay-skin="switch" lay-text="是|否" value="1"  <#if (wxContentBroadcastConfig.showPoint == true)> checked </#if> >

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">自动切换 0不能 1可以</label>
        <div class="layui-input-block">
                <input type="checkbox" name="autoChange"  lay-skin="switch" lay-text="是|否" value="1"  <#if (wxContentBroadcastConfig.autoChange == true)> checked </#if> >

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">自动切换时间间隔（毫秒）</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxContentBroadcastConfig.autoChangeTime}" name="autoChangeTime"  placeholder="请输入自动切换时间间隔（毫秒）">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">滑动动画时长（毫秒）</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxContentBroadcastConfig.animationTime}" name="animationTime"  placeholder="请输入滑动动画时长（毫秒）">

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addWxContentBroadcastConfig">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>
<script>
    layui.use(['form','jquery','layer'],function(){
        var form      = layui.form,
                $     = layui.jquery,
                layer = layui.layer;


        form.on("submit(addWxContentBroadcastConfig)",function(data){
                 if(undefined === data.field.showPoint || '0' === data.field.showPoint || null === data.field.showPoint){
                data.field.showPoint = false;
            }else{
                data.field.showPoint = true;
            }
                 if(undefined === data.field.autoChange || '0' === data.field.autoChange || null === data.field.autoChange){
                data.field.autoChange = false;
            }else{
                data.field.autoChange = true;
            }
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //给角色赋值
            $.post("${base}/wx/wxContentBroadcastConfig/edit",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("内容-轮播配置编辑成功！",{time:1000},function(){
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