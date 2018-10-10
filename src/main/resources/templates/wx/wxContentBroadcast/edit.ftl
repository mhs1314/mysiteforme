<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>内容-轮播管理编辑--${site.name}</title>
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
    <input value="${wxContentBroadcast.id}" name="id" type="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">标题名称</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxContentBroadcast.titleName}" name="titleName"  placeholder="请输入标题名称">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">图片处理</label>
        <div class="layui-input-block">
                <input type="hidden" class="layui-input" name="image" id="image" value="${wxContentBroadcast.image}" >
                <div class="layui-upload">
                    <button type="button" class="layui-btn" id="test_image">上传图片处理</button>
                    <div class="layui-upload-list">
                        <img class="layui-upload-img" id="demo_image" <#if (wxContentBroadcast.image??)>src="${wxContentBroadcast.image}"</#if> >
                        <p id="demoText_image"></p>
                    </div>
                </div>

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">链接地址</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxContentBroadcast.url}" name="url"  placeholder="请输入链接地址">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">显示 0不显示 1显示</label>
        <div class="layui-input-block">
                <input type="checkbox" name="show"  lay-skin="switch" lay-text="是|否" value="1"  <#if (wxContentBroadcast.show == true)> checked </#if> >

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">排序</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxContentBroadcast.sort}" name="sort"  placeholder="请输入排序">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">所属模块 0首页 1资讯 2积分</label>
        <div class="layui-input-block">
                <select name="modle" >
                    <option value="" selected="">请选择所属模块 0首页 1资讯 2积分</option>
                    <@my type="wx_content_broadcast_modle">
                    <#list result as r>
                    <option value="${r.value}"  <#if (wxContentBroadcast.modle == r.value)> selected="" </#if>  >${r.label}</option>
                    </#list>
                    </@my>
                </select>

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addWxContentBroadcast">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>
<script>
    layui.use(['form','jquery','layer','upload'],function(){
        var form      = layui.form,
                $     = layui.jquery,
                upload = layui.upload,
                layer = layui.layer;

                        //普通图片上传
        var upload_image = upload.render({
            elem: '#test_image',
            url: '${base}/file/upload/',
            field:'test',
            before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo_image').attr('src', result); //图片链接（base64）
                });
            },
            done: function(res){
                //如果上传失败
                if(res.success == false){
                    return layer.msg('上传失败');
                }
                $("#image").val(res.data.url);
            },
            error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText_image');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    upload_image.upload();
                });
            }
        });

        form.on("submit(addWxContentBroadcast)",function(data){
                    if(undefined === data.field.show || '0' === data.field.show || null === data.field.show){
                data.field.show = false;
            }else{
                data.field.show = true;
            }
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //给角色赋值
            $.post("${base}/wx/wxContentBroadcast/edit",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("内容-轮播管理编辑成功！",{time:1000},function(){
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