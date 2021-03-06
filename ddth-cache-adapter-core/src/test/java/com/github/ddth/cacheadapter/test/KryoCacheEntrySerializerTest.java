package com.github.ddth.cacheadapter.test;

import org.junit.After;
import org.junit.Before;

import com.github.ddth.cacheadapter.ces.KryoCacheEntrySerializer;

import junit.framework.Test;
import junit.framework.TestSuite;

public class KryoCacheEntrySerializerTest extends BaseTest {

    public KryoCacheEntrySerializerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(KryoCacheEntrySerializerTest.class);
    }

    @Before
    public void setUp() {
        cacheEntrySerializer = KryoCacheEntrySerializer.instance;
    }

    @After
    public void tearDown() {
    }
}
