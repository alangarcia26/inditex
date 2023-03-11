package com.inditex.domain;

import java.time.LocalDateTime;

public class PriceSearchFilters {
	
	private LocalDateTime priceApplicationDate;
	private Integer brandId;
	private Integer productId;

	public PriceSearchFilters() {}

	public LocalDateTime getPriceApplicationDate() {
		return priceApplicationDate;
	}

	public void setPriceApplicationDate(LocalDateTime priceApplicationDate) {
		this.priceApplicationDate = priceApplicationDate;
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

}
