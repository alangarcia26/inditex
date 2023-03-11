package com.inditex.domain;

import java.time.LocalDateTime;

public interface PriceRepository {
	
	void search(LocalDateTime priceApplicationDate, Integer brandId, Integer productId);

}
