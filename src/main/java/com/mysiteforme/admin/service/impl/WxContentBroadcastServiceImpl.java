package com.mysiteforme.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mysiteforme.admin.dao.WxContentBroadcastDao;
import com.mysiteforme.admin.entity.WxContentBroadcast;
import com.mysiteforme.admin.service.WxContentBroadcastService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 内容-轮播管理 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WxContentBroadcastServiceImpl extends ServiceImpl<WxContentBroadcastDao, WxContentBroadcast> implements WxContentBroadcastService {

}
