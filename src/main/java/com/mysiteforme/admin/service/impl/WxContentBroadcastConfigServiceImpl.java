package com.mysiteforme.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mysiteforme.admin.dao.WxContentBroadcastConfigDao;
import com.mysiteforme.admin.entity.WxContentBroadcastConfig;
import com.mysiteforme.admin.service.WxContentBroadcastConfigService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 内容-轮播配置 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WxContentBroadcastConfigServiceImpl extends ServiceImpl<WxContentBroadcastConfigDao, WxContentBroadcastConfig> implements WxContentBroadcastConfigService {

}
