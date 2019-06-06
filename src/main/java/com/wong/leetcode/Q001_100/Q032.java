package com.wong.leetcode.Q001_100;

import java.util.Arrays;

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
	// dp 有bug 部分情况下可以得出结果
	public int longestValidParentheses(String s) {
		int length = s.length();
		if (length < 1) {
			return 0;
		}
		boolean[][] dp = new boolean[length][length];
		int maxLength = 0;
		int begain = 0;
		for (int j = 0; j < length; j++) {
			for (int i = j; i >= 0; i--) {
				if ((j - i + 1) % 2 == 0) {
					if (s.charAt(i) == '(' && s.charAt(j) == ')') {
						if (j - i < 2) {
							dp[i][j] = true;
							System.out.println(String.format("dp[%d][%d]默认为true", i, j));
						} else {
							dp[i][j] = dp[i + 1][j - 1];
							System.out
									.println(String.format("dp[%d][%d]=%b,推导公式dp[i][j] = dp[i + 1][j - 1](dp[%d][%d])",
											i, j, dp[i][j], i + 1, j - 1));
						}
					}
					if (j - i > 2) {
						if (i + 2 < length && s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
							dp[i][j] = dp[i + 2][j];
							System.out.println(String.format("dp[%d][%d]=%b,推导公式dp[i][j] = dp[i + 2][j](dp[%d][%d])", i,
									j, dp[i][j], i + 2, j));
						}
						if (j - 2 > 0 && s.charAt(j) == ')' && s.charAt(j - 1) == '(') {
							dp[i][j] = dp[i][j - 2];
							System.out.println(String.format("dp[%d][%d]=%b,推导公式dp[i][j] = dp[i][j - 2](dp[%d][%d])", i,
									j, dp[i][j], i, j - 2));
						}
					}
				} else {
					System.out.println(String.format("dp[%d][%d]默认为false,非偶数", i, j));
					dp[i][j] = false;
				}
				if (dp[i][j] && j - i + 1 > maxLength) {
					maxLength = j - i + 1;
					begain = i;
				}
			}
		}
		System.out.println(begain);
		return maxLength;
	}

	// 巨慢
	public int longestValidParentheses_v2(String s) {
		int length = s.length();
		if (length < 1) {
			return 0;
		}
		int maxLength = 0;
		for (int i = 0; i < s.length(); ++i) {
			int count = 0;
			for (int j = i; j < s.length(); ++j) {
				if (s.charAt(j) == '(') {
					count++;
				} else {
					count--;
				}
				if (count < 0) {
					break;
				}
				if (count == 0 && j - i + 1 > maxLength) {
					maxLength = j - i + 1;
				}
			}
		}
		return maxLength;
	}

	public int longestValidParentheses_v3(String s) {
		int maxans = 0;
		int dp[] = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
				maxans = Math.max(maxans, dp[i]);
			}
		}
		Arrays.stream(dp).forEach(x->System.out.print(x+"\t"));
		return maxans;
	}

	public static void main(String[] args) {
//		String s = ")(((((()())()()))()(()))(";
		String s = "((((()())()()))()(()))";
//		String s = "(()";
		System.out.println(new Q032().longestValidParentheses_v3(s));
	}

}
