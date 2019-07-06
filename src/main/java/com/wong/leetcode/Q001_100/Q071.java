package com.wong.leetcode.Q001_100;

import java.util.Stack;

public class Q071 {
	/*
	 * 本题本身不是很难，但有个很坑的一点：对于/... 或者像/home/..sdfsd..的目录也是合理的
	 * 这个与第一直觉是不符合的
	 */
	//第一版，比较容易想到是用栈，但效率不高
	public String simplifyPath(String path) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < path.length(); ++i) {
			char c = path.charAt(i);
			if (c == '/') {
				if (stack.size() == 0 || stack.peek() != '/') {
					stack.push(c);
				}
			} else if (c == '.') { //有效性校验 ：‘.’后边只能再跟一个‘.’或者‘/’
				if(i < path.length() - 1) {
						int pos = i;
						while(pos < path.length() && path.charAt(pos) != '/') pos++;
						int len = pos - i;
						if(len == 2 && path.charAt(i + 1) == '.') {
							if (stack.size() > 1) {
								stack.pop();
							}
							while (stack.size() > 1 && stack.pop() != '/') {
							}
							i++;
						}else if(len > 2) {
							while(i < pos) {stack.push(path.charAt(i)) ; i++;}
							i = pos - 1;
						}
				}
			} else {
				stack.push(c);
			}
		}
		if (stack.size() > 1 && stack.peek() == '/') {
			stack.pop();
		}
		String res = "";
		while (!stack.isEmpty()) {
			res = stack.pop() + res;
		}
		return res;
	}
	
	public String simplifyPath_Op(String path) {
		char[] tmp = path.toCharArray();
		int pos = 0,p_path = 0;
		while(p_path < path.length()) {
			
		}
		return new String(tmp,0,pos+1);
	}

	public static void main(String[] args) {
		String s = "/home/foo/.ssh/../.ssh2/authorized_keys/";
		System.out.println(new Q071().simplifyPath(s));
	}

}
