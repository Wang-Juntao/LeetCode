package com.wong.leetcode.Q001_100;

/**
 * Pow(x, n) 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * 示例 1:
 * 
 * 输入: 2.00000, 10 输出: 1024.00000
 * 
 * 示例 2:
 * 
 * 输入: 2.10000, 3 输出: 9.26100
 * 
 * 示例 3:
 * 
 * 输入: 2.00000, -2 输出: 0.25000 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 
 * 说明: -100.0 < x < 100.0 n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class Q050 {

//	private double fastPow(double x, long n) {
//		if (n == 0) {
//			return 1.0;
//		}
//		double half = fastPow(x, n / 2);
//		if (n % 2 == 0) {
//			return half * half;
//		} else {
//			return half * half * x;
//		}
//	}

	public double myPow(double x, int n) {
//		long N = n;
//		if (N < 0) {
//			x = 1 / x;
//			N = -N;
//		}
//		return fastPow(x, N);
		double base = x , result = 1;
		int m = Math.abs(n);
		while(m > 0) {
			if((m & 1) != 0) {
				result *= base;
			}
			base = base * base;
			m>>>=1;
		}
		return n<0 ?1/result:result;
	}

	public static void main(String[] args) {
		System.out.println(new Q050().myPow(2, 15));
	}

}
