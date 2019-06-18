package com.wong.leetcode.Q001_100;

/**
 * 12. 整数转罗马数字
 * 
 * @author weien
 *
 */
public class Q012 {

	/**
	 * 直接暴力转换
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {
		StringBuffer sb = new StringBuffer();
		int thousands = num / 1000;
		if (thousands != 0) {
			for (int i = 0; i < thousands; ++i) {
				sb.append("M");
			}
		}
		int hundreds = (num % 1000) / 100;
		if (hundreds != 0) {
			if (hundreds == 4) {
				sb.append("CD");
			} else if (hundreds == 9) {
				sb.append("CM");
			} else {
				if (hundreds >= 5) {
					sb.append("D");
				}
				for (int i = 0; i < hundreds % 5; ++i) {
					sb.append("C");
				}
			}
		}
		int tens = (num % 100) / 10;
		if (tens != 0) {
			if (tens == 4) {
				sb.append("XL");
			} else if (tens == 9) {
				sb.append("XC");
			} else {
				if (tens >= 5) {
					sb.append("L");
				}
				for (int i = 0; i < tens % 5; ++i) {
					sb.append("X");
				}
			}
		}
		int units = num % 10;
		if (units != 0) {
			if (units == 4) {
				sb.append("IV");
			} else if (units == 9) {
				sb.append("IX");
			} else {
				if (units >= 5) {
					sb.append("V");
				}
				for (int i = 0; i < units % 5; ++i) {
					sb.append("I");
				}
			}
		}
		return sb.toString();
	}
	/**
	 * 通过一个map映射转换，两者效率相差不大，但这个更巧妙
	 * @param num
	 * @return
	 */
	public String intToRoman_op(int num) {
		StringBuffer sb = new StringBuffer();
		int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String reps[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i=0;i<13;++i) {
        	while(num >= values[i]) {
        		num -= values[i];
        		sb.append(reps[i]);
        	}
        }
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Q012().intToRoman_op(3));
	}

}
