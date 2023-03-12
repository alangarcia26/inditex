package com.inditex.domain.prices;

import java.sql.Timestamp;
import java.util.List;

import com.inditex.infraestructure.prices.PriceEntity;

public interface PriceRepository {
	
	List<PriceEntity> search(Timestamp priceApplicationDate, Integer brandId, Integer productId);

}
