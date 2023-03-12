package com.inditex.domain.prices.search;

public class PriceSearchFilters {
	
	private String priceApplicationDate;
	private Integer brandId;
	private Integer productId;

	public PriceSearchFilters() {}

	public String getPriceApplicationDate() {
		return priceApplicationDate;
	}

	public void setPriceApplicationDate(String priceApplicationDate) {
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
