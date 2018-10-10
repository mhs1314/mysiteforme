package com.mysiteforme.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 内容-轮播管理
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@TableName("wx_content_broadcast")
public class WxContentBroadcast extends DataEntity<WxContentBroadcast> {

    private static final long serialVersionUID = 1L;

    /**
     * 标题名称
     */
	@TableField("title_name")
	private String titleName;
    /**
     * 图片处理
     */
	private String image;
    /**
     * 链接地址
     */
	private String url;
    /**
     * 显示 0不显示 1显示
     */
	@TableField("is_show")
	private Boolean isShow;
    /**
     * 排序
     */
	private String sort;
    /**
     * 所属模块 0首页 1资讯 2积分
     */
	private Integer modle;

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getShow() {
		return isShow;
	}

	public void setShow(Boolean isShow) {
		this.isShow = isShow;
	}
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	public Integer getModle() {
		return modle;
	}

	public void setModle(Integer modle) {
		this.modle = modle;
	}


	@Override
	public String toString() {
		return "WxContentBroadcast{" +
			", titleName=" + titleName +
			", image=" + image +
			", url=" + url +
			", isShow=" + isShow +
			", sort=" + sort +
			", modle=" + modle +
			"}";
	}
}
