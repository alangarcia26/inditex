package com.inditex.controller;

import static java.util.Objects.isNull;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.action.prices.search.SearchPrices;
import com.inditex.action.prices.search.parameters.PriceSearchParameters;
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
		PricesResponse body = searchPrices.search(parameters);
		return isNull(body) ? ResponseEntity.noContent().build() : ResponseEntity.ok(body);
	}
	
}
