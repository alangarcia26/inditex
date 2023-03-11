package com.inditex.infraestructure;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.inditex.domain.PriceRepository;

@Repository
public class DefaultPriceRepository implements PriceRepository{

	@Override
	public void search(LocalDateTime priceApplicationDate, Integer brandId, Integer productId) {
		// TODO Auto-generated method stub
	}

}
