package com.inditex.domain;

public interface FindRepository {
	
	<T> T find(String table, Object id, Class<T> type);

}
