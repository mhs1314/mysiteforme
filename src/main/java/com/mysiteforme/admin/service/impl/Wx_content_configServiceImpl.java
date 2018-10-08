package com.mysiteforme.admin.service.impl;

import com.mysiteforme.admin.entity.Wx_content_config;
import com.mysiteforme.admin.dao.Wx_content_configDao;
import com.mysiteforme.admin.service.Wx_content_configService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 内容-基本配置 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2018-10-08
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class Wx_content_configServiceImpl extends ServiceImpl<Wx_content_configDao, Wx_content_config> implements Wx_content_configService {

}
