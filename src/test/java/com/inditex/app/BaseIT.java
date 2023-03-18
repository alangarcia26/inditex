package com.inditex.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.controller.exception.HttpErrorCodes;
import com.inditex.controller.exception.InvalidParamExceptionResponse;

@SpringBootTest(classes = InditexApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public abstract class BaseIT {
	
	@LocalServerPort 
	private int port;
    
	@Autowired
	protected ObjectMapper mapper;
	
	protected <T> T readObjectFromJson(String jsonPath, Class<T> type) throws IOException {
		Path path = Paths.get(jsonPath);
		byte[] content = Files.readAllBytes(path);
		return mapper.readValue(content, type);
	}
	
	protected <T> GetCalls<T> newGet(String uri, Class<T> classType) {
		return new GetCalls<T>(url(uri), classType);
	}
	
	@SuppressWarnings("rawtypes") 
	protected void assertOk(ResponseEntity response) {
		assertNotNull(response);
		
		Integer statusExpected = 200;
		Integer statusActual = response.getStatusCodeValue();
		
		assertEquals(statusExpected, statusActual);
	}
	
	@SuppressWarnings("rawtypes") 
	protected void assertNoContent(ResponseEntity response) {
		assertNotNull(response);
		
		Integer statusExpected = 204;
		Integer statusActual = response.getStatusCodeValue();

		assertNull(response.getBody());
		assertEquals(statusExpected, statusActual);
	}
	
	protected void assertInvalidParamException(InvalidParamExceptionResponse expected, ResponseEntity<InvalidParamExceptionResponse> response) {
		assertNotNull(response);
		
		Integer statusExpected = HttpErrorCodes.INVALID_PARAM_ERROR.getCode();
		Integer statusActual = response.getStatusCodeValue();
		
		assertEquals(statusExpected, statusActual);
		
		InvalidParamExceptionResponse actual = response.getBody();
		assertNotNull(actual.getDatetime());
		assertEquals(expected.getService(), actual.getService());
		assertEquals(expected.getMessage(), actual.getMessage());
		assertEquals(expected.getParamName(), actual.getParamName());
		assertEquals(expected.getParamValue(), actual.getParamValue());
	}
	
    private String url(String uri) {
        return "http://localhost:" + port + "/inditex" + uri;
    }

}
