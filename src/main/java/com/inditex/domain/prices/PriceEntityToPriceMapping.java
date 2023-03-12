package com.inditex.domain.prices;

import java.util.List;
import static java.util.Optional.of;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.inditex.infraestructure.prices.PriceEntity;

@Component
public class PriceEntityToPriceMapping {
	
	public List<Price> map(List<PriceEntity> entities){
		return of(entities.stream().map(entity -> map(entity))
				.collect(Collectors.toList()))
				.orElse(null);
	}
	
	private Price map(PriceEntity entity) {
		return new Price(entity.getId(), 
				entity.getBrandId(), 
				entity.getStartDate().toLocalDateTime(),
				entity.getEndDate().toLocalDateTime(), 
				entity.getPriceList(), 
				entity.getProductId(), 
				entity.getPriority(), 
				entity.getPrice(),
				entity.getCurr());
	}

}
