package com.mysiteforme.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mysiteforme.admin.dao.WxContentTypeDao;
import com.mysiteforme.admin.entity.WxContentType;
import com.mysiteforme.admin.service.WxContentTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 内容-分类 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2018-10-11
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WxContentTypeServiceImpl extends ServiceImpl<WxContentTypeDao, WxContentType> implements WxContentTypeService {

}
