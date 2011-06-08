package com.martinsikora.junit;


import junit.framework.TestCase;

import org.junit.After;
import org.junit.Test;

import com.martinsikora.BigInteger;

public class DivisorsTest extends TestCase {

    @Test
    public void testSmallNumbers() {
    	assertEquals(6, BigInteger.divisors(28).length);
    	assertEquals(3, BigInteger.divisors(25).length);
    }
    
    @Test
    public void testLargeNumbers() {
    	assertEquals(576, BigInteger.divisors(76576500).length);
    }
    
	
    @After
    public void tearDown() {
        System.out.println("Cycles: " + BigInteger.cycles);
        BigInteger.cycles = 0;
    }

}
