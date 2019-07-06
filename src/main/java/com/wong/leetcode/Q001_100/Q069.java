package com.wong.leetcode.Q001_100;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * 示例 1:
 * 
 * 输入: 4 输出: 2
 * 
 * 示例 2:
 * 
 * 输入: 8 输出: 2 说明: 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Q069 {
	// https://www.cnblogs.com/10cm/p/3922398.html
	// 很快，但是很遗憾只能计算结果为整数的开平方
	public int mySqrt(int x) {
		int N, i;
		long tmp, ttp; // 结果、循环计数
		if (x == 0) // 被开方数，开方结果也为0
			return 0;
		N = 0;
		tmp = (x >> 30); // 获取最高位：B[m-1]
		x <<= 2;
		if (tmp > 1) // 最高位为1
		{
			N++; // 结果当前位为1，否则为默认的0
			tmp -= N;
		}

		for (i = 15; i > 0; i--) // 求剩余的15位
		{
			N <<= 1; // 左移一位

			tmp <<= 2;
			tmp += (x >> 30); // 假设

			ttp = N;
			ttp = (ttp << 1) + 1;

			x <<= 2;
			if (tmp >= ttp) // 假设成立
			{
				tmp -= ttp;
				N++;
			}

		}
		return N;
	}

	// 二分法
	public int mySqrt_slow(int x) {
		if (x == 0)
			return 0;
		long res;
		long i = 0, j = x;
		while (i <= j) {
			long mid = (i + j) / 2;
			res = mid * mid;
			if (res == x) {
				return (int) mid;
			} else if (res > x) {
				j = mid - 1;
			} else {
				i = mid + 1;
			}
		}
		return (int) j;
	}

	// 牛顿迭代法
	public int mySqrt_newton(int x) {
		if (x == 0)
			return 0;
		Double n = x / 2.0d;
		Double dx = (double) x;
		while (Math.abs(((n + dx / n) / 2) - n) >= 1e-6) {
			n = (n + dx / n) / 2;
		}
		return n.intValue();
	}

	public static void main(String[] args) {
		System.out.println(new Q069().mySqrt(8));
		System.out.println(new Q069().mySqrt_slow(2147395599));
		System.out.println(Math.sqrt(8));
	}

}
