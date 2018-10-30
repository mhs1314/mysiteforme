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
        <label class="layui-form-label">订单状态 0待支付 1取消 2已支付 3待发货 4已发货 5已收货</label>
        <div class="layui-input-block">

            <select name="orderStatus" >
                <option value="" selected="">请选择订单状态 0待支付 1取消 2已支付 3待发货 4已发货 5已收货</option>
                <@my type="wx_integral_order_order_status">
                <#list result as r>
                <option value="${r.value}" >${r.label}</option>
                </#list>
                </@my>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地址</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="address"  placeholder="请输入地址">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="name"  placeholder="请输入姓名">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="phone"  placeholder="请输入电话">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮编</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="code"  placeholder="请输入邮编">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品图片(逗号分隔)</label>
        <div class="layui-input-block">

            <input type="hidden" class="layui-input" name="goodImgs" id="goodImgs" >
            <div class="layui-upload">
                <button type="button" class="layui-btn" id="test_goodImgs">上传商品图片(逗号分隔)</button>
                <div class="layui-upload-list">
                    <img class="layui-upload-img" id="demo_goodImgs">
                    <p id="demoText_goodImgs"></p>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品名称</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="goodName"  placeholder="请输入商品名称">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品价格</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="goodPrice"  placeholder="请输入商品价格">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品类型 0积分 1钱</label>
        <div class="layui-input-block">

            <select name="goodType" >
                <option value="" selected="">请选择商品类型 0积分 1钱</option>
                <@my type="wx_integral_order_good_type">
                <#list result as r>
                <option value="${r.value}" >${r.label}</option>
                </#list>
                </@my>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">积分商品-积分个数</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="goodSocerNum"  placeholder="请输入积分商品-积分个数">
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
    layui.use(['form','jquery','layer','upload','laydate'],function(){
        var form      = layui.form,
                $     = layui.jquery,
                upload = layui.upload,
                laydate = layui.laydate,
                layer = layui.layer;

                          //初始赋值
                          laydate.render({
                            elem: '#orderTime'
                          });
                        //普通图片上传
        var upload_goodImgs = upload.render({
            elem: '#test_goodImgs',
            url: '${base}/file/upload/',
            field:'test',
            before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo_goodImgs').attr('src', result); //图片链接（base64）
                });
            },
            done: function(res){
                //如果上传失败
                if(res.success == false){
                    return layer.msg('上传失败');
                }
                $("#goodImgs").val(res.data.url);
            },
            error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText_goodImgs');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    upload_goodImgs.upload();
                });
            }
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