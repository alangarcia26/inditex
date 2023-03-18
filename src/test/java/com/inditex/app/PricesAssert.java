package com.inditex.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.stereotype.Component;

import com.inditex.action.prices.search.response.PriceResponse;
import com.inditex.action.prices.search.response.PricesResponse;

@Component
public class PricesAssert {
	
	public void assertPrices(PricesResponse expected, PricesResponse actual) {
		assertNotNull(expected);
		assertNotNull(actual);
		
		assertNotNull(expected.getPrices());
		assertNotNull(actual.getPrices());
		
		assertEquals(expected.getPrices().size(), actual.getPrices().size());
		
		for(PriceResponse priceExpected : expected.getPrices()) {
			assertTrue(actual.getPrices().stream().anyMatch(priceActual -> 
				priceExpected.getBrandId().equals(priceActual.getBrandId()) &&
				priceExpected.getProductId().equals(priceActual.getProductId()) &&
				priceExpected.getPriceList().equals(priceActual.getPriceList()) &&
				priceExpected.getPrice().equals(priceActual.getPrice()) &&
				priceExpected.getStartDate().equals(priceActual.getStartDate()) &&
				priceExpected.getEndDate().equals(priceActual.getEndDate())
			));
		}
	}

}
