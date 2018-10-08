package com.mysiteforme.admin.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 内容-基本配置
 * </p>
 *
 * @author wangl
 * @since 2018-10-08
 */
public class Wx_content_config extends DataEntity<Wx_content_config> {

    private static final long serialVersionUID = 1L;

    /**
     * 音视频自动播放 0不开启1开启
     */
	private Boolean is_open_audio;
    /**
     * 评论留言功能：0关闭 1开启
     */
	private Boolean is_open_comment;
    /**
     * 评论审核：0不审核 1审核
     */
	private Boolean is_need_examine;
    /**
     * 浏览文章增加积分
     */
	private Integer browse_integral_num;
    /**
     * 评论文章增加积分
     */
	private Integer comment_integral_num;
    /**
     * 显示相关爱好物 0不显示 1显示
     */
	private Boolean is_show_like;

	public Boolean getIs_open_audio() {
		return is_open_audio;
	}

	public void setIs_open_audio(Boolean is_open_audio) {
		this.is_open_audio = is_open_audio;
	}
	public Boolean getIs_open_comment() {
		return is_open_comment;
	}

	public void setIs_open_comment(Boolean is_open_comment) {
		this.is_open_comment = is_open_comment;
	}
	public Boolean getIs_need_examine() {
		return is_need_examine;
	}

	public void setIs_need_examine(Boolean is_need_examine) {
		this.is_need_examine = is_need_examine;
	}
	public Integer getBrowse_integral_num() {
		return browse_integral_num;
	}

	public void setBrowse_integral_num(Integer browse_integral_num) {
		this.browse_integral_num = browse_integral_num;
	}
	public Integer getComment_integral_num() {
		return comment_integral_num;
	}

	public void setComment_integral_num(Integer comment_integral_num) {
		this.comment_integral_num = comment_integral_num;
	}
	public Boolean getIs_show_like() {
		return is_show_like;
	}

	public void setIs_show_like(Boolean is_show_like) {
		this.is_show_like = is_show_like;
	}


	@Override
	public String toString() {
		return "Wx_content_config{" +
			", is_open_audio=" + is_open_audio +
			", is_open_comment=" + is_open_comment +
			", is_need_examine=" + is_need_examine +
			", browse_integral_num=" + browse_integral_num +
			", comment_integral_num=" + comment_integral_num +
			", is_show_like=" + is_show_like +
			"}";
	}
}
