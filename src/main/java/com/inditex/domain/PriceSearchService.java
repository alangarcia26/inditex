package com.inditex.domain;

import org.springframework.stereotype.Service;

@Service
public class PriceSearchService {
	
	private final PriceRepository repository;
	
	public PriceSearchService(PriceRepository repository) {
		this.repository = repository;
	}

	public void search(PriceSearchFilters filters) {
		repository.search(filters.getPriceApplicationDate(), filters.getBrandId(), filters.getProductId());
	}

}
