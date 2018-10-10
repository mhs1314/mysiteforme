package com.mysiteforme.admin.controller.wx;

import com.mysiteforme.admin.entity.WxSysCount;
import com.mysiteforme.admin.service.WxSysCountService;
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
 * 统计表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@Controller
@RequestMapping("/wx/wxSysCount")
public class WxSysCountController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxSysCountController.class);

    @Autowired
    private WxSysCountService wxSysCountService;

    @GetMapping("list")
    @SysLog("跳转统计表列表")
    public String list(){
        return "/wx/wxSysCount/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求统计表列表数据")
    public LayerData<WxSysCount> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                      ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<WxSysCount> layerData = new LayerData<>();
        EntityWrapper<WxSysCount> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
        }
        Page<WxSysCount> pageData = wxSysCountService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增统计表页面")
    public String add(){
        return "/wx/wxSysCount/add";
    }

    @PostMapping("add")
    @SysLog("保存新增统计表数据")
    @ResponseBody
    public RestResponse add(WxSysCount wxSysCount){
        wxSysCountService.insert(wxSysCount);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑统计表页面")
    public String edit(Long id,Model model){
        WxSysCount wxSysCount = wxSysCountService.selectById(id);
        model.addAttribute("wxSysCount",wxSysCount);
        return "/wx/wxSysCount/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑统计表数据")
    public RestResponse edit(WxSysCount wxSysCount){
        if(null == wxSysCount.getId() || 0 == wxSysCount.getId()){
            return RestResponse.failure("ID不能为空");
        }
        wxSysCountService.updateById(wxSysCount);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除统计表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        WxSysCount wxSysCount = wxSysCountService.selectById(id);
        wxSysCount.setDelFlag(true);
        wxSysCountService.updateById(wxSysCount);
        return RestResponse.success();
    }

}