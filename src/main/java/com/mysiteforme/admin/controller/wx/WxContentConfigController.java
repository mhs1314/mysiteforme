package com.mysiteforme.admin.controller.wx;

import com.mysiteforme.admin.entity.WxContentConfig;
import com.mysiteforme.admin.service.WxContentConfigService;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.Map;

/**
 * <p>
 * 内容-基本配置  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2018-10-09
 */
@Controller
@RequestMapping("/wx/wxContentConfig")
public class WxContentConfigController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxContentConfigController.class);

    @Autowired
    private WxContentConfigService wxContentConfigService;

    @GetMapping("list")
    @SysLog("跳转内容-基本配置列表")
    public String list(){
        return "/wx/wxContentConfig/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求内容-基本配置列表数据")
    public LayerData<WxContentConfig> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                           @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                           ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<WxContentConfig> layerData = new LayerData<>();
        EntityWrapper<WxContentConfig> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
        }
        Page<WxContentConfig> pageData = wxContentConfigService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增内容-基本配置页面")
    public String add(){
        return "/wx/wxContentConfig/add";
    }

    @PostMapping("add")
    @SysLog("保存新增内容-基本配置数据")
    @ResponseBody
    public RestResponse add(WxContentConfig wxContentConfig){
        wxContentConfigService.insert(wxContentConfig);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑内容-基本配置页面")
    public String edit(Long id,Model model){
        WxContentConfig wxContentConfig = wxContentConfigService.selectById(id);
        model.addAttribute("wxContentConfig",wxContentConfig);
        return "/wx/wxContentConfig/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑内容-基本配置数据")
    public RestResponse edit(WxContentConfig wxContentConfig){
        if(null == wxContentConfig.getId() || 0 == wxContentConfig.getId()){
            return RestResponse.failure("ID不能为空");
        }
        wxContentConfigService.updateById(wxContentConfig);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除内容-基本配置数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        WxContentConfig wxContentConfig = wxContentConfigService.selectById(id);
        wxContentConfig.setDelFlag(true);
        wxContentConfigService.updateById(wxContentConfig);
        return RestResponse.success();
    }

}