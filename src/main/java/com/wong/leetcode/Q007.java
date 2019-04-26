package com.wong.leetcode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//这一题没有明白问题的点在哪里，根据int类型的入参，就不可能出现超过取值范围的情况
public class Q007 {
	
//	public static int reverse(long x) {
//		if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
//			return 0;
//		}
//		Integer unSigned = Integer.valueOf(new StringBuilder(Long.toUnsignedString(x)).reverse().toString());
//		if(x < 0 && unSigned.intValue() > Integer.MAX_VALUE) {
//			return 0;
//		}else {
//			return unSigned * (x<0?-1:1);
//		}
//	}
	//官方给的示例，可以通过
	public static int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
//		double ll = 3717694924d;
//		System.out.println(reverse((int) ll));
		Method r = Q007.class.getMethod("reverse", int.class);
		r.invoke(Q007.class.newInstance(), 3717694924f);
	}
}
