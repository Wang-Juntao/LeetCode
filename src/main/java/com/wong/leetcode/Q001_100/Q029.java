package com.wong.leetcode.Q001_100;

/**
 * 
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 
 * 示例 1:
 * 
 * 输入: dividend = 10, divisor = 3 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: dividend = 7, divisor = -3 输出: -2
 * 
 * 说明:
 * 
 * 被除数和除数均为 32 位有符号整数。 除数不为 0。 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 −
 * 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 */
public class Q029 {

	public int divide(int dividend, int divisor) {
		int quotient = 0;//记录商值
		// 处理min_value,因为接下来要对除数和被除数取绝对值
		if (dividend == Integer.MIN_VALUE && divisor == -1) {//最特殊情况
			return Integer.MAX_VALUE;
		}
		//处理除数为min_value的情况
		if (divisor == Integer.MIN_VALUE) {
			if (dividend == Integer.MIN_VALUE) {
				return 1;
			} else {
				return 0;
			}
		}
		boolean isNegative = (dividend ^ divisor) >> 31 < 0; //记录最后结果是否为负
		//处理被除数为min_value的情况
		if (dividend == Integer.MIN_VALUE) {
			dividend += Math.abs(divisor);
			quotient++;
		}
		// 到这里，就可以放心的把两个数字去绝对值了
		dividend = dividend < 0 ? Math.abs(dividend) : dividend;
		divisor = divisor < 0 ? Math.abs(divisor) : divisor;
		int multiple = 1;//记录除数现在的倍数
		while (multiple >= 1 && dividend != 0) {
			if (dividend >= divisor) {//一定要先减
				dividend -= divisor;
				quotient += multiple;
			}
			if (dividend > divisor) {//如果没有先做减法，这里被除数可能会溢出
				divisor = divisor << 1;
				multiple = multiple << 1;
			} else if (dividend < divisor) {
				divisor = divisor >> 1;
				multiple = multiple >> 1;
			}
		}
		return isNegative ? 0 - quotient : quotient;
	}

	public static void main(String[] args) {
		System.out.println(new Q029().divide(1100540749, -1090366779));
		System.out.println((-1 ^ 1) >> 31);
	}

}
