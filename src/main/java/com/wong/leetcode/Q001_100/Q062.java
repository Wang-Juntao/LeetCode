package com.wong.leetcode.Q001_100;

import java.util.HashMap;
import java.util.Map;

/**
 * 62. 不同路径 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 问总共有多少条不同的路径？
 * 
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * 
 * 说明：m 和 n 的值均不超过 100。
 * 
 * 示例 1:
 * 
 * 输入: m = 3, n = 2 输出: 3 解释: 从左上角开始，总共有 3 条路径可以到达右下角。 1. 向右 -> 向右 -> 向下 2. 向右
 * -> 向下 -> 向右 3. 向下 -> 向右 -> 向右
 * 
 * 示例 2:
 * 
 * 输入: m = 7, n = 3 输出: 28
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Q062 {

	Map<String, Integer> map = new HashMap<String, Integer>();
	
	public int uniquePaths(int m, int n) {
		String key = m + "," + n;
		//对于m<=1 或 n<=1的情况，我们可以很容易得出结果
		if (m < 1 || n < 1) {
			return 0;
		}
		if (m == 1 || n == 1) {
			return 1;
		}
		if (map.containsKey(key)) { //map用来记录一些计算的值，防止重复计算
			return map.get(key);
		}
		//对于其他情况，我们可以选择先向下或者先向右走，
		//每一个分支都是同样的不同路径问题，最终得到一个推导公式：s(m,n) = s(m-1,n) + s(m,n-1);
		int res = uniquePaths(m-1,n) + uniquePaths(m,n-1);
		map.put(key, res);
		return res;
	}
	//得到推导公式后，可以完全是标准的动态规划的模版算法，自然可以用动态规划的思路解题
	public int uniquePaths_dp(int m, int n) {
		int[][] dp = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0 || j==0) {
					dp[i][j] = 1;
				}else {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
		}
		return dp[m-1][n-1];
	}

//	public long group(int m, int n) {
//		String key = m + "," + n;
//		if (map.containsKey(key)) {
//			return map.get(key);
//		}
//		if (n == 0)
//			return 1;
//		if (n == 1)
//			return m;
//		if (n > m / 2)
//			return group(m, m - n);
//		long res = group(m - 1, n - 1) + group(m - 1, n);
//		map.put(key, res);
//		return res;
//	}

	/*
	 * 求解将n分为m个数的和，不能重复 S(n,m) = S(n-1,m-1) + S(n-m,m)
	 */
	public long mtox(int n, int m) {
		if (n < m) {
			return 0;
		}
		if (m == 1) {
			return 1;
		}
		if (n == m) {
			return 1;
		}
		return mtox(n - 1, m - 1) + mtox(n - m, m);
	}

	public static void main(String[] args) {
		System.out.println(new Q062().uniquePaths_dp(3, 4));
//		System.out.println(new Q062().mtox(55, 20));
	}

}
