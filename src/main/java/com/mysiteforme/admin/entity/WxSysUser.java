package com.mysiteforme.admin.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@TableName("wx_sys_user")
public class WxSysUser extends DataEntity<WxSysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户密码
     */
	private String password;
    /**
     * 用户姓名
     */
	@TableField("user_name")
	private String userName;
    /**
     * 用户头像
     */
	private String icon;
    /**
     * 微信唯一标识
     */
	@TableField("open_id")
	private String openId;
    /**
     * 积分
     */
	private Integer socer;
    /**
     * 最后登录时间
     */
	@TableField("last_login_time")
	private Date lastLoginTime;
    /**
     * 登录次数
     */
	@TableField("login_num")
	private Integer loginNum;
    /**
     * 经度
     */
	private String longi;
    /**
     * 纬度
     */
	private String lati;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Integer getSocer() {
		return socer;
	}

	public void setSocer(Integer socer) {
		this.socer = socer;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Integer getLoginNum() {
		return loginNum;
	}

	public void setLoginNum(Integer loginNum) {
		this.loginNum = loginNum;
	}
	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}
	public String getLati() {
		return lati;
	}

	public void setLati(String lati) {
		this.lati = lati;
	}


	@Override
	public String toString() {
		return "WxSysUser{" +
			", password=" + password +
			", userName=" + userName +
			", icon=" + icon +
			", openId=" + openId +
			", socer=" + socer +
			", lastLoginTime=" + lastLoginTime +
			", loginNum=" + loginNum +
			", longi=" + longi +
			", lati=" + lati +
			"}";
	}
}
