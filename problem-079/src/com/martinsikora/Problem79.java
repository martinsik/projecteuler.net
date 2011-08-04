package com.martinsikora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem79 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStream stream = Problem79.class.getResourceAsStream("/com/martinsikora/resources/keylog.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		int[] attempts = new int[10];
		int[] poss = new int[10];
		
		String line;
		while ((line = reader.readLine()) != null) {
			for (int i=0; i < line.length(); i++) {
				int num = Integer.parseInt(line.substring(i, i+1));
				attempts[num]++;
				poss[num] += i;
			}
		}

		for (int i=0; i < poss.length; i++) {
			System.out.println(i + ": " + (attempts[i] > 0 ? (float) poss[i] / attempts[i] : 0));
		}
		// sort by most typical occurance and skip 4 and 5
		// 73162890
	}

}
