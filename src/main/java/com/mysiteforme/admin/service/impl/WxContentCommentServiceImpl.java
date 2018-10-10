package com.mysiteforme.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mysiteforme.admin.dao.WxContentCommentDao;
import com.mysiteforme.admin.entity.WxContentComment;
import com.mysiteforme.admin.service.WxContentCommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 内容-评论 服务实现类
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WxContentCommentServiceImpl extends ServiceImpl<WxContentCommentDao, WxContentComment> implements WxContentCommentService {

}
