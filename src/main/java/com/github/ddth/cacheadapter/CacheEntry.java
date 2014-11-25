package com.github.ddth.cacheadapter;

import java.io.Serializable;

/**
 * Encapsulates a cache item with extra functionality.
 * 
 * @author Thanh Ba Nguyen <btnguyen2k@gmail.com>
 * @since 0.1.0
 */
public class CacheEntry implements Serializable {

    private static final long serialVersionUID = "0.1.0".hashCode();

    private String key;
    private Object value;
    private long creationTimestampMs = System.currentTimeMillis(), lastAccessTimestampMs = System
            .currentTimeMillis(), expireAfterWrite = -1, expireAfterAccess = -1;

    private void _init() {
        creationTimestampMs = System.currentTimeMillis();
        lastAccessTimestampMs = System.currentTimeMillis();
        expireAfterWrite = -1;
        expireAfterAccess = -1;
    }

    public CacheEntry() {
        _init();
    }

    public CacheEntry(String key, Object value) {
        _init();
        setKey(key);
        setValue(value);
    }

    public CacheEntry(String key, Object value, long expireAfterWrite, long expireAfterAccess) {
        _init();
        setKey(key);
        setValue(value);
        setExpireAfterAccess(expireAfterAccess);
        setExpireAfterWrite(expireAfterWrite);
    }

    public boolean isExpired() {
        if (expireAfterWrite > 0) {
            return creationTimestampMs + expireAfterWrite * 1000L > System.currentTimeMillis();
        }
        if (expireAfterAccess > 0) {
            return lastAccessTimestampMs + expireAfterAccess * 1000L > System.currentTimeMillis();
        }
        return false;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        if (!isExpired()) {
            touch();
            return value;
        }
        return null;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public long getExpireAfterWrite() {
        return expireAfterWrite;
    }

    public void setExpireAfterWrite(long expireAfterWriteSeconds) {
        this.expireAfterWrite = expireAfterWriteSeconds;
    }

    public long getExpireAfterAccess() {
        return expireAfterAccess;
    }

    public void setExpireAfterAccess(long expireAfterAccessSeconds) {
        this.expireAfterAccess = expireAfterAccessSeconds;
    }

    public long getCreationTimestamp() {
        return creationTimestampMs;
    }

    public long getLastAccessTimestamp() {
        return lastAccessTimestampMs;
    }

    /**
     * "Touch" the cache entry.
     * 
     * @return
     * @since 0.2.1 entry can be touched only if {@code expireAfterAccess >0}.
     */
    public boolean touch() {
        if (expireAfterAccess > 0) {
            lastAccessTimestampMs = System.currentTimeMillis();
            return true;
        }
        return false;
    }

}
