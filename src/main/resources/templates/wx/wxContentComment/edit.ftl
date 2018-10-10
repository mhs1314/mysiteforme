<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>内容-评论编辑--${site.name}</title>
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
    <input value="${wxContentComment.id}" name="id" type="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">用户唯一标识</label>
        <div class="layui-input-block">
                <textarea name="openId"   placeholder="请输入用户唯一标识" class="layui-textarea">${wxContentComment.openId}</textarea>

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">显示 0不显示 1显示</label>
        <div class="layui-input-block">
                <input type="checkbox" name="show"  lay-skin="switch" lay-text="是|否" value="1"  <#if (wxContentComment.show == true)> checked </#if> >

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户姓名</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxContentComment.userName}" name="userName"  placeholder="请输入用户姓名">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户头像</label>
        <div class="layui-input-block">
                <input type="hidden" class="layui-input" name="userIcon" id="userIcon" value="${wxContentComment.userIcon}" >
                <div class="layui-upload">
                    <button type="button" class="layui-btn" id="test_userIcon">上传用户头像</button>
                    <div class="layui-upload-list">
                        <img class="layui-upload-img" id="demo_userIcon" <#if (wxContentComment.userIcon??)>src="${wxContentComment.userIcon}"</#if> >
                        <p id="demoText_userIcon"></p>
                    </div>
                </div>

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">评论时间</label>
        <div class="layui-input-block">
                <input type="text" name="addTime" id="addTime" <#if (wxContentComment.addTime)??>value="${wxContentComment.addTime?string('yyyy-MM-dd')}"</#if>  lay-verify="date" placeholder="请选择评论时间" autocomplete="off" class="layui-input">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">评论内容</label>
        <div class="layui-input-block">
                <div id="content">${wxContentComment.content}</div>

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addWxContentComment">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>
<script type="text/javascript" src="${base}/static/js/wangEditor.min.js"></script>
<script>
    layui.use(['form','jquery','layer','upload','laydate'],function(){
        var form      = layui.form,
                $     = layui.jquery,
                upload = layui.upload,
                laydate = layui.laydate,
                E = window.wangEditor,
                layer = layui.layer;

                        //普通图片上传
        var upload_userIcon = upload.render({
            elem: '#test_userIcon',
            url: '${base}/file/upload/',
            field:'test',
            before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo_userIcon').attr('src', result); //图片链接（base64）
                });
            },
            done: function(res){
                //如果上传失败
                if(res.success == false){
                    return layer.msg('上传失败');
                }
                $("#userIcon").val(res.data.url);
            },
            error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText_userIcon');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    upload_userIcon.upload();
                });
            }
        });
                          //初始赋值

                          laydate.render({
                            elem: '#addTime'
<#if (wxContentComment.addTime)??>
                            ,value: '${wxContentComment.addTime?string("yyyy-MM-dd")}'
</#if>
                          });

                    var content_editor = new E('#content');
                        //图片上传
                    content_editor.customConfig.uploadImgServer = '${base}/file/uploadWang';
                    content_editor.customConfig.uploadFileName = 'test';
                    // 自定义处理粘贴的文本内容(这里处理图片抓取)
                    content_editor.customConfig.pasteTextHandle = function (content) {
                        if(undefined == content){
                            return content;
                        }
                        if(content.indexOf("src=")<=0){
                            return content;
                        }
                        var loadContent = layer.load(2, {
                            shade: [0.3, '#333']
                        });
                        $.ajax({
                            url: "${base}/file/doContent/",
                            type: "POST",
                            async: false,
                            data:{"content":content},
                            dataType: "json",
                            success:function(res){
                                layer.close(loadContent);
                                content = res.data;
                            }
                        });
                        return content;
                    };
                    // 关闭粘贴样式的过滤
                    content_editor.customConfig.pasteFilterStyle = false;
                    content_editor.customConfig.customAlert = function (info) {
                        // info 是需要提示的内容
                        layer.msg(info);
                    };
                    content_editor.create();

        form.on("submit(addWxContentComment)",function(data){
                 if(undefined === data.field.show || '0' === data.field.show || null === data.field.show){
                data.field.show = false;
            }else{
                data.field.show = true;
            }
                                  if(null === data.field.addTime || "" ===data.field.addTime){
                                delete data.field["addTime"];
                            }else{
                                data.field.addTime = new Date(data.field.addTime);
                            }
                   var c = content_editor.txt.html();
                c = c.replace(/\"/g, "'");
                data.field.content = c;
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //给角色赋值
            $.post("${base}/wx/wxContentComment/edit",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("内容-评论编辑成功！",{time:1000},function(){
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