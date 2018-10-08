<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>内容-基本配置编辑--${site.name}</title>
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
    <input value="${wxContentConfig.id}" name="id" type="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">音视频自动播放 0不开启1开启</label>
        <div class="layui-input-block">
                <input type="checkbox" name="openAudio"  lay-skin="switch" lay-text="是|否" value="1"  <#if (wxContentConfig.openAudio == true)> checked </#if> >

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">评论留言功能：0关闭 1开启</label>
        <div class="layui-input-block">
                <input type="checkbox" name="openComment"  lay-skin="switch" lay-text="是|否" value="1"  <#if (wxContentConfig.openComment == true)> checked </#if> >

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">评论审核：0不审核 1审核</label>
        <div class="layui-input-block">
                <input type="checkbox" name="needExamine"  lay-skin="switch" lay-text="是|否" value="1"  <#if (wxContentConfig.needExamine == true)> checked </#if> >

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">浏览文章增加积分</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxContentConfig.browseIntegralNum}" name="browseIntegralNum"  placeholder="请输入浏览文章增加积分">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">评论文章增加积分</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxContentConfig.commentIntegralNum}" name="commentIntegralNum"  placeholder="请输入评论文章增加积分">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">显示相关爱好物 0不显示 1显示</label>
        <div class="layui-input-block">
                <input type="checkbox" name="showLike"  lay-skin="switch" lay-text="是|否" value="1"  <#if (wxContentConfig.showLike == true)> checked </#if> >

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addWxContentConfig">立即提交</button>
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


        form.on("submit(addWxContentConfig)",function(data){
                 if(undefined === data.field.openAudio || '0' === data.field.openAudio || null === data.field.openAudio){
                data.field.openAudio = false;
            }else{
                data.field.openAudio = true;
            }
                 if(undefined === data.field.openComment || '0' === data.field.openComment || null === data.field.openComment){
                data.field.openComment = false;
            }else{
                data.field.openComment = true;
            }
                 if(undefined === data.field.needExamine || '0' === data.field.needExamine || null === data.field.needExamine){
                data.field.needExamine = false;
            }else{
                data.field.needExamine = true;
            }
                 if(undefined === data.field.showLike || '0' === data.field.showLike || null === data.field.showLike){
                data.field.showLike = false;
            }else{
                data.field.showLike = true;
            }
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //给角色赋值
            $.post("${base}/admin/wxContentConfig/edit",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("内容-基本配置编辑成功！",{time:1000},function(){
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