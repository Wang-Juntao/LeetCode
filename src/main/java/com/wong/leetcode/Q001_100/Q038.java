package com.wong.leetcode.Q001_100;

/**
 * 38. 报数(难度：简单) 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 
 * 1. 1 2. 11 3. 21 4. 1211 5. 111221
 * 
 * 1 被读作 "one 1" ("一个一") , 即 11。 11 被读作 "two 1s" ("两个一"）, 即 21。 21 被读作 "one 2",
 * "one 1" （"一个二" , "一个一") , 即 1211。
 * 
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 
 * 注意：整数顺序将表示为一个字符串。
 * 
 * 示例 1:
 * 
 * 输入: 1 输出: "1"
 * 
 * 示例 2:
 * 
 * 输入: 4 输出: "1211"
 * 
 */
public class Q038 {

	/*
	 * 	
	 * 	简单来说第n项是第n-1项的一种读法 
	 * 	这种读法是将一段连续相同的数字作为一个整体读 ，
	 * 	比如 1111 应该被读作41，222应该被读作32（数量+原数字）
	 * 	ps.这其实已经是一种字符串压缩算法了
	 */
	public String countAndSay(int n) {
		String s = "1";
		for (int i = 1; i < n; ++i) {
			StringBuffer sb = new StringBuffer();
			for (int k = 0; k < s.length(); ++k) {
				int count = 1;
				while (k < s.length() - 1 && s.charAt(k) == s.charAt(k + 1)) {
					count++;
					k++;
				}
				sb.append(count);
				sb.append(s.charAt(k));
			}
			s = sb.toString();
		}
		return s;
	}

	public static void main(String[] args) {
		String s = new Q038().countAndSay(4);
		System.out.println(s.length());
		System.out.println(s);
	}

}
