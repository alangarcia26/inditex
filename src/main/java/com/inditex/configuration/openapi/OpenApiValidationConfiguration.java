package com.inditex.configuration.openapi;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.atlassian.oai.validator.OpenApiInteractionValidator;
import com.atlassian.oai.validator.springmvc.OpenApiValidationFilter;
import com.atlassian.oai.validator.springmvc.OpenApiValidationInterceptor;

@Configuration
public class OpenApiValidationConfiguration implements WebMvcConfigurer {
	
	@Value("${openapi.validate.request}")
	private Boolean validateRequest;
	
	@Value("${openapi.validate.response}")
	private Boolean validateResponse;
	
    private final OpenApiValidationInterceptor validationInterceptor;
    
    public OpenApiValidationConfiguration() throws IOException {
        this.validationInterceptor = new OpenApiValidationInterceptor(
        		OpenApiInteractionValidator.createFor("/api/openapi.json")
        		.build());
    }
    
    @Bean
    public OpenApiValidationFilter validationFilter() {
        return new OpenApiValidationFilter(this.validateRequest, this.validateResponse);
    }
    
    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(this.validationInterceptor);
    }
    
}
