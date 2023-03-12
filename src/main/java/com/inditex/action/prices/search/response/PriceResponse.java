package com.inditex.action.prices.search.response;

import java.io.Serializable;
import java.math.BigDecimal;

public class PriceResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1218110736251477175L;

	private Integer brandId;
	private Integer productId;
	private Integer priceList;
	private String startDate;
	private String endDate;
	private BigDecimal price;
	
	public PriceResponse() {}
	
	public PriceResponse(Integer brandId, Integer productId, Integer priceList, String startDate,
			String endDate, BigDecimal price) {
		this.brandId = brandId;
		this.productId = productId;
		this.priceList = priceList;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}

	public Integer getBrandId() {
		return brandId;
	}
	
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getPriceList() {
		return priceList;
	}
	
	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
