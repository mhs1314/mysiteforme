package com.mysiteforme.admin.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mysiteforme.admin.base.DataEntity;

/**
 * <p>
 * 积分商品
 * </p>
 *
 * @author wangl
 * @since 2018-10-26
 */
@TableName("wx_integral_good")
public class WxIntegralGood extends DataEntity<WxIntegralGood> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品名称
     */
	@TableField("good_name")
	private String goodName;
    /**
     * 市场价格
     */
	@TableField("market_price")
	private Double marketPrice;
    /**
     * 销售价格
     */
	@TableField("sale_price")
	private Double salePrice;
    /**
     * 商品兑换积分
     */
	@TableField("integral_num")
	private Integer integralNum;
    /**
     * 库存
     */
	@TableField("stock_num")
	private Integer stockNum;
    /**
     * 兑换次数
     */
	@TableField("exchange_num")
	private Integer exchangeNum;
    /**
     * 0下架 1上架
     */
	@TableField("sale_status")
	private Boolean saleStatus;
    /**
     * 地址 0不需要 1需要
     */
	@TableField("need_address")
	private Boolean needAddress;
    /**
     * 缩略图
     */
	@TableField("thumbnail_url")
	private String thumbnailUrl;
    /**
     * 商品图册，用逗号隔开
     */
	@TableField("good_imges")
	private String goodImges;
    /**
     * 商品简介
     */
	@TableField("goog_desc")
	private String googDesc;
    /**
     * 截止时间
     */
	@TableField("end_time")
	private Date endTime;
    /**
     * 商品说明
     */
	@TableField("good_notes")
	private String goodNotes;
    /**
     * 商品排序
     */
	@TableField("good_sort")
	private Integer goodSort;
    /**
     * 商品类型 0积分 1钱
     */
	@TableField("good_type")
	private Integer goodType;

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public Double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	public Integer getIntegralNum() {
		return integralNum;
	}

	public void setIntegralNum(Integer integralNum) {
		this.integralNum = integralNum;
	}
	public Integer getStockNum() {
		return stockNum;
	}

	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}
	public Integer getExchangeNum() {
		return exchangeNum;
	}

	public void setExchangeNum(Integer exchangeNum) {
		this.exchangeNum = exchangeNum;
	}
	public Boolean getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(Boolean saleStatus) {
		this.saleStatus = saleStatus;
	}
	public Boolean getNeedAddress() {
		return needAddress;
	}

	public void setNeedAddress(Boolean needAddress) {
		this.needAddress = needAddress;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	public String getGoodImges() {
		return goodImges;
	}

	public void setGoodImges(String goodImges) {
		this.goodImges = goodImges;
	}
	public String getGoogDesc() {
		return googDesc;
	}

	public void setGoogDesc(String googDesc) {
		this.googDesc = googDesc;
	}
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getGoodNotes() {
		return goodNotes;
	}

	public void setGoodNotes(String goodNotes) {
		this.goodNotes = goodNotes;
	}
	public Integer getGoodSort() {
		return goodSort;
	}

	public void setGoodSort(Integer goodSort) {
		this.goodSort = goodSort;
	}
	public Integer getGoodType() {
		return goodType;
	}

	public void setGoodType(Integer goodType) {
		this.goodType = goodType;
	}


	@Override
	public String toString() {
		return "WxIntegralGood{" +
			", goodName=" + goodName +
			", marketPrice=" + marketPrice +
			", salePrice=" + salePrice +
			", integralNum=" + integralNum +
			", stockNum=" + stockNum +
			", exchangeNum=" + exchangeNum +
			", saleStatus=" + saleStatus +
			", needAddress=" + needAddress +
			", thumbnailUrl=" + thumbnailUrl +
			", goodImges=" + goodImges +
			", googDesc=" + googDesc +
			", endTime=" + endTime +
			", goodNotes=" + goodNotes +
			", goodSort=" + goodSort +
			", goodType=" + goodType +
			"}";
	}
}
