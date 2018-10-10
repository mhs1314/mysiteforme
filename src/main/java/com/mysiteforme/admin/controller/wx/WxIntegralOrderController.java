package com.mysiteforme.admin.controller.wx;

import com.mysiteforme.admin.entity.WxIntegralOrder;
import com.mysiteforme.admin.service.WxIntegralOrderService;
import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mysiteforme.admin.util.LayerData;
import com.mysiteforme.admin.util.RestResponse;
import com.mysiteforme.admin.annotation.SysLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 积分商城订单  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@Controller
@RequestMapping("/wx/wxIntegralOrder")
public class WxIntegralOrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxIntegralOrderController.class);

    @Autowired
    private WxIntegralOrderService wxIntegralOrderService;

    @GetMapping("list")
    @SysLog("跳转积分商城订单列表")
    public String list(){
        return "/wx/wxIntegralOrder/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求积分商城订单列表数据")
    public LayerData<WxIntegralOrder> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                           @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                           ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<WxIntegralOrder> layerData = new LayerData<>();
        EntityWrapper<WxIntegralOrder> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String orderStatus = (String) map.get("orderStatus");
            if(StringUtils.isNotBlank(orderStatus)) {
                wrapper.eq("order_status",orderStatus);
            }else{
                map.remove("orderStatus");
            }

        }
        Page<WxIntegralOrder> pageData = wxIntegralOrderService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增积分商城订单页面")
    public String add(){
        return "/wx/wxIntegralOrder/add";
    }

    @PostMapping("add")
    @SysLog("保存新增积分商城订单数据")
    @ResponseBody
    public RestResponse add(WxIntegralOrder wxIntegralOrder){
        wxIntegralOrderService.insert(wxIntegralOrder);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑积分商城订单页面")
    public String edit(Long id,Model model){
        WxIntegralOrder wxIntegralOrder = wxIntegralOrderService.selectById(id);
        model.addAttribute("wxIntegralOrder",wxIntegralOrder);
        return "/wx/wxIntegralOrder/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑积分商城订单数据")
    public RestResponse edit(WxIntegralOrder wxIntegralOrder){
        if(null == wxIntegralOrder.getId() || 0 == wxIntegralOrder.getId()){
            return RestResponse.failure("ID不能为空");
        }
        wxIntegralOrderService.updateById(wxIntegralOrder);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除积分商城订单数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        WxIntegralOrder wxIntegralOrder = wxIntegralOrderService.selectById(id);
        wxIntegralOrder.setDelFlag(true);
        wxIntegralOrderService.updateById(wxIntegralOrder);
        return RestResponse.success();
    }

}