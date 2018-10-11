package com.mysiteforme.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 内容-分类
 * </p>
 *
 * @author wangl
 * @since 2018-10-11
 */
@TableName("wx_content_type")
public class WxContentType extends DataEntity<WxContentType> {

    private static final long serialVersionUID = 1L;

    /**
     * 分类名称
     */
	private String name;
    /**
     * 是否显示 0不显示 1显示
     */
	@TableField("is_show")
	private Boolean isShow;
    /**
     * 排序
     */
	private Integer sort;
    /**
     * 图标
     */
	private String icon;
    /**
     * 所属模块 0首页 1资讯 
     */
	private Integer modle;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Boolean getShow() {
		return isShow;
	}

	public void setShow(Boolean isShow) {
		this.isShow = isShow;
	}
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getModle() {
		return modle;
	}

	public void setModle(Integer modle) {
		this.modle = modle;
	}


	@Override
	public String toString() {
		return "WxContentType{" +
			", name=" + name +
			", isShow=" + isShow +
			", sort=" + sort +
			", icon=" + icon +
			", modle=" + modle +
			"}";
	}
}
