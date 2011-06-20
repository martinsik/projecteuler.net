package com.martinsikora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Problem22 {

	protected static TreeSet<String> list = new TreeSet<String>();
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStream stream = Problem22.class.getResourceAsStream("/com/martinsikora/resources/names.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		
		String line = reader.readLine();
		List<String> list = Arrays.asList(line.split(","));
		Collections.sort(list);
		
		long total = 0;
		int pos = 1;
		for (String name : list) {
			name = name.substring(1, name.length() - 1);
			total += nameWeight(name) * pos++;
		}
		
		System.out.println("Total: " + total);
		
	}
	
	protected static int nameWeight(String name) {
		int sum = 0;
		for (int i=0; i<name.length(); i++) {
			sum += (byte) name.charAt(i) - 'A' + 1;
		}
		return sum;
	}

}
