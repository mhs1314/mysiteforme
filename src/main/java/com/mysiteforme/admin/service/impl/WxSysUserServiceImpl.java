package com.mysiteforme.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mysiteforme.admin.dao.WxSysUserDao;
import com.mysiteforme.admin.entity.WxSysUser;
import com.mysiteforme.admin.service.WxSysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WxSysUserServiceImpl extends ServiceImpl<WxSysUserDao, WxSysUser> implements WxSysUserService {

}
