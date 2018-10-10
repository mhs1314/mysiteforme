package com.mysiteforme.admin.controller.wx;

import com.mysiteforme.admin.entity.WxContentComment;
import com.mysiteforme.admin.service.WxContentCommentService;
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
 * 内容-评论  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@Controller
@RequestMapping("/wx/wxContentComment")
public class WxContentCommentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxContentCommentController.class);

    @Autowired
    private WxContentCommentService wxContentCommentService;

    @GetMapping("list")
    @SysLog("跳转内容-评论列表")
    public String list(){
        return "/wx/wxContentComment/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求内容-评论列表数据")
    public LayerData<WxContentComment> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                            @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                            ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<WxContentComment> layerData = new LayerData<>();
        EntityWrapper<WxContentComment> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String userName = (String) map.get("userName");
            if(StringUtils.isNotBlank(userName)) {
                wrapper.like("user_name",userName);
            }else{
                map.remove("userName");
            }

            String beginAddTime = (String) map.get("beginAddTime");
            String endAddTime = (String) map.get("endAddTime");
            if(StringUtils.isNotBlank(beginAddTime)) {
                Date begin = DateUtil.parse(beginAddTime);
                wrapper.ge("add_time",begin);
            }else{
                map.remove("beginAddTime");
            }
            if(StringUtils.isNotBlank(endAddTime)) {
                Date end = DateUtil.parse(endAddTime);
                wrapper.le("add_time",end);
            }else{
                map.remove("endAddTime");
            }

        }
        Page<WxContentComment> pageData = wxContentCommentService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("add")
    @SysLog("跳转新增内容-评论页面")
    public String add(){
        return "/wx/wxContentComment/add";
    }

    @PostMapping("add")
    @SysLog("保存新增内容-评论数据")
    @ResponseBody
    public RestResponse add(WxContentComment wxContentComment){
        wxContentCommentService.insert(wxContentComment);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑内容-评论页面")
    public String edit(Long id,Model model){
        WxContentComment wxContentComment = wxContentCommentService.selectById(id);
        model.addAttribute("wxContentComment",wxContentComment);
        return "/wx/wxContentComment/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑内容-评论数据")
    public RestResponse edit(WxContentComment wxContentComment){
        if(null == wxContentComment.getId() || 0 == wxContentComment.getId()){
            return RestResponse.failure("ID不能为空");
        }
        wxContentCommentService.updateById(wxContentComment);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除内容-评论数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        WxContentComment wxContentComment = wxContentCommentService.selectById(id);
        wxContentComment.setDelFlag(true);
        wxContentCommentService.updateById(wxContentComment);
        return RestResponse.success();
    }

}