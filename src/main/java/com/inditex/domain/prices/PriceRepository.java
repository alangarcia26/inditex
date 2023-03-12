package com.inditex.domain.prices;

import java.time.LocalDateTime;
import java.util.List;

import com.inditex.infraestructure.prices.PriceEntity;

public interface PriceRepository {
	
	List<PriceEntity> search(LocalDateTime priceApplicationDate, Integer brandId, Integer productId);

}
