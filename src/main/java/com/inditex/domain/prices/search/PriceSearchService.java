package com.inditex.domain.prices.search;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inditex.domain.ParamFormatException;
import com.inditex.domain.prices.Price;
import com.inditex.domain.prices.PriceEntityToPriceMapping;
import com.inditex.domain.prices.PriceRepository;
import com.inditex.infraestructure.prices.PriceEntity;

@Service
public class PriceSearchService {
	
	private final PriceRepository repository;
	private final PriceEntityToPriceMapping priceEntityToPriceMapping;
	
	public PriceSearchService(PriceRepository repository,
			PriceEntityToPriceMapping priceEntityToPriceMapping) {
		this.repository = repository;
		this.priceEntityToPriceMapping = priceEntityToPriceMapping;
	}

	public List<Price> search(PriceSearchFilters filters) throws ParamFormatException {
		List<PriceEntity> entities = repository.search(
				convert(filters.getPriceApplicationDate()), 
				filters.getBrandId(), 
				filters.getProductId());
		return priceEntityToPriceMapping.map(entities);
	} 
	
	private Timestamp convert(String priceApplicationDate) throws ParamFormatException {
		Timestamp priceApplicationDateConverted = null;
		try {
			priceApplicationDateConverted = Timestamp.valueOf(priceApplicationDate);
		}catch(IllegalArgumentException e) {
			throw new ParamFormatException(e.getMessage(), "priceApplicationDate", priceApplicationDate);
		}
		return priceApplicationDateConverted;
	}
	
}
