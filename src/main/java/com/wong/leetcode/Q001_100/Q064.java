package com.wong.leetcode.Q001_100;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入: [ [1,3,1], [1,5,1], [4,2,1] ] 输出: 7 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q064 {
	/*假设有m * n 格
	 * S(m,n) = grid(m,n) + min(s(m-1,n),s(m,n-1))
	 * 以下是动态规划
	 */
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		//初始化两条边线
		for(int i=1;i<m;i++) {
			dp[i][0] = grid[i][0] + dp[i-1][0];
		}
		for(int i=1;i<n;i++) {
			dp[0][i] = grid[0][i] + dp[0][i-1];
		}
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[m-1][n-1];
	}

	public static void main(String[] args) {
		int[][] res = new int[][] {
			{1,3,2},
			{1,5,1},
			{4,2,1}
		};
		System.out.println(new Q064().minPathSum(res));
	}

}
