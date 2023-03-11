package com.inditex.action.prices.search;

import org.springframework.stereotype.Component;

import com.inditex.action.prices.search.parameters.PriceSearchParameters;
import com.inditex.action.prices.search.parameters.PriceSearchParametersToFiltersMapping;
import com.inditex.action.prices.search.response.PricesResponse;
import com.inditex.domain.PriceSearchFilters;
import com.inditex.domain.PriceSearchService;

@Component
public class SearchPrices {
	
	private final PriceSearchParametersToFiltersMapping priceSearchParametersToFiltersMapping;
	private final PriceSearchService priceSearchService;
	
	public SearchPrices(PriceSearchParametersToFiltersMapping priceSearchParametersToFiltersMapping,
			PriceSearchService priceSearchService) {
		this.priceSearchParametersToFiltersMapping = priceSearchParametersToFiltersMapping;
		this.priceSearchService = priceSearchService;
	}

	public PricesResponse search(PriceSearchParameters parameters) {
		PriceSearchFilters filters = priceSearchParametersToFiltersMapping.map(parameters);
		priceSearchService.search(filters);
		return null;
	}
	
}
