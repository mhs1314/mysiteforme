package com.mysiteforme.admin.controller.wx;

import com.mysiteforme.admin.entity.WxIntegralCode;
import com.mysiteforme.admin.service.WxIntegralCodeService;
import com.mysiteforme.admin.util.Redeem;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 积分码生成记录  前端控制器
 * </p>
 *
 * @author wangl
 * @since 2018-10-30
 */
@Controller
@RequestMapping("/wx/wxIntegralCode")
public class WxIntegralCodeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WxIntegralCodeController.class);

    @Autowired
    private WxIntegralCodeService wxIntegralCodeService;

    @GetMapping("list")
    @SysLog("跳转积分码生成记录列表")
    public String list(){
        return "/wx/wxIntegralCode/list";
    }

    @PostMapping("list")
    @ResponseBody
    @SysLog("请求积分码生成记录列表数据")
    public LayerData<WxIntegralCode> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                          @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                          ServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<WxIntegralCode> layerData = new LayerData<>();
        EntityWrapper<WxIntegralCode> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        if(!map.isEmpty()){
            String isUsed = (String) map.get("isUsed");
            if(StringUtils.isNotBlank(isUsed)) {
                wrapper.eq("is_used",isUsed);
            }else{
                map.remove("isUsed");
            }

        }
        Page<WxIntegralCode> pageData = wxIntegralCodeService.selectPage(new Page<>(page,limit),wrapper);
        layerData.setData(pageData.getRecords());
        layerData.setCount(pageData.getTotal());
        return layerData;
    }

    @GetMapping("getCodes")
    @SysLog("跳转新增积分码生成记录页面")
    public String getCodes(Model model,Integer num){
        List<WxIntegralCode> integral_codes=new LinkedList<>();
        LinkedList<String> codes = Redeem.create((byte) 1, num, 12, Redeem.password);
        for (String code : codes) {
            WxIntegralCode integralCode=new WxIntegralCode();
            integralCode.setCode(code);
            integralCode.setIntegralNum(num);
            integralCode.setIsUsed(0);
            integral_codes.add(integralCode);
        }
        model.addAttribute("codes",codes);
        return "/wx/wxIntegralCode/getCodes";
    }

    @PostMapping("add")
    @SysLog("保存新增积分码生成记录数据")
    @ResponseBody
    public RestResponse add(WxIntegralCode wxIntegralCode){
        wxIntegralCodeService.insert(wxIntegralCode);
        return RestResponse.success();
    }

    @GetMapping("edit")
    @SysLog("跳转编辑积分码生成记录页面")
    public String edit(Long id,Model model){
        WxIntegralCode wxIntegralCode = wxIntegralCodeService.selectById(id);
        model.addAttribute("wxIntegralCode",wxIntegralCode);
        return "/wx/wxIntegralCode/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存编辑积分码生成记录数据")
    public RestResponse edit(WxIntegralCode wxIntegralCode){
        if(null == wxIntegralCode.getId() || 0 == wxIntegralCode.getId()){
            return RestResponse.failure("ID不能为空");
        }
        wxIntegralCodeService.updateById(wxIntegralCode);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除积分码生成记录数据")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(null == id || 0 == id){
            return RestResponse.failure("ID不能为空");
        }
        WxIntegralCode wxIntegralCode = wxIntegralCodeService.selectById(id);
        wxIntegralCode.setDelFlag(true);
        wxIntegralCodeService.updateById(wxIntegralCode);
        return RestResponse.success();
    }

}