package com.mysiteforme.admin.controller.wx;

import com.mysiteforme.admin.entity.WxContentType;
import com.mysiteforme.admin.service.WxContentTypeService;
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
 * 内容-分类  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2018-10-11
 */
@Controller
@RequestMapping("/wx/wxContentType")
public class WxContentTypeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxContentTypeController.class);

    @Autowired
    private WxContentTypeService wxContentTypeService;

    @GetMapping("list")
    @SysLog("跳转内容-分类列表")
    public String list(){
        return "/wx/wxContentType/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求内容-分类列表数据")
    public LayerData<WxContentType> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                         @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                         ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<WxContentType> layerData = new LayerData<>();
        EntityWrapper<WxContentType> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String name = (String) map.get("name");
            if(StringUtils.isNotBlank(name)) {
                wrapper.like("name",name);
            }else{
                map.remove("name");
            }

            String isShow = (String) map.get("isShow");
            if(StringUtils.isNotBlank(isShow)) {
                if(isShow.equalsIgnoreCase("true")){
                    wrapper.eq("is_show",true);
                }else if(isShow.equalsIgnoreCase("false")){
                    wrapper.eq("is_show",false);
                }else{
                    map.remove("isShow");
                }
            }else{
                map.remove("isShow");
            }

            String modle = (String) map.get("modle");
            if(StringUtils.isNotBlank(modle)) {
                wrapper.eq("modle",modle);
            }else{
                map.remove("modle");
            }

        }
        Page<WxContentType> pageData = wxContentTypeService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增内容-分类页面")
    public String add(){
        return "/wx/wxContentType/add";
    }

    @PostMapping("add")
    @SysLog("保存新增内容-分类数据")
    @ResponseBody
    public RestResponse add(WxContentType wxContentType){
        wxContentTypeService.insert(wxContentType);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑内容-分类页面")
    public String edit(Long id,Model model){
        WxContentType wxContentType = wxContentTypeService.selectById(id);
        model.addAttribute("wxContentType",wxContentType);
        return "/wx/wxContentType/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑内容-分类数据")
    public RestResponse edit(WxContentType wxContentType){
        if(null == wxContentType.getId() || 0 == wxContentType.getId()){
            return RestResponse.failure("ID不能为空");
        }
        wxContentTypeService.updateById(wxContentType);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除内容-分类数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        WxContentType wxContentType = wxContentTypeService.selectById(id);
        wxContentType.setDelFlag(true);
        wxContentTypeService.updateById(wxContentType);
        return RestResponse.success();
    }

}