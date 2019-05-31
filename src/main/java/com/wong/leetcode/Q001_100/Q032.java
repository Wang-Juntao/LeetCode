package com.wong.leetcode.Q001_100;

/**
 * 32. 最长有效括号 (难度：困难)
 * 
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * 示例 1:
 * 
 * 输入: "(()" 输出: 2 解释: 最长有效括号子串为 "()"
 * 
 * 示例 2:
 * 
 * 输入: ")()())" 输出: 4 解释: 最长有效括号子串为 "()()"
 * 
 */
public class Q032 {
	//dp 有bug 部分情况下可以得出结果
	public int longestValidParentheses(String s) {
		int length = s.length();
		if (length < 1) {
			return 0;
		}
		boolean[][] dp = new boolean[length][length];
		int maxLength = 0;
		for (int j = 0; j < length; j++) {
			for (int i = 0; i <= j; i++) {
				if ((j - i + 1) % 2 == 0) {
					if (s.charAt(i) == '(' && s.charAt(j) == ')') {
						if (j - i < 2) {
							dp[i][j] = true;
							System.out.println(String.format("dp[%d][%d]默认为true", i,j));
						} else {
							dp[i][j] = dp[i + 1][j - 1];
							System.out.println(String.format("dp[%d][%d]=%b,推导公式dp[i][j] = dp[i + 1][j - 1](dp[%d][%d])", i,j,dp[i][j],i+1,j-1));
						}
					}
					if (j - i > 2) {
						if (i + 2 < length && s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
							dp[i][j] = dp[i + 2][j];
							System.out.println(String.format("dp[%d][%d]=%b,推导公式dp[i][j] = dp[i + 2][j](dp[%d][%d])", i,j,dp[i][j],i+2,j));
						}
						if (j - 2 > 0 && s.charAt(j) == ')' && s.charAt(j - 1) == '(') {
							dp[i][j] = dp[i][j - 2];
							System.out.println(String.format("dp[%d][%d]=%b,推导公式dp[i][j] = dp[i][j - 2](dp[%d][%d])", i,j,dp[i][j],i,j-2));
						}
					}
				} else {
					dp[i][j] = false;
				}
				if (dp[i][j] && j - i + 1 > maxLength) {
					maxLength = j - i + 1;
				}
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
//		String s = "(())()";
		String s = "()(())()";
		System.out.println(new Q032().longestValidParentheses(s));
	}

}
