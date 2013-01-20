package com.practice.ehcache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class EhCacheWrapper<K, V> implements CacheWrapper<K, V> 
{
    private String cacheName = "sampleCache1";
    private CacheManager cacheManager = CacheManager.getInstance();
    
    public EhCacheWrapper(){
    	
    }
    
    public EhCacheWrapper(final String cacheName, final CacheManager cacheManager) {
    	this.cacheName = cacheName;
    	this.cacheManager = cacheManager;
    }
    
    public void put(final K key, final V value) {
    	getCache().put(new Element(key, value));
    }
    
    public V get(final K key) {
    	Element element = getCache().get(key);
    	if (element != null) {
    		return (V) element.getValue();
    	}
    	return null;
    }
    
    public Ehcache getCache() {
    	return cacheManager.getEhcache(cacheName);
    }
    
	
}