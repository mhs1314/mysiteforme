package com.mysiteforme.admin.controller.wx;

import com.mysiteforme.admin.entity.WxSysUser;
import com.mysiteforme.admin.service.WxSysUserService;
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
 * 用户表  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@Controller
@RequestMapping("/wx/wxSysUser")
public class WxSysUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxSysUserController.class);

    @Autowired
    private WxSysUserService wxSysUserService;

    @GetMapping("list")
    @SysLog("跳转用户表列表")
    public String list(){
        return "/wx/wxSysUser/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求用户表列表数据")
    public LayerData<WxSysUser> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                     @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                     ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<WxSysUser> layerData = new LayerData<>();
        EntityWrapper<WxSysUser> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String userName = (String) map.get("userName");
            if(StringUtils.isNotBlank(userName)) {
                wrapper.like("user_name",userName);
            }else{
                map.remove("userName");
            }

        }
        Page<WxSysUser> pageData = wxSysUserService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增用户表页面")
    public String add(){
        return "/wx/wxSysUser/add";
    }

    @PostMapping("add")
    @SysLog("保存新增用户表数据")
    @ResponseBody
    public RestResponse add(WxSysUser wxSysUser){
        wxSysUserService.insert(wxSysUser);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑用户表页面")
    public String edit(Long id,Model model){
        WxSysUser wxSysUser = wxSysUserService.selectById(id);
        model.addAttribute("wxSysUser",wxSysUser);
        return "/wx/wxSysUser/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑用户表数据")
    public RestResponse edit(WxSysUser wxSysUser){
        if(null == wxSysUser.getId() || 0 == wxSysUser.getId()){
            return RestResponse.failure("ID不能为空");
        }
        wxSysUserService.updateById(wxSysUser);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除用户表数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        WxSysUser wxSysUser = wxSysUserService.selectById(id);
        wxSysUser.setDelFlag(true);
        wxSysUserService.updateById(wxSysUser);
        return RestResponse.success();
    }

}