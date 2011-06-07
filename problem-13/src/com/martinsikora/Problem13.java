package com.martinsikora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem13 {
	
	public static void main(String[] args) throws IOException {
		InputStream stream = Problem13.class.getResourceAsStream("/resource/input.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		
		String line, num = "0";
		while ((line = reader.readLine()) != null) {
			num = BigInteger.sum(new String(num), line);
		}
		
		System.out.println("Total sum: " + num);
		System.out.println("First 10: " + num.substring(0, 10));
		System.out.println("Cycles: " + BigInteger.cycles);
	}
}
