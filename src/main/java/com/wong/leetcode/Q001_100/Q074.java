package com.wong.leetcode.Q001_100;

public class Q074 {

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null) {
			return false;
		}
		int m = matrix.length;
		if(m == 0) {
			return false;
		}
		int n = matrix[0].length;
		if(n==0) {
			return false;
		}
		int row = 0;
		while(row < m && matrix[row][0] <= target) {
			if(matrix[row][n-1]>= target) break;
			row ++;
		}
		if(row == m || matrix[row][0] > target) {
			return false;
		}
		int pos = 0;
		while(pos < n && matrix[row][pos] <= target) {
			if(matrix[row][pos] == target) return true;
			pos++;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
		};
		System.out.println(new Q074().searchMatrix(matrix, 0));
	}

}
