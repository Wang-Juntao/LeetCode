package com.wong.leetcode;

/**
 * 
 * 14. 最长公共前缀 编写一个函数来查找字符串数组中的最长公共前缀。 如果不存在公共前缀，返回空字符串 ""。
 * 
 * @author weien
 *
 */
public class Q014 {

	public String longestCommonPrefix(String[] strs) {
		if(strs== null || strs.length == 0) {
			return "";
		}
		if(strs.length == 1) {
			return strs[0];
		}
		String comonPrefix ="";
		for(int i=0;i<strs[0].length();++i) {//因为是最长前缀，所以可以随机选一个作为遍历对象
			char c = strs[0].charAt(i);
			for(int j=1;j<strs.length;++j) {
				if (strs[j].length() < i + 1 || strs[j].charAt(i) != c) {//当前遍历对象长度小于i或者已有不同，则可以直接返回
					return comonPrefix;
				}
			}
			comonPrefix = comonPrefix + c;
		}
		return comonPrefix;

	}
	public static void main(String[] args) {
		System.out.println(new Q014().longestCommonPrefix(new String[]{"flower","xlow","flight"}));
	}

}
