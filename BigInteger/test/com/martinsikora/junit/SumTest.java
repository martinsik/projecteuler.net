package com.martinsikora.junit;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Test;

import com.martinsikora.BigInteger;


public class SumTest extends TestCase {

    @Test
    public void testSmallNumbers() {
        assertEquals("995", BigInteger.sum("153", "842"));
    }
    
    @Test
    public void testLargeNumbers() {
        assertEquals("3296195481", BigInteger.sum("6453154", "3289742327"));
    }
    
    @Test
    public void testCarry() {
        assertEquals("1095", BigInteger.sum("153", "942"));
    }
    
    @Test
    public void testZeroNumber() {
    	assertEquals("528927", BigInteger.sum("0", "528927"));
    }
    
    @Test
    public void testZeroNumber2() {
    	assertEquals("9846", BigInteger.sum("9846", "0"));
    }
    
    @After
    public void tearDown() {
        System.out.println("Cycles: " + BigInteger.cycles);
        BigInteger.cycles = 0;
    }
	
}
