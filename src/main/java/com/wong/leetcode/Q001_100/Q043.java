package com.wong.leetcode.Q001_100;

/**
 * 43. 字符串相乘
 * 
 * 	给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 *	 示例 1:
 * 	输入: num1 = "2", num2 = "3" 输出: "6"
 * 
 * 	示例 2:
 * 	输入: num1 = "123", num2 = "456" 输出: "56088"
 * 
 * 	说明：
 * 	num1 和 num2 的长度小于110。 num1 和 num2 只包含数字 0-9。 num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 	不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Q043 {
	/*
	 * 前提：两数相乘，结果最长为num1.length + num2.length
	 * 所以可以定一个长度为num1.length + num2.length的数组，用来存放计算结果
	 */
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int zeroAppend = 0;
		int right1 = num1.length() - 1;
		while (num1.charAt(right1) == '0') {
			zeroAppend++;
			right1--;
		}
		int right2 = num2.length() - 1;
		while (num2.charAt(right2) == '0') {
			zeroAppend++;
			right2--;
		}
		/*
		 * 对每一位单独做乘法，并把结果加到res里
		 * 初始时加到res最后一位，往后每一个循环往左移一位
		 */
		int[] res = new int[right1 + right2 + 2];
		int intPos = res.length - 1;
		for (int j = 0; j <= right2; j++) {
			int i2 = num2.charAt(right2 - j) - '0';
			for (int i = right1, pos = intPos; i >= 0; i--, pos--) {
				int i1 = num1.charAt(i) - '0';
				int px = i1 * i2;
				res[pos] += px ; //先不考虑进位，在下一步统一做进位
//				res[pos] += px % 10;
//				res[pos - 1] += px / 10;
			}
			intPos--;
		}
		/*
		 * 上一步计算结束后，res中部分位可能会超过10，这里用一个循环吧本该进位的进行进位处理
		 */
		for (int i = res.length - 1; i > 0; i--) {
			if (res[i] >= 10) {
				res[i - 1] += res[i] / 10;
				res[i] = res[i] % 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = findPos(res); i < res.length; i++) {
			sb.append(res[i]);
		}
		while (zeroAppend > 0) {
			sb.append(0);
			zeroAppend--;
		}
		return sb.toString();
	}

	public int findPos(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > 0) {
				return i;
			}
		}
		return nums.length - 1;
	}

	public static void main(String[] args) {
		System.out.println(new Q043().multiply("999999999999999999999999999999999999999999", "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"));
//		System.out.println(new BigDecimal(Integer.MAX_VALUE).multiply(new BigDecimal(Integer.MAX_VALUE)).toString());
	}

}
