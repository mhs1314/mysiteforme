package com.mysiteforme.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 内容-基本配置
 * </p>
 *
 * @author wangl
 * @since 2018-10-09
 */
@TableName("wx_content_config")
public class WxContentConfig extends DataEntity<WxContentConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 音视频自动播放 0关闭 1开启
     */
	@TableField("is_open_audio")
	private Boolean isOpenAudio;
    /**
     * 评论留言功能：0关闭 1开启
     */
	@TableField("is_open_comment")
	private Boolean isOpenComment;
    /**
     * 评论审核：0不审核 1审核
     */
	@TableField("is_need_examine")
	private Boolean isNeedExamine;
    /**
     * 浏览文章增加积分
     */
	@TableField("browse_integral_num")
	private Integer browseIntegralNum;
    /**
     * 评论文章增加积分
     */
	@TableField("comment_integral_num")
	private Integer commentIntegralNum;
    /**
     * 显示相关爱好物 0不显示 1显示
     */
	@TableField("is_show_like")
	private Boolean isShowLike;

	public Boolean getOpenAudio() {
		return isOpenAudio;
	}

	public void setOpenAudio(Boolean isOpenAudio) {
		this.isOpenAudio = isOpenAudio;
	}
	public Boolean getOpenComment() {
		return isOpenComment;
	}

	public void setOpenComment(Boolean isOpenComment) {
		this.isOpenComment = isOpenComment;
	}
	public Boolean getNeedExamine() {
		return isNeedExamine;
	}

	public void setNeedExamine(Boolean isNeedExamine) {
		this.isNeedExamine = isNeedExamine;
	}
	public Integer getBrowseIntegralNum() {
		return browseIntegralNum;
	}

	public void setBrowseIntegralNum(Integer browseIntegralNum) {
		this.browseIntegralNum = browseIntegralNum;
	}
	public Integer getCommentIntegralNum() {
		return commentIntegralNum;
	}

	public void setCommentIntegralNum(Integer commentIntegralNum) {
		this.commentIntegralNum = commentIntegralNum;
	}
	public Boolean getShowLike() {
		return isShowLike;
	}

	public void setShowLike(Boolean isShowLike) {
		this.isShowLike = isShowLike;
	}


	@Override
	public String toString() {
		return "WxContentConfig{" +
			", isOpenAudio=" + isOpenAudio +
			", isOpenComment=" + isOpenComment +
			", isNeedExamine=" + isNeedExamine +
			", browseIntegralNum=" + browseIntegralNum +
			", commentIntegralNum=" + commentIntegralNum +
			", isShowLike=" + isShowLike +
			"}";
	}
}
