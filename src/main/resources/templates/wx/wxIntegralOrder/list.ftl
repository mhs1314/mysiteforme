<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>积分商城订单--${site.name}</title>
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
    <link rel="stylesheet" href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all" />
    <link rel="stylesheet" href="${base}/static/css/user.css" media="all" />
</head>
<body class="childrenBody">
<fieldset class="layui-elem-field">
  <legend>积分商城订单检索</legend>
  <div class="layui-field-box">
    <form class="layui-form" id="searchForm">
    <div class="layui-inline" style="margin-left: 15px">
            <label>订单状态 0待支付 1取消 2已支付 3待发货 4已发货 5已收货:</label>
                <div class="layui-input-inline">
                <select name="s_orderStatus">
                    <option value="" selected="">请选择订单状态 0待支付 1取消 2已支付 3待发货 4已发货 5已收货</option>
                    <@my type="wx_integral_order_order_status">
                    <#list result as r>
                    <option value="${r.value}" >${r.label}</option>
                    </#list>
                    </@my>
                </select>
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>姓名:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_name" placeholder="请输入姓名" class="layui-input search_input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>电话:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_phone" placeholder="请输入电话" class="layui-input search_input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>商品名称:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_goodName" placeholder="请输入商品名称" class="layui-input search_input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>商品类型 0积分 1钱:</label>
                <div class="layui-input-inline">
                <select name="s_goodType">
                    <option value="" selected="">请选择商品类型 0积分 1钱</option>
                    <@my type="wx_integral_order_good_type">
                    <#list result as r>
                    <option value="${r.value}" >${r.label}</option>
                    </#list>
                    </@my>
                </select>
                </div>
    </div>
        <div class="layui-inline">
            <a class="layui-btn" lay-submit="" lay-filter="searchForm">查询</a>
        </div>
        <div class="layui-inline" >
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
        <div class="layui-inline">
            <a class="layui-btn layui-btn-normal" data-type="addWxIntegralOrder">添加积分商城订单</a>
        </div>
    </form>
  </div>
</fieldset>
<div class="layui-form users_list">
    <table class="layui-table" id="test" lay-filter="demo"></table>
    <script type="text/html" id="orderStatus">
        <@my type="wx_integral_order_order_status">
        <#list result as r>
        {{#  if(d.orderStatus == ${r.value}){ }}
        <span>${r.label}</span>
        {{#  } }}
        </#list>
        </@my>
    </script>
    <script type="text/html" id="goodImgs">
    {{#  if(d.goodImgs != "" && d.goodImgs != null){ }}
    <span id="goodImgs_{{d.id}}" ><img lay-event="imagegoodImgs" layer-pid="{{d.id}}" layer-src="{{d.goodImgs}}" src="{{d.goodImgs}}" style="width: 40px;"/></span>
    {{#  } else { }}
    <span ></span>
    {{#  } }}
    </script>
    <script type="text/html" id="goodType">
        <@my type="wx_integral_order_good_type">
        <#list result as r>
        {{#  if(d.goodType == ${r.value}){ }}
        <span>${r.label}</span>
        {{#  } }}
        </#list>
        </@my>
    </script>
    <script type="text/html" id="userStatus">
        <!-- 这里的 checked 的状态只是演示 -->
        {{#  if(d.delFlag == false){ }}
        <span class="layui-badge layui-bg-green">正常</span>
        {{#  } else { }}
        <span class="layui-badge layui-bg-gray">停用</span>
        {{#  } }}
    </script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
</div>
<div id="page"></div>
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>
<script type="text/javascript" src="${base}/static/js/tools.js"></script>
<script>
    layui.use(['layer','form','table','laydate'], function() {
        var layer = layui.layer,
                $ = layui.jquery,
                form = layui.form,
                laydate = layui.laydate,
                table = layui.table;


        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'edit'){
                var editIndex = layer.open({
                    title : "编辑积分商城订单",
                    type : 2,
                    content : "${base}/wx/wxIntegralOrder/edit?id="+data.id,
                    success : function(layero, index){
                        setTimeout(function(){
                            layer.tips('点击此处返回积分商城订单列表', '.layui-layer-setwin .layui-layer-close', {
                                tips: 3
                            });
                        },500);
                    }
                });
                //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
                $(window).resize(function(){
                    layer.full(editIndex);
                });
                layer.full(editIndex);
            }
            if(obj.event === "del"){
                layer.confirm("你确定要删除该积分商城订单么？",{btn:['是的,我确定','我再想想']},
                        function(){
                            $.post("${base}/wx/wxIntegralOrder/delete",{"id":data.id},function (res){
                                if(res.success){
                                    layer.msg("删除成功",{time: 1000},function(){
                                        location.reload();
                                    });
                                }else{
                                    layer.msg(res.message);
                                }

                            });
                        }
                )
            }
            if(obj.event == "imagegoodImgs"){
                layer.photos({
                    photos: '#goodImgs_'+data.id,
                    anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
                });
            }
        });

        var t = {
            elem: '#test',
            url:'${base}/wx/wxIntegralOrder/list',
            method:'post',
            page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                groups: 2, //只显示 1 个连续页码
                first: "首页", //显示首页
                last: "尾页", //显示尾页
                limits:[3,10, 20, 30]
            },
            cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            cols: [[
                {type:'checkbox'},
                {field:'orderNum', title: '订单号'},
                {field:'openId', title: '购买用户id'},
                {field:'goodId', title: '积分商品id'},
                {field:'orderTime',  title: '订单时间',templet:'<div>{{ layui.laytpl.toDateString(d.orderTime,"yyyy-MM-dd") }}</div>',unresize: true},
                {field:'orderStatus', title: '订单状态 0待支付 1取消 2已支付 3待发货 4已发货 5已收货',templet:'#orderStatus'},
                {field:'address', title: '地址'},
                {field:'name', title: '姓名'},
                {field:'phone', title: '电话'},
                {field:'code', title: '邮编'},
                {field:'goodImgs', title: '商品图片(逗号分隔)',templet:'#goodImgs'},
                {field:'goodName', title: '商品名称'},
                {field:'goodPrice', title: '商品价格'},
                {field:'goodType', title: '商品类型 0积分 1钱',templet:'#goodType'},
                {field:'goodSocerNum', title: '积分商品-积分个数'},
                {field:'delFlag',    title: '积分商城订单状态',width:'12%',templet:'#userStatus'},
                {field:'createDate',  title: '创建时间',width:'15%',templet:'<div>{{ layui.laytpl.toDateString(d.createDate) }}</div>',unresize: true}, //单元格内容水平居中
                {fixed: 'right', title:'操作',  width: '15%', align: 'center',toolbar: '#barDemo'}
            ]]
        };
        table.render(t);

        var active={
            addWxIntegralOrder : function(){
                var addIndex = layer.open({
                    title : "添加积分商城订单",
                    type : 2,
                    content : "${base}/wx/wxIntegralOrder/add",
                    success : function(layero, addIndex){
                        setTimeout(function(){
                            layer.tips('点击此处返回积分商城订单列表', '.layui-layer-setwin .layui-layer-close', {
                                tips: 3
                            });
                        },500);
                    }
                });
                //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
                $(window).resize(function(){
                    layer.full(addIndex);
                });
                layer.full(addIndex);
            }
        };

        $('.layui-inline .layui-btn-normal').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        form.on("submit(searchForm)",function(data){
            t.where = data.field;
            table.reload('test', t);
            return false;
        });

    });
</script>
</body>
</html>