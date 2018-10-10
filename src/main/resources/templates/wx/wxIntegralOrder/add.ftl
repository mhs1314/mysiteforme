<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>积分商城订单添加--${site.name}</title>
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
    <div class="layui-form-item">
        <label class="layui-form-label">订单号</label>
        <div class="layui-input-block">

            <textarea name="orderNum"  placeholder="请输入订单号" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">购买用户id</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="openId"  placeholder="请输入购买用户id">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">积分商品id</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="goodId"  placeholder="请输入积分商品id">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">订单时间</label>
        <div class="layui-input-block">

            <input type="text" name="orderTime" id="orderTime"   lay-verify="date" placeholder="请选择订单时间" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">订单状态 0待支付 1取消 2已支付</label>
        <div class="layui-input-block">

            <select name="orderStatus" >
                <option value="" selected="">请选择订单状态 0待支付 1取消 2已支付</option>
                <@my type="wx_integral_order_order_status">
                <#list result as r>
                <option value="${r.value}" >${r.label}</option>
                </#list>
                </@my>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addWxIntegralOrder">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>
<script>
    layui.use(['form','jquery','layer','laydate'],function(){
        var form      = layui.form,
                $     = layui.jquery,
                laydate = layui.laydate,
                layer = layui.layer;

                          //初始赋值
                          laydate.render({
                            elem: '#orderTime'
                          });

        form.on("submit(addWxIntegralOrder)",function(data){
                       if(null === data.field.orderTime || "" ===data.field.orderTime){
                        delete data.field["orderTime"];
                    }else{
                        data.field.orderTime = new Date(data.field.orderTime);
                    }

            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            $.post("${base}/wx/wxIntegralOrder/add",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("积分商城订单添加成功！",{time:1000},function(){
                        parent.layer.close(parent.addIndex);
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