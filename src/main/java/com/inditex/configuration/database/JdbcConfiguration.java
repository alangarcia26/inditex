package com.inditex.configuration.database;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableConfigurationProperties({DataSourceProperties.class, FlywayProperties.class})
public class JdbcConfiguration {
	
	private final DataSourceProperties dataSourceProperties;
	private final FlywayProperties flywayProperties;

	public JdbcConfiguration(DataSourceProperties dataSourceProperties, 
			FlywayProperties flywayProperties) {
		this.dataSourceProperties = dataSourceProperties;
		this.flywayProperties = flywayProperties;
	}
	
    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(this.dataSourceProperties.getDriverClassName());
        dataSource.setUrl(this.dataSourceProperties.getJdbcUrl()
        		.concat("/")
        		.concat(this.dataSourceProperties.getSchema()));
        dataSource.setUsername(this.dataSourceProperties.getUsername());
        dataSource.setPassword(this.dataSourceProperties.getPassword());

        return dataSource;
    }
    
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	@PostConstruct
	public void migrate() {
		Flyway flyway = Flyway.configure()
				.locations(this.flywayProperties.getLocation())
				.dataSource(this.dataSourceProperties.getJdbcUrl()
		        		.concat("/")
		        		.concat(this.dataSourceProperties.getSchema()), 
		        		this.dataSourceProperties.getUsername(), 
		        		this.dataSourceProperties.getPassword())
				.load();
		flyway.migrate();
	}

}
