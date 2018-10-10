package com.mysiteforme.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 内容-轮播配置
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@TableName("wx_content_broadcast_config")
public class WxContentBroadcastConfig extends DataEntity<WxContentBroadcastConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 面板指示灯 0不显示 1显示
     */
	@TableField("is_show_point")
	private Boolean isShowPoint;
    /**
     * 自动切换 0不能 1可以
     */
	@TableField("is_auto_change")
	private Boolean isAutoChange;
    /**
     * 自动切换时间间隔（毫秒）
     */
	@TableField("auto_change_time")
	private Integer autoChangeTime;
    /**
     * 滑动动画时长（毫秒）
     */
	@TableField("animation_time")
	private Integer animationTime;

	public Boolean getShowPoint() {
		return isShowPoint;
	}

	public void setShowPoint(Boolean isShowPoint) {
		this.isShowPoint = isShowPoint;
	}
	public Boolean getAutoChange() {
		return isAutoChange;
	}

	public void setAutoChange(Boolean isAutoChange) {
		this.isAutoChange = isAutoChange;
	}
	public Integer getAutoChangeTime() {
		return autoChangeTime;
	}

	public void setAutoChangeTime(Integer autoChangeTime) {
		this.autoChangeTime = autoChangeTime;
	}
	public Integer getAnimationTime() {
		return animationTime;
	}

	public void setAnimationTime(Integer animationTime) {
		this.animationTime = animationTime;
	}


	@Override
	public String toString() {
		return "WxContentBroadcastConfig{" +
			", isShowPoint=" + isShowPoint +
			", isAutoChange=" + isAutoChange +
			", autoChangeTime=" + autoChangeTime +
			", animationTime=" + animationTime +
			"}";
	}
}
