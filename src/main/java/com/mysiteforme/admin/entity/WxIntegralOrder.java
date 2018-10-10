package com.mysiteforme.admin.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 积分商城订单
 * </p>
 *
 * @author wangl
 * @since 2018-10-10
 */
@TableName("wx_integral_order")
public class WxIntegralOrder extends DataEntity<WxIntegralOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号
     */
	@TableField("order_num")
	private String orderNum;
    /**
     * 购买用户id
     */
	@TableField("open_id")
	private Integer openId;
    /**
     * 积分商品id
     */
	@TableField("good_id")
	private Integer goodId;
    /**
     * 订单时间
     */
	@TableField("order_time")
	private Date orderTime;
    /**
     * 订单状态 0待支付 1取消 2已支付
     */
	@TableField("order_status")
	private Integer orderStatus;

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Integer getOpenId() {
		return openId;
	}

	public void setOpenId(Integer openId) {
		this.openId = openId;
	}
	public Integer getGoodId() {
		return goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}


	@Override
	public String toString() {
		return "WxIntegralOrder{" +
			", orderNum=" + orderNum +
			", openId=" + openId +
			", goodId=" + goodId +
			", orderTime=" + orderTime +
			", orderStatus=" + orderStatus +
			"}";
	}
}
