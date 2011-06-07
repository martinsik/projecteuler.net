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
		int point[] = new int[2];
		
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
		int product2, product3, product4, product5, product6, product7, product8;
		for (int j = 0; j <= grid.length - 4; j++) {
			for (int k = 0; k <= grid[j].length - 4; k++) {
				cycles += 4;
				product = grid[j][k] * grid[j+1][k+1] * grid[j+2][k+2] * grid[j+3][k+3]; // top-left
				//product5 = grid[j][k] * grid[j-1][k+1] * grid[j-2][k+2] * grid[j-3][k+3];
				
				product4 = grid[j][19-k-3] * grid[j+1][19-k-2] * grid[j+2][19-k-1] * grid[j+3][19-k]; // top-right
				
				product2 = grid[19-j-3][k] * grid[19-j-2][k+1] * grid[19-j-1][k+2] * grid[19-j][k+3]; // bottom-left
				product3 = grid[19-j-3][19-k-3] * grid[19-j-2][19-k-2] * grid[19-j-1][19-k-1] * grid[19-j][19-k]; // bottom-right
				
				
				//product6 = grid[j][k] * grid[j-1][k+1] * grid[j-2][k+2] * grid[j-3][k+3];
				
				max = Math.max(max, Math.max(Math.max(product, product2), Math.max(product3, product4)));
				//max = Math.max(max, product5);
			}
		}
		
		System.out.println("Max: " + max);
		System.out.println("Cycles: " + cycles);
	}

}
