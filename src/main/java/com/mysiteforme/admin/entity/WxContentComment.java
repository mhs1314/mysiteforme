package com.mysiteforme.admin.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 内容-评论
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@TableName("wx_content_comment")
public class WxContentComment extends DataEntity<WxContentComment> {

    private static final long serialVersionUID = 1L;

    /**
     * 图文内容id
     */
	@TableField("imgtext_id")
	private Integer imgtextId;
    /**
     * 用户唯一标识
     */
	@TableField("open_id")
	private String openId;
    /**
     * 显示 0不显示 1显示
     */
	@TableField("is_show")
	private Boolean isShow;
    /**
     * 用户姓名
     */
	@TableField("user_name")
	private String userName;
    /**
     * 用户头像
     */
	@TableField("user_icon")
	private String userIcon;
    /**
     * 评论时间
     */
	@TableField("add_time")
	private Date addTime;
    /**
     * 评论内容
     */
	private String content;

	public Integer getImgtextId() {
		return imgtextId;
	}

	public void setImgtextId(Integer imgtextId) {
		this.imgtextId = imgtextId;
	}
	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Boolean getShow() {
		return isShow;
	}

	public void setShow(Boolean isShow) {
		this.isShow = isShow;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "WxContentComment{" +
			", imgtextId=" + imgtextId +
			", openId=" + openId +
			", isShow=" + isShow +
			", userName=" + userName +
			", userIcon=" + userIcon +
			", addTime=" + addTime +
			", content=" + content +
			"}";
	}
}
