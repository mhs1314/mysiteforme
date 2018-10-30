package com.mysiteforme.admin.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mysiteforme.admin.dao.WxIntegralCodeDao;
import com.mysiteforme.admin.entity.WxIntegralCode;
import com.mysiteforme.admin.service.WxIntegralCodeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 积分码生成记录 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2018-10-30
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WxIntegralCodeServiceImpl extends ServiceImpl<WxIntegralCodeDao, WxIntegralCode> implements WxIntegralCodeService {

}
