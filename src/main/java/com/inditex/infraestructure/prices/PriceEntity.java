package com.inditex.infraestructure.prices;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PriceEntity {
	
	private Integer id;
	private Integer brandId;
	private Timestamp startDate;
	private Timestamp endDate;
	private Integer priceList;
	private Integer productId;
	private Boolean priority;
	private BigDecimal price;
	private String curr;
	
	public PriceEntity() {}
	
	public PriceEntity(Integer id, Integer brandId, Timestamp startDate, Timestamp endDate, Integer priceList,
			Integer productId, Boolean priority, BigDecimal price, String curr) {
		this.id = id;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getBrandId() {
		return brandId;
	}
	
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	
	public Timestamp getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	
	public Timestamp getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	
	public Integer getPriceList() {
		return priceList;
	}
	
	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Boolean getPriority() {
		return priority;
	}
	
	public void setPriority(Boolean priority) {
		this.priority = priority;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

}
