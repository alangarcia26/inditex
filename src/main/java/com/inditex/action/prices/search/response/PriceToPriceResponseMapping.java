package com.inditex.action.prices.search.response;

import java.util.List;
import static java.util.Optional.of;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.inditex.domain.prices.Price;

@Component
public class PriceToPriceResponseMapping {
	
	public List<PriceResponse> map(List<Price> prices){
		return of(prices.stream().map(price -> map(price))
				.collect(Collectors.toList()))
				.orElse(null);
	}
	
	private PriceResponse map(Price price) {
		return new PriceResponse(price.getBrandId(), 
				price.getProductId(), 
				price.getPriceList(), 
				price.getStartDate().toString(), 
				price.getEndDate().toString(), 
				price.getPrice());
	}
	
}
