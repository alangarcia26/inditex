package com.inditex.action.prices.search;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inditex.action.prices.search.parameters.PriceSearchParameters;
import com.inditex.action.prices.search.parameters.PriceSearchParametersToFiltersMapping;
import com.inditex.action.prices.search.response.PriceResponse;
import com.inditex.action.prices.search.response.PriceToPriceResponseMapping;
import com.inditex.domain.InvalidParamException;
import com.inditex.domain.prices.Price;
import com.inditex.domain.prices.search.PriceSearchFilters;
import com.inditex.domain.prices.search.PriceSearchService;

@Component
public class SearchPrices {
	
	private final PriceSearchParametersToFiltersMapping priceSearchParametersToFiltersMapping;
	private final PriceSearchService priceSearchService;
	private final PriceToPriceResponseMapping priceToPriceResponseMapping;
	
	public SearchPrices(PriceSearchParametersToFiltersMapping priceSearchParametersToFiltersMapping,
			PriceSearchService priceSearchService,
			PriceToPriceResponseMapping priceToPriceResponseMapping) {
		this.priceSearchParametersToFiltersMapping = priceSearchParametersToFiltersMapping;
		this.priceSearchService = priceSearchService;
		this.priceToPriceResponseMapping = priceToPriceResponseMapping;
	}

	public List<PriceResponse> search(PriceSearchParameters parameters) throws InvalidParamException {
		PriceSearchFilters filters = priceSearchParametersToFiltersMapping.map(parameters);
		List<Price> prices = priceSearchService.search(filters);
		return priceToPriceResponseMapping.map(prices);
	}
	
}
