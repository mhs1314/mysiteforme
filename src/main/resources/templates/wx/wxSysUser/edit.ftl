<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户表编辑--${site.name}</title>
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
    <input value="${wxSysUser.id}" name="id" type="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">用户姓名</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxSysUser.userName}" name="userName"  placeholder="请输入用户姓名">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户头像</label>
        <div class="layui-input-block">
                <input type="hidden" class="layui-input" name="icon" id="icon" value="${wxSysUser.icon}" >
                <div class="layui-upload">
                    <button type="button" class="layui-btn" id="test_icon">上传用户头像</button>
                    <div class="layui-upload-list">
                        <img class="layui-upload-img" id="demo_icon" <#if (wxSysUser.icon??)>src="${wxSysUser.icon}"</#if> >
                        <p id="demoText_icon"></p>
                    </div>
                </div>

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">微信唯一标识</label>
        <div class="layui-input-block">
                <input type="hidden" class="layui-input" name="openId" id="openId" value = "${wxSysUser.openId}" >
                <div class="layui-upload-drag" id="openId">
                  <i class="layui-icon"></i>
                  <p>点击上传，或将文件拖拽到此处</p>
                </div>

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">积分</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxSysUser.socer}" name="socer"  placeholder="请输入积分">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">最后登录时间</label>
        <div class="layui-input-block">
                <input type="text" name="lastLoginTime" id="lastLoginTime" <#if (wxSysUser.lastLoginTime)??>value="${wxSysUser.lastLoginTime?string('yyyy-MM-dd')}"</#if>  lay-verify="date" placeholder="请选择最后登录时间" autocomplete="off" class="layui-input">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">登录次数</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxSysUser.loginNum}" name="loginNum"  placeholder="请输入登录次数">

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addWxSysUser">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>
<script>
    layui.use(['form','jquery','layer','upload','laydate'],function(){
        var form      = layui.form,
                $     = layui.jquery,
                upload = layui.upload,
                layer = layui.layer;

                        //普通图片上传
        var upload_icon = upload.render({
            elem: '#test_icon',
            url: '${base}/file/upload/',
            field:'test',
            before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo_icon').attr('src', result); //图片链接（base64）
                });
            },
            done: function(res){
                //如果上传失败
                if(res.success == false){
                    return layer.msg('上传失败');
                }
                $("#icon").val(res.data.url);
            },
            error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText_icon');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    upload_icon.upload();
                });
            }
        });
                          //初始赋值

                          laydate.render({
                            elem: '#lastLoginTime'
<#if (wxSysUser.lastLoginTime)??>
                            ,value: '${wxSysUser.lastLoginTime?string("yyyy-MM-dd")}'
</#if>
                          });


        form.on("submit(addWxSysUser)",function(data){
                                  if(null === data.field.lastLoginTime || "" ===data.field.lastLoginTime){
                                delete data.field["lastLoginTime"];
                            }else{
                                data.field.lastLoginTime = new Date(data.field.lastLoginTime);
                            }
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //给角色赋值
            $.post("${base}/wx/wxSysUser/edit",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("用户表编辑成功！",{time:1000},function(){
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