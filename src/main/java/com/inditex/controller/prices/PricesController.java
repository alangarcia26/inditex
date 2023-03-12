package com.inditex.controller.prices;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import static org.springframework.util.ObjectUtils.isEmpty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.action.prices.search.SearchPrices;
import com.inditex.action.prices.search.parameters.PriceSearchParameters;
import com.inditex.action.prices.search.response.PriceResponse;
import com.inditex.action.prices.search.response.PricesResponse;

@RestController
@RequestMapping(value = "/v1/prices")
public class PricesController {
	
	private final SearchPrices searchPrices;

	public PricesController(SearchPrices searchPrices) {
		this.searchPrices = searchPrices;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PricesResponse> search(PriceSearchParameters parameters) {
		List<PriceResponse> prices = searchPrices.search(parameters);
		return isEmpty(prices) ? ResponseEntity.noContent().build() : ResponseEntity.ok(new PricesResponse(prices));
	}
	
}
