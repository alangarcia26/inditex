package com.inditex.app;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.inditex.action.prices.search.response.PricesResponse;
import com.inditex.controller.exception.InvalidParamExceptionResponse;

public class SearchPricesIT extends BaseIT{
	
	private static final String OBJECT_EXPECTED_PATH = "src/test/resources/object-expected/prices/search/";
	private static final String ENDPOINT = "/v1/prices";
	
	private static final String PRICES_BY_BRAND_1_EXPECTED = OBJECT_EXPECTED_PATH + "by-brand-1.json";
	private static final String PRICES_BY_PRODUCT_1_EXPECTED = OBJECT_EXPECTED_PATH + "by-product-1.json";
	private static final String PRICES_BY_PRODUCT_2_EXPECTED = OBJECT_EXPECTED_PATH + "by-product-2.json";
	private static final String PRICES_BY_DATETIME_2020_06_14_100000_EXPECTED = OBJECT_EXPECTED_PATH + "by-datetime-2020-06-14-100000.json";
	private static final String PRICES_BY_DATETIME_2020_06_14_160000_EXPECTED = OBJECT_EXPECTED_PATH + "by-datetime-2020-06-14-160000.json";
	private static final String PRICES_BY_PRODUCT_1_DATETIME_2020_06_14_100000_EXPECTED = OBJECT_EXPECTED_PATH + "by-product-1-datetime-2020-06-14-100000.json";
	private static final String PRICES_BY_PRODUCT_2_DATETIME_2020_06_14_160000_EXPECTED = OBJECT_EXPECTED_PATH + "by-product-2-datetime-2020-06-14-160000.json";
	private static final String PRICES_BY_BRAND_2_EXPECTED = OBJECT_EXPECTED_PATH + "by-brand-2.json";
	private static final String PRICES_BY_PRODUCT_3_EXPECTED = OBJECT_EXPECTED_PATH + "by-product-3.json";
	
	@Autowired
	private PricesAssert pricesAssert;
	
	@Test
	public void givenPricesSearchByBrandId_whenInvokeService_thenPricesReturned() throws IOException {
		PricesResponse expected = readObjectFromJson(PRICES_BY_BRAND_1_EXPECTED, PricesResponse.class);
		
		GetCalls<PricesResponse> get = newGet(ENDPOINT.concat("?brandId=1"), PricesResponse.class);
		
		ResponseEntity<PricesResponse> response = get.call();
		
		PricesResponse actual = response.getBody();
		
		assertOk(response);
		pricesAssert.assertPrices(expected, actual);
	}
	
	@Test
	public void givenPricesSearchByProductId1_whenInvokeService_thenPricesReturned() throws IOException {
		PricesResponse expected = readObjectFromJson(PRICES_BY_PRODUCT_1_EXPECTED, PricesResponse.class);
		
		GetCalls<PricesResponse> get = newGet(ENDPOINT.concat("?productId=1"), PricesResponse.class);
		
		ResponseEntity<PricesResponse> response = get.call();
		
		PricesResponse actual = response.getBody();
		
		assertOk(response);
		pricesAssert.assertPrices(expected, actual);
	}
	
	@Test
	public void givenPricesSearchByProductId2_whenInvokeService_thenPricesReturned() throws IOException {
		PricesResponse expected = readObjectFromJson(PRICES_BY_PRODUCT_2_EXPECTED, PricesResponse.class);
		
		GetCalls<PricesResponse> get = newGet(ENDPOINT.concat("?productId=2"), PricesResponse.class);
		
		ResponseEntity<PricesResponse> response = get.call();
		
		PricesResponse actual = response.getBody();
		
		assertOk(response);
		pricesAssert.assertPrices(expected, actual);
	}
	
	@Test
	public void givenPricesSearchByPriceApplicationDate2020_06_14_100000_whenInvokeService_thenPricesReturned() throws IOException {
		PricesResponse expected = readObjectFromJson(PRICES_BY_DATETIME_2020_06_14_100000_EXPECTED, PricesResponse.class);
		
		GetCalls<PricesResponse> get = newGet(ENDPOINT.concat("?priceApplicationDate=2020-06-14 10:00:00"), PricesResponse.class);
		
		ResponseEntity<PricesResponse> response = get.call();
		
		PricesResponse actual = response.getBody();
		
		assertOk(response);
		pricesAssert.assertPrices(expected, actual);
	}
	
