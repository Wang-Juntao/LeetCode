package com.wong.leetcode.Q001_100;

import java.util.ArrayList;
import java.util.List;

public class Q054 {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
		if (matrix.length == 0)
			return ans;
		int r1 = 0, r2 = matrix.length - 1;
		int c1 = 0, c2 = matrix[0].length - 1;
		while (r1 <= r2 && c1 <= c2) {
			for (int c = c1; c <= c2; c++)
				ans.add(matrix[r1][c]);
			for (int r = r1 + 1; r <= r2; r++)
				ans.add(matrix[r][c2]);
			if (r1 < r2 && c1 < c2) {
				for (int c = c2 - 1; c > c1; c--)
					ans.add(matrix[r2][c]);
				for (int r = r2; r > r1; r--)
					ans.add(matrix[r][c1]);
			}
			r1++;
			r2--;
			c1++;
			c2--;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 6 }, { 2, 7 }, { 3, 8 }, { 4, 9 }, { 5, 10 } };
		List<Integer> res = new Q054().spiralOrder(matrix);
		res.forEach(x -> System.out.print(x + " "));
	}

}
