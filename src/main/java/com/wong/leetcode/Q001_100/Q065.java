package com.wong.leetcode.Q001_100;

import java.util.Stack;

public class Q065 {
	public boolean isNumber(String s) {
		if(s == null || (s = s.trim()).isEmpty()) {
			return false;
		}
//		Stack<Character> stack = new Stack<>();
//		boolean isEmc = false;
//		for(int i=0;i<s.length();i++) {
//			char c = s.charAt(i);
//			Character top = stack.size() == 0 ? null : stack.peek();
//			if(c == '-' || c == '+') {
//				if(top == null || top=='e') {
//					stack.push(c);
//				}else{
//					return false;
//				}
//			}else if(c=='e') {
//				if(top == null || (top > '9' && top <'0')) {
//					return false;
//				}else {
//					isEmc = true;
//					stack.push(c);
//				}
//			}else if(c=='.') {
//				if()
//			}else if(c >='0' && c<='9') {
//				stack.push(c);
//			}else {
//				return false;
//			}
//		}
		
//		String pattern = "^\\s*[+-]?(\\d+\\.?|\\d*\\.\\d+)(e[+-]?\\d+)?\\s*$";
//		return s.matches(pattern);
		try{
            Float.parseFloat(s);
            return true;
        }catch(Exception e){
            return false;
        }
	}
	
	public static void main(String[] args) {
		String s = ".1";
		System.out.println(new Q065().isNumber(s));
	}
}
