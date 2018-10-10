package com.mysiteforme.admin.controller.wx;

import com.mysiteforme.admin.entity.WxContentBroadcast;
import com.mysiteforme.admin.service.WxContentBroadcastService;
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
 * 内容-轮播管理  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@Controller
@RequestMapping("/wx/wxContentBroadcast")
public class WxContentBroadcastController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxContentBroadcastController.class);

    @Autowired
    private WxContentBroadcastService wxContentBroadcastService;

    @GetMapping("list")
    @SysLog("跳转内容-轮播管理列表")
    public String list(){
        return "/wx/wxContentBroadcast/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求内容-轮播管理列表数据")
    public LayerData<WxContentBroadcast> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                              @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                              ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<WxContentBroadcast> layerData = new LayerData<>();
        EntityWrapper<WxContentBroadcast> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String titleName = (String) map.get("titleName");
            if(StringUtils.isNotBlank(titleName)) {
                wrapper.like("title_name",titleName);
            }else{
                map.remove("titleName");
            }

            String modle = (String) map.get("modle");
            if(StringUtils.isNotBlank(modle)) {
                wrapper.eq("modle",modle);
            }else{
                map.remove("modle");
            }

        }
        Page<WxContentBroadcast> pageData = wxContentBroadcastService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增内容-轮播管理页面")
    public String add(){
        return "/wx/wxContentBroadcast/add";
    }

    @PostMapping("add")
    @SysLog("保存新增内容-轮播管理数据")
    @ResponseBody
    public RestResponse add(WxContentBroadcast wxContentBroadcast){
        wxContentBroadcastService.insert(wxContentBroadcast);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑内容-轮播管理页面")
    public String edit(Long id,Model model){
        WxContentBroadcast wxContentBroadcast = wxContentBroadcastService.selectById(id);
        model.addAttribute("wxContentBroadcast",wxContentBroadcast);
        return "/wx/wxContentBroadcast/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑内容-轮播管理数据")
    public RestResponse edit(WxContentBroadcast wxContentBroadcast){
        if(null == wxContentBroadcast.getId() || 0 == wxContentBroadcast.getId()){
            return RestResponse.failure("ID不能为空");
        }
        wxContentBroadcastService.updateById(wxContentBroadcast);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除内容-轮播管理数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        WxContentBroadcast wxContentBroadcast = wxContentBroadcastService.selectById(id);
        wxContentBroadcast.setDelFlag(true);
        wxContentBroadcastService.updateById(wxContentBroadcast);
        return RestResponse.success();
    }

}