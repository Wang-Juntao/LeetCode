package com.wong.leetcode.Q001_100;

public class Q010 {
	/**
	 * 第一版 无法解决类似 a*a  .*abc 一类的正则式，会返回错误结果
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		if(p.indexOf("*") < 0 && p.indexOf(".") < 0) {
			return s.equals(p);
		}
		if(p.equals(".*")) {
			return true;
		}
		int pidx = 0;
		int sidx = 0;
		while (pidx < p.length() && sidx < s.length()) {
			char cp = p.charAt(pidx);
			if (pidx < p.length() - 1 && p.charAt(pidx + 1) == '*') {
				// a*  or .* 
				while (sidx < s.length() && (s.charAt(sidx) == cp || cp == '.')) {
					sidx++;
				}
				pidx = pidx + 2;
			} else if (cp == '.' || s.charAt(sidx) == p.charAt(pidx)) {
				sidx++;
				pidx++;
			} else {
				return false;
			}
		}
		return sidx == s.length() && pidx == p.length();
	}
	

	/**
	 * 	动态规划资料:http://www.sohu.com/a/153858619_466939
	 * 	关键点：最优子结构、边界、转台转换公式
	 *  
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch_Dp(String s, String p) {
		s = "#" + s;
		p = "#" + p;
		boolean[][] dp = new boolean[s.length()][p.length()];
		dp[0][0] = true;
		for(int j = 2;j<p.length();++j) {
			dp[0][j] = p.charAt(j)=='*' && dp[0][j-2];
		}
		for(int i=1;i<s.length();++i) {
			for(int j=1;j<p.length();++j) {
				if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
					dp[i][j] = dp[i-1][j-1];
				}else if(p.charAt(j) == '*') {
					if(p.charAt(j-1) == '.' || s.charAt(i) == p.charAt(j-1)) {
						dp[i][j] = dp[i][j-1] || dp[i-1][j] || (j>=2 && dp[i][j-2]);
					}else {
						dp[i][j] = dp[i][j-2];
					}
				}
			}
		}
//		for(boolean[] line : dp) {
//			for(boolean b : line) {
//				System.out.print(b+"\t");
//			}
//			System.out.println();
//		}
		return dp[s.length()-1][p.length()-1];
	}
	

	
	public static boolean isMatch_sys(String s, String p) {
		return s.matches(p);
	}
	
	
	public static void main(String[] args) {
//		System.out.println(isMatch_Dp("dfsdfdsfsdabc",".*a*abc"));
//		System.out.println(isMatch_Dp("aa","a*aaa*"));
		System.out.println(isMatch_Dp("abde","a*b*c*d*e*"));
		System.out.println(isMatch_sys("",".*abc"));
	}

}
