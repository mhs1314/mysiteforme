package com.mysiteforme.admin.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mysiteforme.admin.dao.WxContentConfigDao;
import com.mysiteforme.admin.entity.WxContentConfig;
import com.mysiteforme.admin.service.WxContentConfigService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 内容-基本配置 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2018-10-09
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WxContentConfigServiceImpl extends ServiceImpl<WxContentConfigDao, WxContentConfig> implements WxContentConfigService {

}
