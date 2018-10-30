package com.mysiteforme.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 积分码生成记录
 * </p>
 *
 * @author wangl
 * @since 2018-10-30
 */
@TableName("wx_integral_code")
public class WxIntegralCode extends DataEntity<WxIntegralCode> {

    private static final long serialVersionUID = 1L;

    /**
     * 积分兑换码
     */
	private String code;
    /**
     * 积分
     */
	@TableField("integral_num")
	private Integer integralNum;
    /**
     * 使用过 0未使用 1使用过
     */
	@TableField("is_used")
	private Integer isUsed;
    /**
     * 使用人
     */
	@TableField("open_id")
	private String openId;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public Integer getIntegralNum() {
		return integralNum;
	}

	public void setIntegralNum(Integer integralNum) {
		this.integralNum = integralNum;
	}
	public Integer getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(Integer isUsed) {
		this.isUsed = isUsed;
	}
	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}


	@Override
	public String toString() {
		return "WxIntegralCode{" +
			", code=" + code +
			", integralNum=" + integralNum +
			", isUsed=" + isUsed +
			", openId=" + openId +
			"}";
	}
}
