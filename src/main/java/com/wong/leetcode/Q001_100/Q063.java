package com.wong.leetcode.Q001_100;

public class Q063 {

	//动态规划
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0; //如果当前点是障碍点，则到此点的路径为零
				} else {
					if (i == 0 || j == 0) {
						//在边线上时，路径上不能有障碍点，同时，如果自己的上一个也不可达的话，那当前点也不可达
						if ((i > 0 && (obstacleGrid[i - 1][j] == 1 || dp[i-1][j] == 0)) || (j > 0 && (obstacleGrid[i][j-1] == 1 || dp[i][j-1]==0))) {
							dp[i][j] = 0;
						} else {
							dp[i][j] = 1;
						}
					} else {
						dp[i][j] = dp[i-1][j] + dp[i][j-1];
					}
				}
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int[][] obstacleGrid = new int[][] { 
			{ 0, 1, 0,0,0 }, 
			{ 0, 0, 0,0,0 }, 
			{ 1, 0, 0 ,0,0},
			{ 0, 0, 0 ,0,0}
			}; // [[1, 0, 1], [1, 0, 1], [1, 1,
																						// 2]]
		System.out.println(new Q063().uniquePathsWithObstacles(obstacleGrid));
	}

}
