<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>积分商品编辑--${site.name}</title>
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
    <input value="${wxIntegralGood.id}" name="id" type="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">商品名称</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxIntegralGood.goodName}" name="goodName"  placeholder="请输入商品名称">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">市场价格</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxIntegralGood.marketPrice}" name="marketPrice"  placeholder="请输入市场价格">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">销售价格</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxIntegralGood.salePrice}" name="salePrice"  placeholder="请输入销售价格">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品兑换积分</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxIntegralGood.integralNum}" name="integralNum"  placeholder="请输入商品兑换积分">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">库存</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxIntegralGood.stockNum}" name="stockNum"  placeholder="请输入库存">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">兑换次数</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${wxIntegralGood.exchangeNum}" name="exchangeNum"  placeholder="请输入兑换次数">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">0下架 1上架</label>
        <div class="layui-input-block">
                <input type="checkbox" name="saleStatus"  lay-skin="switch" lay-text="是|否" value="1"  <#if (wxIntegralGood.saleStatus == true)> checked </#if> >

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地址 0不需要 1需要</label>
        <div class="layui-input-block">
                <input type="checkbox" name="needAddress"  lay-skin="switch" lay-text="是|否" value="1"  <#if (wxIntegralGood.needAddress == true)> checked </#if> >

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">缩略图</label>
        <div class="layui-input-block">
                <input type="hidden" class="layui-input" name="thumbnailUrl" id="thumbnailUrl" value="${wxIntegralGood.thumbnailUrl}" >
                <div class="layui-upload">
                    <button type="button" class="layui-btn" id="test_thumbnailUrl">上传缩略图</button>
                    <div class="layui-upload-list">
                        <img class="layui-upload-img" id="demo_thumbnailUrl" <#if (wxIntegralGood.thumbnailUrl??)>src="${wxIntegralGood.thumbnailUrl}"</#if> >
                        <p id="demoText_thumbnailUrl"></p>
                    </div>
                </div>

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品图册，用逗号隔开</label>
        <div class="layui-input-block">
                <input type="hidden" class="layui-input" name="goodImges" id="goodImges" value = "${wxIntegralGood.goodImges}" >
                <div class="layui-upload-drag" id="goodImges">
                  <i class="layui-icon"></i>
                  <p>点击上传，或将文件拖拽到此处</p>
                </div>

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品简介</label>
        <div class="layui-input-block">
                <input type="hidden" class="layui-input" name="googDesc" id="googDesc" value = "${wxIntegralGood.googDesc}" >
                <div class="layui-upload-drag" id="googDesc">
                  <i class="layui-icon"></i>
                  <p>点击上传，或将文件拖拽到此处</p>
                </div>

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">截止时间</label>
        <div class="layui-input-block">
                <input type="hidden" class="layui-input" name="endTime" id="endTime" value = "${wxIntegralGood.endTime}" >
                <div class="layui-upload-drag" id="endTime">
                  <i class="layui-icon"></i>
                  <p>点击上传，或将文件拖拽到此处</p>
                </div>

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品说明</label>
        <div class="layui-input-block">
                <input type="hidden" class="layui-input" name="goodNotes" id="goodNotes" value = "${wxIntegralGood.goodNotes}" >
                <div class="layui-upload-drag" id="goodNotes">
                  <i class="layui-icon"></i>
                  <p>点击上传，或将文件拖拽到此处</p>
                </div>

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品排序</label>
        <div class="layui-input-block">
                <input type="hidden" class="layui-input" name="goodSort" id="goodSort" value = "${wxIntegralGood.goodSort}" >
                <div class="layui-upload-drag" id="goodSort">
                  <i class="layui-icon"></i>
                  <p>点击上传，或将文件拖拽到此处</p>
                </div>

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品类型 0积分 1钱</label>
        <div class="layui-input-block">
                <input type="hidden" class="layui-input" name="goodType" id="goodType" value = "${wxIntegralGood.goodType}" >
                <div class="layui-upload-drag" id="goodType">
                  <i class="layui-icon"></i>
                  <p>点击上传，或将文件拖拽到此处</p>
                </div>

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addWxIntegralGood">立即提交</button>
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
        var upload_thumbnailUrl = upload.render({
            elem: '#test_thumbnailUrl',
            url: '${base}/file/upload/',
            field:'test',
            before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo_thumbnailUrl').attr('src', result); //图片链接（base64）
                });
            },
            done: function(res){
                //如果上传失败
                if(res.success == false){
                    return layer.msg('上传失败');
                }
                $("#thumbnailUrl").val(res.data.url);
            },
            error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText_thumbnailUrl');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    upload_thumbnailUrl.upload();
                });
            }
        });

        form.on("submit(addWxIntegralGood)",function(data){
                 if(undefined === data.field.saleStatus || '0' === data.field.saleStatus || null === data.field.saleStatus){
                data.field.saleStatus = false;
            }else{
                data.field.saleStatus = true;
            }
                 if(undefined === data.field.needAddress || '0' === data.field.needAddress || null === data.field.needAddress){
                data.field.needAddress = false;
            }else{
                data.field.needAddress = true;
            }
               var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //给角色赋值
            $.post("${base}/wx/wxIntegralGood/edit",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("积分商品编辑成功！",{time:1000},function(){
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