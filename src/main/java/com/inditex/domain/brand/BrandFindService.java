package com.inditex.domain.brand;

import org.springframework.stereotype.Service;

import com.inditex.domain.FindRepository;
import com.inditex.infraestructure.brand.BrandEntity;

@Service
public class BrandFindService {
	
	private final FindRepository repository;
	
	public BrandFindService(FindRepository repository) {
		this.repository = repository;
	}

	public BrandEntity find(Integer id) {
		return repository.find("BRAND", id, BrandEntity.class);
	}

}
