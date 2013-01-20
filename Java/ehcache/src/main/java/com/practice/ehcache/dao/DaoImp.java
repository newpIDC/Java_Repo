package com.practice.ehcache.dao;

import com.practice.ehcache.CacheWrapper;

public class DaoImp<K,V> implements Dao<K,V>{

	protected CacheWrapper<K, V> cache;	
	
	public CacheWrapper<K, V> getCache( ) {
		return cache;
	}

	public void setCache( CacheWrapper<K, V> cache ) {
		this.cache = cache;
	}


	public V getPersonNamebyId( final K id ) {
		V value;
	    if ((value = cache.get(id)) == null) {
	       // value = this.jdbcTemplate.queryForObject(findById, mapper, id);
	        if (value != null) {
	        cache.put(id, value);
	        }
	    }
	    return value;
	}

}
