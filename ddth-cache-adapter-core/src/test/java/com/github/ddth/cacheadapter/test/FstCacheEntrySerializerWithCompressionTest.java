package com.github.ddth.cacheadapter.test;

import org.junit.After;
import org.junit.Before;

import com.github.ddth.cacheadapter.ces.FstCacheEntrySerializer;
import com.github.ddth.cacheadapter.compressor.JdkDeflateCompressor;

import junit.framework.Test;
import junit.framework.TestSuite;

public class FstCacheEntrySerializerWithCompressionTest extends BaseTest {

    public FstCacheEntrySerializerWithCompressionTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(FstCacheEntrySerializerWithCompressionTest.class);
    }

    @Before
    public void setUp() {
        cacheEntrySerializer = new FstCacheEntrySerializer()
                .setCompressor(JdkDeflateCompressor.instance);
    }

    @After
    public void tearDown() {
    }
}
