package com.mysiteforme.admin.controller.wx;

import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mysiteforme.admin.entity.Wx_content_config;
import com.mysiteforme.admin.service.Wx_content_configService;
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
 * 内容-基本配置  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2018-10-08
 */
@Controller
@RequestMapping("/wx/wx_content_config")
public class Wx_content_configController {
    private static final Logger LOGGER = LoggerFactory.getLogger(Wx_content_configController.class);

    @Autowired
    private Wx_content_configService wx_content_configService;

    @GetMapping("list")
    @SysLog("跳转内容-基本配置列表")
    public String list(){
        return "/wx/wx_content_config/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求内容-基本配置列表数据")
    public LayerData<Wx_content_config> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<Wx_content_config> layerData = new LayerData<>();
        EntityWrapper<Wx_content_config> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
        }
        Page<Wx_content_config> pageData = wx_content_configService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增内容-基本配置页面")
    public String add(){
        return "/wx/wx_content_config/add";
    }

    @PostMapping("add")
    @SysLog("保存新增内容-基本配置数据")
    @ResponseBody
    public RestResponse add(Wx_content_config wx_content_config){
        wx_content_configService.insert(wx_content_config);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑内容-基本配置页面")
    public String edit(Long id,Model model){
        Wx_content_config wx_content_config = wx_content_configService.selectById(id);
        model.addAttribute("wx_content_config",wx_content_config);
        return "/wx/wx_content_config/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑内容-基本配置数据")
    public RestResponse edit(Wx_content_config wx_content_config){
        if(null == wx_content_config.getId() || 0 == wx_content_config.getId()){
            return RestResponse.failure("ID不能为空");
        }
        wx_content_configService.updateById(wx_content_config);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除内容-基本配置数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        Wx_content_config wx_content_config = wx_content_configService.selectById(id);
        wx_content_config.setDelFlag(true);
        wx_content_configService.updateById(wx_content_config);
        return RestResponse.success();
    }

}