package com.inditex.action.prices.search.parameters;

import org.springframework.stereotype.Component;

import com.inditex.domain.PriceSearchFilters;

@Component
public class PriceSearchParametersToFiltersMapping {
	
	public PriceSearchFilters map(PriceSearchParameters parameters) {
		PriceSearchFilters filters = new PriceSearchFilters();
		filters.setBrandId(parameters.getBrandId());
		filters.setProductId(parameters.getProductId());
		filters.setPriceApplicationDate(parameters.getPriceApplicationDate());
		return filters;
	}

}
