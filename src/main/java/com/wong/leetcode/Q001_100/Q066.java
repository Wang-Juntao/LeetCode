package com.wong.leetcode.Q001_100;

import java.util.Arrays;

public class Q066 {

	public int[] plusOne(int[] digits) {
		digits[digits.length-1] += 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			if(digits[i] > 9 && i > 0) {
				digits[i] = 0;
				digits[i-1] += 1;
			}
		}
		if(digits[0] > 9) {
			int[] res = new int[digits.length+1];
			res[0] = 1;
			res[1] = 0;
			System.arraycopy(digits, 1, res, 2, digits.length-1);
			return res;
		}else {
			return digits;
		}
	}
	
	public static void main(String[] args) {
		int[] digits = new int[] {9};
		int[] res = new Q066().plusOne(digits);
		Arrays.stream(res).forEach(x->System.out.print(x));
	}

}
