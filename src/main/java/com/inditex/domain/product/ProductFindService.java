package com.inditex.domain.product;

import org.springframework.stereotype.Service;

import com.inditex.domain.FindRepository;
import com.inditex.infraestructure.product.ProductEntity;

@Service
public class ProductFindService {
	
	private final FindRepository repository;
	
	public ProductFindService(FindRepository repository) {
		this.repository = repository;
	}

	public ProductEntity find(Integer id) {
		return repository.find("PRODUCT", id, ProductEntity.class);
	}

}
