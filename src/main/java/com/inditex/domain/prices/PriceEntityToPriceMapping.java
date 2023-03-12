package com.inditex.domain.prices;

import java.util.List;
import static java.util.Optional.of;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.inditex.domain.LocalDateTimeConverter;
import com.inditex.domain.prices.search.Price;
import com.inditex.infraestructure.prices.PriceEntity;

@Component
public class PriceEntityToPriceMapping {
	
	private final LocalDateTimeConverter localDateTimeConverter;
	
	public PriceEntityToPriceMapping(LocalDateTimeConverter dateTimeConverter) {
		this.localDateTimeConverter = dateTimeConverter;
	}

	public List<Price> map(List<PriceEntity> entities){
		return of(entities.stream().map(entity -> map(entity))
				.collect(Collectors.toList()))
				.orElse(null);
	}
	
	private Price map(PriceEntity entity) {
		return new Price(entity.getId(), 
				entity.getBrandId(), 
				localDateTimeConverter.convert(entity.getStartDate()),
				localDateTimeConverter.convert(entity.getEndDate()), 
				entity.getPriceList(), 
				entity.getProductId(), 
				entity.getPriority(), 
				entity.getPrice(),
				entity.getCurr());
	}

}
