package com.mysiteforme.admin.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 统计表
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@TableName("wx_sys_count")
public class WxSysCount extends DataEntity<WxSysCount> {

    private static final long serialVersionUID = 1L;

    /**
     * 打开次数
     */
	@TableField("open_num")
	private Integer openNum;
    /**
     * 访问次数
     */
	@TableField("see_num")
	private Integer seeNum;
    /**
     * 新访问次数
     */
	@TableField("new_see_num")
	private Integer newSeeNum;
    /**
     * 分享次数
     */
	@TableField("share_num")
	private Integer shareNum;
    /**
     * 时间
     */
	@TableField("sys_time")
	private Date sysTime;

	public Integer getOpenNum() {
		return openNum;
	}

	public void setOpenNum(Integer openNum) {
		this.openNum = openNum;
	}
	public Integer getSeeNum() {
		return seeNum;
	}

	public void setSeeNum(Integer seeNum) {
		this.seeNum = seeNum;
	}
	public Integer getNewSeeNum() {
		return newSeeNum;
	}

	public void setNewSeeNum(Integer newSeeNum) {
		this.newSeeNum = newSeeNum;
	}
	public Integer getShareNum() {
		return shareNum;
	}

	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}
	public Date getSysTime() {
		return sysTime;
	}

	public void setSysTime(Date sysTime) {
		this.sysTime = sysTime;
	}


	@Override
	public String toString() {
		return "WxSysCount{" +
			", openNum=" + openNum +
			", seeNum=" + seeNum +
			", newSeeNum=" + newSeeNum +
			", shareNum=" + shareNum +
			", sysTime=" + sysTime +
			"}";
	}
}
