<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>积分码生成记录编辑--${site.name}</title>
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
    <input value="${wxIntegralCode.id}" name="id" type="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">积分兑换码</label>
        <div class="layui-input-block">
                <textarea name="code"   placeholder="请输入积分兑换码" class="layui-textarea">${wxIntegralCode.code}</textarea>

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">积分</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxIntegralCode.integralNum}" name="integralNum"  placeholder="请输入积分">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">使用过 0未使用 1使用过</label>
        <div class="layui-input-block">
                <select name="isUsed" >
                    <option value="" selected="">请选择使用过 0未使用 1使用过</option>
                    <@my type="wx_integral_code_is_used">
                    <#list result as r>
                    <option value="${r.value}"  <#if (wxIntegralCode.isUsed == r.value)> selected="" </#if>  >${r.label}</option>
                    </#list>
                    </@my>
                </select>

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">使用人</label>
        <div class="layui-input-block">
                <textarea name="openId"   placeholder="请输入使用人" class="layui-textarea">${wxIntegralCode.openId}</textarea>

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addWxIntegralCode">立即提交</button>
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


        form.on("submit(addWxIntegralCode)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //给角色赋值
            $.post("${base}/wx/wxIntegralCode/edit",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("积分码生成记录编辑成功！",{time:1000},function(){
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