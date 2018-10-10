package com.mysiteforme.admin.controller.wx;

import com.mysiteforme.admin.entity.WxContentBroadcastConfig;
import com.mysiteforme.admin.service.WxContentBroadcastConfigService;
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
 * 内容-轮播配置  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@Controller
@RequestMapping("/wx/wxContentBroadcastConfig")
public class WxContentBroadcastConfigController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxContentBroadcastConfigController.class);

    @Autowired
    private WxContentBroadcastConfigService wxContentBroadcastConfigService;

    @GetMapping("list")
    @SysLog("跳转内容-轮播配置列表")
    public String list(){
        return "/wx/wxContentBroadcastConfig/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求内容-轮播配置列表数据")
    public LayerData<WxContentBroadcastConfig> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                                    @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                                    ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<WxContentBroadcastConfig> layerData = new LayerData<>();
        EntityWrapper<WxContentBroadcastConfig> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
        }
        Page<WxContentBroadcastConfig> pageData = wxContentBroadcastConfigService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增内容-轮播配置页面")
    public String add(){
        return "/wx/wxContentBroadcastConfig/add";
    }

    @PostMapping("add")
    @SysLog("保存新增内容-轮播配置数据")
    @ResponseBody
    public RestResponse add(WxContentBroadcastConfig wxContentBroadcastConfig){
        wxContentBroadcastConfigService.insert(wxContentBroadcastConfig);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑内容-轮播配置页面")
    public String edit(Long id,Model model){
        WxContentBroadcastConfig wxContentBroadcastConfig = wxContentBroadcastConfigService.selectById(id);
        model.addAttribute("wxContentBroadcastConfig",wxContentBroadcastConfig);
        return "/wx/wxContentBroadcastConfig/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑内容-轮播配置数据")
    public RestResponse edit(WxContentBroadcastConfig wxContentBroadcastConfig){
        if(null == wxContentBroadcastConfig.getId() || 0 == wxContentBroadcastConfig.getId()){
            return RestResponse.failure("ID不能为空");
        }
        wxContentBroadcastConfigService.updateById(wxContentBroadcastConfig);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除内容-轮播配置数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        WxContentBroadcastConfig wxContentBroadcastConfig = wxContentBroadcastConfigService.selectById(id);
        wxContentBroadcastConfig.setDelFlag(true);
        wxContentBroadcastConfigService.updateById(wxContentBroadcastConfig);
        return RestResponse.success();
    }

}