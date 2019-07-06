package com.wong.leetcode.Q001_100;

public class Q058 {

	public int lengthOfLastWord(String s) {
		if(s.length() == 0) {
			return 0;
		}
		int pos = s.length() - 1;
		int lastLength = 0;
		while(pos >= 0 && s.charAt(pos) == ' ') pos --;
		while(pos >= 0 && s.charAt(pos) != ' ') {pos -- ;lastLength ++; }
		return lastLength;
	}
	
	public static void main(String[] args) {
		String s = "hello world";
		System.out.println(new Q058().lengthOfLastWord(s));
	}

}
