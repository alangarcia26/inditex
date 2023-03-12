package com.inditex.domain.prices.search;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inditex.domain.LocalDateTimeConverter;
import com.inditex.domain.prices.PriceEntityToPriceMapping;
import com.inditex.domain.prices.PriceRepository;
import com.inditex.infraestructure.prices.PriceEntity;

@Service
public class PriceSearchService {
	
	private final PriceRepository repository;
	private final PriceEntityToPriceMapping priceEntityToPriceMapping;
	private final LocalDateTimeConverter localDateTimeConverter;
	
	public PriceSearchService(PriceRepository repository,
			PriceEntityToPriceMapping priceEntityToPriceMapping,
			LocalDateTimeConverter localDateTimeConverter) {
		this.repository = repository;
		this.priceEntityToPriceMapping = priceEntityToPriceMapping;
		this.localDateTimeConverter = localDateTimeConverter;
	}

	public List<Price> search(PriceSearchFilters filters) {
		List<PriceEntity> entities = repository.search(
				convertPriceApplicationDate(filters.getPriceApplicationDate()), 
				filters.getBrandId(), 
				filters.getProductId());
		return priceEntityToPriceMapping.map(entities);
	} 
	
	private LocalDateTime convertPriceApplicationDate(String priceApplicationDate) {
		return localDateTimeConverter.convert(priceApplicationDate);
	}

}
