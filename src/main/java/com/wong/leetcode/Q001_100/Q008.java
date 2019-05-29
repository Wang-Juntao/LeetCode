package com.wong.leetcode.Q001_100;

public class Q008 {
	public static int myAtoi(String str) {
		int result = 0;
		boolean isNegative = false;
		boolean charMustBeNumber = false;
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if (Character.isWhitespace(c) && !charMustBeNumber) {
				continue;
			} else if (c == '-' && !charMustBeNumber) {
				isNegative = true;
				charMustBeNumber = true;
			} else if (c == '+' && !charMustBeNumber) {
				isNegative = false;
				charMustBeNumber = true;
			} else if (Character.isDigit(c)) {
				int num = Character.getNumericValue(c);
				if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num >= 7)) {
					return Integer.MAX_VALUE;
				}
				if (result < Integer.MIN_VALUE / 10 ||(result == Integer.MIN_VALUE / 10 && num >= 8)) {
					return Integer.MIN_VALUE;
				}
				result = result * 10 + num * (isNegative ? -1 : 1);
				charMustBeNumber = true;
			} else {
				break;
			}
		}
		return result;
	}
	/**
	 * 	优化版：主要是简化了判断逻辑，在判断完
	 * 	执行用时 : 6 ms, 在String to Integer (atoi)的Java提交中击败了99.49% 的用户 
	 *	内存消耗 : 34.9 MB, 在String to Integer (atoi)的Java提交中击败了95.78% 的用户
	 * @param str
	 * @return
	 */
	public static int myAtoi_v2(String str) {
		int result = 0;
		boolean isNegative = false;
		boolean charMustBeNumber = false;//当前字符是否必须为数字
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if(Character.isDigit(c)) {
				int num = Character.getNumericValue(c);
				if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num >= 7)) {
					return Integer.MAX_VALUE;
				}
				if (result < Integer.MIN_VALUE / 10 ||(result == Integer.MIN_VALUE / 10 && num >= 8)) {
					return Integer.MIN_VALUE;
				}
				result = result * 10 + num * (isNegative ? -1 : 1);
				charMustBeNumber = true;
			}else if(charMustBeNumber) { //短路处理，执行到这一步说明不是数字，而如果需要当前字符为数字的话，则没有必要再继续进行下去了
				break;
			}else if (Character.isWhitespace(c)) {
				continue;
			} else if (c == '-' || c== '+') {
				isNegative = c == '-' ? true : false;
				charMustBeNumber = true;
			} else {
				break;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(myAtoi_v2("+-91283472332"));
	}
}
