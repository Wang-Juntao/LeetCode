package com.wong.leetcode.Q001_100;

import java.util.Stack;

/**
 * 20. 有效的括号 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。
 * 
 * 注意空字符串可被认为是有效字符串。
 *
 */
public class Q020 {

	public boolean isValid(String s) {
		if(s == null || s.trim().isEmpty()) {
			return true;
		}
		if(s.length() % 2 != 0) {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c == '(' || c=='{' || c=='[') {
				stack.push(c);
			}else if(c==')') {
				if(stack.isEmpty()) {
					return false;
				}
				if(stack.peek().charValue() == '(') {
					stack.pop();
				}else {
					return false;
				}
			}else if (c=='}') {
				if(stack.isEmpty()) {
					return false;
				}
				if(stack.peek().charValue() == '{') {
					stack.pop();
				}else {
					return false;
				}
			}else if (c==']') {
				if(stack.isEmpty()) {
					return false;
				}
				if(stack.peek().charValue() == '[') {
					stack.pop();
				}else {
					return false;
				}
			}
			
		}
		return stack.isEmpty() ;
		
	}
	
	public static void main(String[] args) {
		String s = "){";
		System.out.println(new Q020().isValid(s));
	}
	

}