	@Test
	public void givenPricesSearchByPriceApplicationDate2020_06_14_160000_whenInvokeService_thenPricesReturned() throws IOException {
		PricesResponse expected = readObjectFromJson(PRICES_BY_DATETIME_2020_06_14_160000_EXPECTED, PricesResponse.class);
		
		GetCalls<PricesResponse> get = newGet(ENDPOINT.concat("?priceApplicationDate=2020-06-14 16:00:00"), PricesResponse.class);
		
		ResponseEntity<PricesResponse> response = get.call();
		
		PricesResponse actual = response.getBody();
		
		assertOk(response);
		pricesAssert.assertPrices(expected, actual);
	}
	
	@Test
	public void givenPricesSearchByProductId1AndPriceApplicationDate2020_06_14_100000_whenInvokeService_thenPricesReturned() throws IOException {
		PricesResponse expected = readObjectFromJson(PRICES_BY_PRODUCT_1_DATETIME_2020_06_14_100000_EXPECTED, PricesResponse.class);
		
		GetCalls<PricesResponse> get = newGet(ENDPOINT.concat("?productId=1&priceApplicationDate=2020-06-14 10:00:00"), PricesResponse.class);
		
		ResponseEntity<PricesResponse> response = get.call();
		
		PricesResponse actual = response.getBody();
		
		assertOk(response);
		pricesAssert.assertPrices(expected, actual);
	}
	
	@Test
	public void givenPricesSearchByProductId2AndPriceApplicationDate2020_06_14_160000_whenInvokeService_thenPricesReturned() throws IOException {
		PricesResponse expected = readObjectFromJson(PRICES_BY_PRODUCT_2_DATETIME_2020_06_14_160000_EXPECTED, PricesResponse.class);
		
		GetCalls<PricesResponse> get = newGet(ENDPOINT.concat("?productId=2&priceApplicationDate=2020-06-14 16:00:00"), PricesResponse.class);
		
		ResponseEntity<PricesResponse> response = get.call();
		
		PricesResponse actual = response.getBody();
		
		assertOk(response);
		pricesAssert.assertPrices(expected, actual);
	}
	
	@Test
	public void givenPricesSearchByPriceApplicationDate2030_06_14_160000_whenInvokeService_thenNoContent() throws IOException {
		GetCalls<PricesResponse> get = newGet(ENDPOINT.concat("?priceApplicationDate=2030-06-14 16:00:00"), PricesResponse.class);
		
		ResponseEntity<PricesResponse> response = get.call();
		
		assertNoContent(response);
	}
	
	@Test
	public void givenPricesSearchByBrandId2_whenInvokeService_thenInvalidParamException() throws IOException {
		InvalidParamExceptionResponse expected = readObjectFromJson(PRICES_BY_BRAND_2_EXPECTED, InvalidParamExceptionResponse.class);
		
		GetCalls<InvalidParamExceptionResponse> get = newGet(ENDPOINT.concat("?brandId=2"), InvalidParamExceptionResponse.class);
		
		ResponseEntity<InvalidParamExceptionResponse> response = get.call();
		
		assertInvalidParamException(expected, response);
	}
	
	@Test
	public void givenPricesSearchByProductId3_whenInvokeService_thenInvalidParamException() throws IOException {
		InvalidParamExceptionResponse expected = readObjectFromJson(PRICES_BY_PRODUCT_3_EXPECTED, InvalidParamExceptionResponse.class);
		
		GetCalls<InvalidParamExceptionResponse> get = newGet(ENDPOINT.concat("?productId=3"), InvalidParamExceptionResponse.class);
		
		ResponseEntity<InvalidParamExceptionResponse> response = get.call();
		
		assertInvalidParamException(expected, response);
	}
	
}
