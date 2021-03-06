package com.github.ddth.cacheadapter;

/**
 * Factory to create {@link ICache} instance.
 * 
 * @author Thanh Ba Nguyen <btnguyen2k@gmail.com>
 * @since 0.1.0
 */
public interface ICacheFactory {

    public final static long DEFAULT_CACHE_CAPACITY = 1000;
    public final static long DEFAULT_EXPIRE_AFTER_WRITE = 1800;
    public final static long DEFAULT_EXPIRE_AFTER_ACCESS = 1800;

    /**
     * Creates a cache with default capacity and options. This method returns
     * the existing cache if such exists.
     * 
     * @param name
     * @return
     */
    public ICache createCache(String name);

    /**
     * Creates a cache with default capacity and option, and specify a cache
     * loader. This method returns the existing cache if such exists.
     * 
     * @param name
     * @param cacheLoader
     * @return
     * @since 0.2.0
     */
    public ICache createCache(String name, ICacheLoader cacheLoader);

    /**
     * Creates a cache with default options. This method returns the existing
     * cache if such exists.
     * 
     * @param name
     * @param capacity
     * @return
     */
    public ICache createCache(String name, long capacity);

    /**
     * Creates a cache with default options, and specify a cache loader. This
     * method returns the existing cache if such exists.
     * 
     * @param name
     * @param capacity
     * @param cacheLoader
     * @return
     * @since 0.2.0
     */
    public ICache createCache(String name, long capacity, ICacheLoader cacheLoader);

    /**
     * Creates a cache. This method returns the existing cache if such exists.
     * 
     * @param name
     *            name of the cache to create
     * @param capacity
     *            long cache's maximum number of entries
     * @param expireAfterWrite
     *            expire entries after the specified number of seconds has
     *            passed since the entry was created
     * @param expireAfterAccess
     *            expire entries after the specified number of seconds has
     *            passed since the entry was last accessed by a read or a write
     * @return
     */
    public ICache createCache(String name, long capacity, long expireAfterWrite,
            long expireAfterAccess);

    /**
     * Creates a cache with specified cache loader. This method returns the
     * existing cache if such exists.
     * 
     * @param name
     * @param capacity
     * @param expireAfterWrite
     * @param expireAfterAccess
     * @param cacheLoader
     * @return
     */
    public ICache createCache(String name, long capacity, long expireAfterWrite,
            long expireAfterAccess, ICacheLoader cacheLoader);

    /**
     * Removes an existing cache from the factory.
     * 
     * @param name
     */
    public void removeCache(String name);
}
