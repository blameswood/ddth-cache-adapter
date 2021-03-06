package com.github.ddth.cacheadapter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Cache statistics
 * 
 * @author Thanh Ba Nguyen <btnguyen2k@gmail.com>
 * @since 0.1.0
 */
public class CacheStats {

    private AtomicLong numHits = new AtomicLong(0), numMisses = new AtomicLong(0);

    public CacheStats() {
    }

    /**
     * Fires a cache miss event.
     * 
     * @return
     */
    protected long miss() {
        return numMisses.incrementAndGet();
    }

    /**
     * Fires a cache hit event.
     * 
     * @return
     */
    protected long hit() {
        return numHits.incrementAndGet();
    }

    /**
     * Returns total number of cache misses.
     * 
     * @return
     */
    public long numHits() {
        return numHits.longValue();
    }

    /**
     * Returns total number of cache hits.
     * 
     * @return
     */
    public long numMisses() {
        return numMisses.longValue();
    }
}
