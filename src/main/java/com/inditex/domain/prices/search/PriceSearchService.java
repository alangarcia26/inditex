package com.inditex.domain.prices.search;

import java.sql.Timestamp;
import java.util.List;
import static java.util.Objects.nonNull;

import static java.util.Optional.ofNullable;

import org.springframework.stereotype.Service;

import com.inditex.domain.InvalidParamException;
import com.inditex.domain.brand.BrandFindService;
import com.inditex.domain.prices.Price;
import com.inditex.domain.prices.PriceEntityToPriceMapping;
import com.inditex.domain.prices.PriceRepository;
import com.inditex.domain.product.ProductFindService;
import com.inditex.infraestructure.prices.PriceEntity;

@Service
public class PriceSearchService {
	
	private final PriceRepository repository;
	private final BrandFindService brandFindService;
	private final ProductFindService productFindService;
	private final PriceEntityToPriceMapping priceEntityToPriceMapping;
	
	public PriceSearchService(PriceRepository repository, 
			BrandFindService brandFindService,
			ProductFindService productFindService, 
			PriceEntityToPriceMapping priceEntityToPriceMapping) {
		this.repository = repository;
		this.brandFindService = brandFindService;
		this.productFindService = productFindService;
		this.priceEntityToPriceMapping = priceEntityToPriceMapping;
	}

	public List<Price> search(PriceSearchFilters filters) throws InvalidParamException {
		List<PriceEntity> entities = repository.search(
				convertPriceApplicationDate(filters.getPriceApplicationDate()), 
				checkBrand(filters.getBrandId()), 
				checkProduct(filters.getProductId()));
		return priceEntityToPriceMapping.map(entities);
	} 
	
	private Timestamp convertPriceApplicationDate(String priceApplicationDate) throws InvalidParamException {
		Timestamp priceApplicationDateConverted = null;
		if(nonNull(priceApplicationDate)) {
			try {
				priceApplicationDateConverted = Timestamp.valueOf(priceApplicationDate);
			}catch(IllegalArgumentException e) {
				throw new InvalidParamException(e.getMessage(), "priceApplicationDate", priceApplicationDate);
			}
		}
		return priceApplicationDateConverted;
	}
	
	private Integer checkBrand(Integer brandId) throws InvalidParamException {
		return nonNull(brandId) ? ofNullable(brandFindService.find(brandId))
			.orElseThrow(() -> new InvalidParamException("Brand does not exist", "brandId", brandId.toString())).getId() : null;
	}
	
	private Integer checkProduct(Integer productId) throws InvalidParamException {
		return nonNull(productId) ? ofNullable(productFindService.find(productId))
			.orElseThrow(() -> new InvalidParamException("Product does not exist", "productId", productId.toString())).getId() : null;
	}
	
}
