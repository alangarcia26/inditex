package com.inditex.app;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class GetCalls<T> {
	
	private String url;
	private Class<T> classType;
	private TestRestTemplate restTemplate;
	
	public GetCalls(String url, Class<T> classType) {
		this.url = url;
		this.classType = classType;
		this.restTemplate = new TestRestTemplate();
	}
	
	public ResponseEntity<T> call(){
		return exchange(new HttpEntity<>(null, null));
	}
	
	private ResponseEntity<T> exchange(HttpEntity<String> request){
		return this.restTemplate.exchange(
                this.url,
                HttpMethod.GET, 
                request, 
                this.classType);
	}

}
