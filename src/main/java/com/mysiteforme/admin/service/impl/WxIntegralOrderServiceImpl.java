package com.mysiteforme.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mysiteforme.admin.dao.WxIntegralOrderDao;
import com.mysiteforme.admin.entity.WxIntegralOrder;
import com.mysiteforme.admin.service.WxIntegralOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 积分商城订单 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WxIntegralOrderServiceImpl extends ServiceImpl<WxIntegralOrderDao, WxIntegralOrder> implements WxIntegralOrderService {

}
