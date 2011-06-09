package com.martinsikora.junit;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Test;

import com.martinsikora.BigInteger;

public class PowTest extends TestCase {
	
    @Test
    public void testSmallNumbers() {
    	assertEquals("1", BigInteger.pow(1, 1));
    	assertEquals("256", BigInteger.pow(2, 8));
    	assertEquals("32", BigInteger.pow(2, 5));
    }
    
    @Test
    public void testLargeNumbers() {
    	assertEquals("10000000000", BigInteger.pow(10, 10));
    	assertEquals("8916100448256", BigInteger.pow(12, 12));
    	assertEquals("1267650600228229401496703205376", BigInteger.pow(2, 100));
    	assertEquals("1900306380941594479763883944859394903933421733915497351026033862324967197615194912638195921621021097984", BigInteger.pow(58, 58));
    }
    
    @Test
    public void testVeryLargeNumbers() {
    	assertEquals("", BigInteger.pow(113, 113));
    }
    
    @After
    public void tearDown() {
        System.out.println("Cycles: " + BigInteger.cycles);
        BigInteger.cycles = 0;
    }
    
}
