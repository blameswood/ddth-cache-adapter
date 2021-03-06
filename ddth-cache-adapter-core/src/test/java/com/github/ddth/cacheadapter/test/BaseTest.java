package com.github.ddth.cacheadapter.test;

import com.github.ddth.cacheadapter.CacheEntry;
import com.github.ddth.cacheadapter.ICacheEntrySerializer;
import com.github.ddth.cacheadapter.qnd.TestValue;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public abstract class BaseTest extends TestCase {

    public BaseTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(BaseTest.class);
    }

    protected static ICacheEntrySerializer cacheEntrySerializer;

    @org.junit.Test
    public void testBaseClass() {
        CacheEntry ce = new CacheEntry("key", new TestValue.BaseClass());
        byte[] data = cacheEntrySerializer.serialize(ce);
        assertNotNull(data);

        Object ceBack = cacheEntrySerializer.deserialize(data);
        assertFalse(ce == ceBack);
        assertTrue(ce.equals(ceBack));
    }

    @org.junit.Test
    public void testAClass() {
        CacheEntry ce = new CacheEntry("key", new TestValue.AClass());
        byte[] data = cacheEntrySerializer.serialize(ce);
        assertNotNull(data);

        Object ceBack = cacheEntrySerializer.deserialize(data);
        assertFalse(ce == ceBack);
        assertTrue(ce.equals(ceBack));
    }

    @org.junit.Test
    public void testBClass() {
        TestValue.BClass obj = new TestValue.BClass();
        obj.obj = new TestValue.BaseClass();

        CacheEntry ce = new CacheEntry("key", obj);
        byte[] data = cacheEntrySerializer.serialize(ce);
        assertNotNull(data);

        Object ceBack = cacheEntrySerializer.deserialize(data);
        assertFalse(ce == ceBack);
        assertTrue(ce.equals(ceBack));
    }

    @org.junit.Test
    public void testBClass2() {
        TestValue.BClass obj = new TestValue.BClass();
        obj.obj = new TestValue.AClass();

        CacheEntry ce = new CacheEntry("key", obj);
        byte[] data = cacheEntrySerializer.serialize(ce);
        assertNotNull(data);

        Object ceBack = cacheEntrySerializer.deserialize(data);
        assertFalse(ce == ceBack);
        assertTrue(ce.equals(ceBack));
    }
}
