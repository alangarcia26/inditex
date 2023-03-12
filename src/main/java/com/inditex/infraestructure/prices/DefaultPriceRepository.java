package com.inditex.infraestructure.prices;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.domain.prices.PriceRepository;
import com.inditex.infraestructure.querybuilder.Query;
import com.inditex.infraestructure.querybuilder.SelectBuilder;

@Repository
public class DefaultPriceRepository implements PriceRepository{
	
	private final String schema;
	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	public DefaultPriceRepository(@Value("${db-properties.schema}") String schema,
			NamedParameterJdbcTemplate jdbcTemplate) {
		this.schema = schema;
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<PriceEntity> search(Timestamp priceApplicationDate, Integer brandId, Integer productId) {
		SelectBuilder selectBuilder = new SelectBuilder();
		Query query = selectBuilder.all().from().schema(this.schema).table("PRICES")
			.where()
			.equal("PRICES", "BRAND_ID", "BRAND_ID", brandId)
			.and()
			.equal("PRICES", "PRODUCT_ID", "PRODUCT_ID", productId)
			.and()
			.lesser("PRICES", "START_DATE", "START_DATE", priceApplicationDate)
			.and()
			.greater("PRICES", "END_DATE", "END_DATE", priceApplicationDate)
			.build();
		
		return jdbcTemplate.query(
				query.getQuery(), 
				query.getParams(),
				new BeanPropertyRowMapper<PriceEntity>(PriceEntity.class));
	}

}
