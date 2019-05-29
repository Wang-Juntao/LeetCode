package com.wong.leetcode.Q001_100;

public class Q009 {
	/**
	 * 字符串翻转，效率很低
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome_Basic(int x) {
		String xx = Integer.toString(x);
		return xx.equals(new StringBuilder(xx).reverse().toString());
	}

	/**
	 * 执行用时 : 44 ms, 在Palindrome Number的Java提交中击败了99.18% 的用户 
	 * 内存消耗 : 35.3 MB,在Palindrome Number的Java提交中击败了97.57% 的用户
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		} else if (x <= 9) {
			return true;
		} else {
			int reverse = 0;
			int xcopy = x;
			while (xcopy > 0) {
				int remainder = xcopy % 10;
				xcopy = xcopy / 10;
				reverse = reverse * 10 + remainder; // 其实这里会有溢出的可能，但刚好会溢出的肯定不是回文数
			}
			System.out.println(reverse);
			return reverse == x;
		}
	}

	/**
	 * 官方的答案，只翻转一半数字
	 * 执行用时 : 49 ms, 在Palindrome Number的Java提交中击败了96.82% 的用户
	 * 内存消耗 : 37.1 MB, 在Palindrome Number的Java提交中击败了88.98% 的用户
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome_advance(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		int reverse = 0;
		while (x > reverse) {
			reverse = reverse * 10 + x % 10;
			x = x / 10;
		}
		return x == reverse || x == reverse / 10;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome_advance(9));
	}
}
