package com.martinsikora.junit;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Test;

import com.martinsikora.BigInteger;


public class MultiplyTest extends TestCase {

    @Test
    public void testSmallNumbers() {
        assertEquals("128826", BigInteger.multiply("153", "842"));
    }
    
    @Test
    public void testLargeNumbers() {
        assertEquals("21229213856449358", BigInteger.multiply("6453154", "3289742327"));
    }
    
    @Test
    public void testZeroNumber() {
    	assertEquals("0", BigInteger.multiply("0", "528927"));
    }
    
    @Test
    public void testZeroNumber2() {
    	assertEquals("0", BigInteger.multiply("9846", "0"));
    }
    
    @After
    public void tearDown() {
        System.out.println("Cycles: " + BigInteger.cycles);
        BigInteger.cycles = 0;
    }
	
}
