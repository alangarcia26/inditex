package com.inditex.action.prices.search.parameters;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PriceSearchParameters implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8301518954571470530L;

	private LocalDateTime priceApplicationDate;
	private Integer brandId;
	private Integer productId;

	public PriceSearchParameters() {}

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
