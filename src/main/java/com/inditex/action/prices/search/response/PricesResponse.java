package com.inditex.action.prices.search.response;

import java.io.Serializable;
import java.util.List;

public class PricesResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 260937879568078680L;

	private List<PriceResponse> prices;
	
	public PricesResponse() {}
	
	public PricesResponse(List<PriceResponse> prices) {
		this.prices = prices;
	}

	public List<PriceResponse> getPrices() {
		return prices;
	}

	public void setPrices(List<PriceResponse> prices) {
		this.prices = prices;
	}
	
}
