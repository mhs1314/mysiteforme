package com.mysiteforme.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mysiteforme.admin.dao.WxSysCountDao;
import com.mysiteforme.admin.entity.WxSysCount;
import com.mysiteforme.admin.service.WxSysCountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 统计表 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WxSysCountServiceImpl extends ServiceImpl<WxSysCountDao, WxSysCount> implements WxSysCountService {

}
