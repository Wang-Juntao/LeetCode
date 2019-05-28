package com.wong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 17. 电话号码的字母组合 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 给出数字到字母的映射如下（与电话按键相同）。注意 1
 * 不对应任何字母。
 * 
 * @author weien
 *
 */
public class Q017 {
	
	
	private String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	//循环
	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.trim().isEmpty()) {
			return new ArrayList<>();
		}
		int csize = 1;
		String[] ss = new String[] {};
		for (int i = 0; i < digits.length(); ++i) {
			String cd = map[digits.charAt(i) - '2'];
			if (i == 0) {
				csize = cd.length();
				ss = cd.split("");
			} else {
				String[] newCartesian = new String[csize * cd.length()];
				for (int j = 0; j < cd.length(); j++) {
					char c = cd.charAt(j);
					String[] nn = new String[csize];
					for (int k = 0; k < csize; ++k) {
						nn[k] = ss[k] + c;
					}
					System.arraycopy(nn, 0, newCartesian, csize * j, csize);
				}
				csize *= cd.length();
				ss = newCartesian;
			}
		}
		return Arrays.asList(ss);
	}
	//递归
	public List<String> letterCombinations_dg(String digits) {
		List<String> ans = new ArrayList<>();
		if (digits != null && digits.length() > 0)
			qaq(ans, "", digits);
		return ans;
	}

	public void qaq(List<String> ans, String cur, String digits) {
		if (cur.length() == digits.length()) {
			ans.add(cur);
			return;
		}
		int index = digits.charAt(cur.length()) - '2';
		for (int i = 0; i < map[index].length(); i++) {
			qaq(ans, cur + map[index].charAt(i), digits);
		}
	}

	public static void main(String[] args) {
		System.out.println(new Q017().letterCombinations("2333333"));
//		System.out.println(new Q017().letterCombinations_dg("2333333"));
	}

}
