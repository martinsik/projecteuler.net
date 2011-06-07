package com.martinsikora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		long cycles = 0;
		int max = 0;
		int product = 0;
		
		/**
		 * load grid
		 */
		InputStream stream = Problem11.class.getResourceAsStream("/com/martinsikora/resource/input.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		
		String line;
		int i=0;
		byte grid[][] = new byte[20][20];
		while ((line = reader.readLine()) != null) {
			String[] lineArray = line.split(" ");
			for (int j = 0; j < lineArray.length; j++) {
				grid[i][j] = Byte.parseByte(lineArray[j]);
			}
			i++;
		}
		
		/**
		 * top - down
		 */
		for (int j = 0; j <= grid.length - 4; j++) {
			for (int k = 0; k < grid[j].length; k++) {
				cycles++;
				product = grid[j][k] * grid[j+1][k] * grid[j+2][k] * grid[j+3][k];
				if (product > max) {
					max = product;
				}
			}
		}
		
		/**
		 * left - right
		 */
		for (int j = 0; j < grid.length; j++) {
			for (int k = 0; k <= grid[j].length - 4; k++) {
				cycles++;
				product = grid[j][k] * grid[j][k+1] * grid[j][k+2] * grid[j][k+3];
				if (product > max) {
					max = product;
				}
			}
		}
		
		/**
		 * diagonal
		 */
		product = 0;
		for (int j = 0; j < grid.length; j++) {
			for (int k = 0; k < grid[j].length; k++) {
				if (j-3 >= 0 && k-3 >=0) {
					cycles++;
					product = grid[j-3][k-3] * grid[j-2][k-2] * grid[j-1][k-1] * grid[j][k];
					max = Math.max(max, product);
				}
				
				if (j-3 >= 0 && k+3 < 20) {
					cycles++;
					product = grid[j-3][k+3] * grid[j-2][k+2] * grid[j-1][k+1] * grid[j][k];
					max = Math.max(max, product);
				}
				
				if (j+3 < 20 && k-3 >= 0) {
					cycles++;
					product = grid[j+3][k-3] * grid[j+2][k-2] * grid[j+1][k-1] * grid[j][k];
					max = Math.max(max, product);
				}

				if (j+3 < 20 && k+3 < 20) {
					cycles++;
					product = grid[j+3][k+3] * grid[j+2][k+2] * grid[j+1][k+1] * grid[j][k];
					max = Math.max(max, product);
				}
			}
		}
		
		System.out.println("Max product: " + max);
		System.out.println("Cycles: " + cycles);
	}

}
