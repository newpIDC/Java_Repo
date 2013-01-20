package com.practice.ehcache.dao;

public interface Dao<K, V> {
	 V getPersonNamebyId(K k);
}
