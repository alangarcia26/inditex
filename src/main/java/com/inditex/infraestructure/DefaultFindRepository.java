package com.inditex.infraestructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.domain.FindRepository;
import com.inditex.infraestructure.querybuilder.Query;
import com.inditex.infraestructure.querybuilder.SelectBuilder;

@Repository
public class DefaultFindRepository implements FindRepository{
	
	private final String schema;
	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	public DefaultFindRepository(@Value("${db-properties.schema}") String schema,
			NamedParameterJdbcTemplate jdbcTemplate) {
		this.schema = schema;
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public <T> T find(String table, Object id, Class<T> type) {
		T entity = null;
		try {
			SelectBuilder selectBuilder = new SelectBuilder();
			Query query = selectBuilder.all()
					.from()
					.schema(this.schema)
					.table(table)
					.where()
					.equal(table, "ID", "ID", id)
					.build();
			
			entity = jdbcTemplate.queryForObject(
					query.getQuery(), 
					query.getParams(), 
					new BeanPropertyRowMapper<T>(type));
		} catch (EmptyResultDataAccessException e) {
			entity = null;
		} 
		return entity;
	}

}
