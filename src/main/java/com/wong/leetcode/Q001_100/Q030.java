package com.wong.leetcode.Q001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 30. 串联所有单词的子串(难度:困难)
 * 
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * 
 * 示例 1：
 * 
 * 输入： s = "barfoothefoobarman", words = ["foo","bar"] 输出：[0,9] 解释： 从索引 0 和 9
 * 开始的子串分别是 "barfoor" 和 "foobar" 。 输出的顺序不重要, [9,0] 也是有效答案。
 * 
 * 示例 2：
 * 
 * 输入： s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 
 */
public class Q030 {
	// 两个点：1.word中单词长度相同 2.中间不能有其他字符 =》 匹配的子串长度是固定的
	// 暴力破解 10%以后
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<>();
		if (s == null || s.isEmpty() || words == null) {
			return list;
		}
		if (words.length == 0) {
			return list;
		}
		int minl = words[0].length();
		int totall = minl * words.length;
		if (s.length() < totall) {
			return list;
		}
		String wordSorted = Arrays.stream(words).sorted().collect(Collectors.joining());
		for (int i = 0; i <= s.length() - totall; ++i) {
			String subStr = s.substring(i, i + totall);
			String[] ss = new String[words.length];
			for (int j = 0; j < words.length; j++) {
				ss[j] = subStr.substring(j * minl, (j + 1) * minl);
			}
			String sorted = Arrays.stream(ss).sorted().collect(Collectors.joining());
			if (sorted.equals(wordSorted)) {
				list.add(i);
			}
		}
		return list;
	}
	// 没思路 参考：https://zhuanlan.zhihu.com/p/57505536
	public List<Integer> findSubstring_v2(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (s == null || s.length() == 0 || words == null || words.length == 0)
			return res;
		HashMap<String, Integer> map = new HashMap<>();
		int one_word = words[0].length();
		int word_num = words.length;
		int all_len = one_word * word_num;
		if (s.length() < all_len) {
			return res;
		}
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		for (int i = 0; i < one_word; i++) {
			int left = i, right = i, count = 0;
			HashMap<String, Integer> tmp_map = new HashMap<>();
			while (right + one_word <= s.length()) {
				String w = s.substring(right, right + one_word);
				tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
				right += one_word;
				count++;
				while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
					String t_w = s.substring(left, left + one_word);
					count--;
					tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
					left += one_word;
				}
				if (count == word_num)
					res.add(left);

			}
		}
		return res;
	}

	public static void main(String[] args) {
//		String s = "barfoothefoobarman";
//		String[] words = new String[] { "foo", "bar" };
		String s = "wordgoodgoodgoodbestword";
		String[] words = new String[] { "word", "good", "best", "good" };
		long start = System.currentTimeMillis();
		List<Integer> r = new Q030().findSubstring_v2(s, words);
		System.out.println(String.format("耗时%dms", System.currentTimeMillis() - start));
		System.out.println(r);
	}

}
