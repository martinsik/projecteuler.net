package com.martinsikora;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem18 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		InputStream stream = Problem18.class.getResourceAsStream("/com/martinsikora/resources/triangle.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		
		// load triangle
		String line;
		int[][] triangle = new int[15][];
		int index = 0;
		
		while ((line = reader.readLine()) != null) {
			int lineIndex = 15 - index - 1;
			String[] nums = line.split(" ");
			triangle[lineIndex] = new int[nums.length];
			for (int i=0; i < nums.length; i++) {
				triangle[lineIndex][i] = Integer.parseInt(nums[i]);
			}
			index++;
		}
		
		
		
		
	}

}
