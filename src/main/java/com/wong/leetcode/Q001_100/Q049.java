package com.wong.leetcode.Q001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 
 * 输出: [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
 * 
 * 说明：
 * 
 * 所有输入均为小写字母。 不考虑答案输出的顺序。
 */
public class Q049 {
	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		Map<String,List<String>> tmp = new HashMap<>();
		for(String s : strs) {
			List<String> list = tmp.computeIfAbsent(sort(s), (k)->new ArrayList<>());//leetcode的oj对函数式编程普遍执行时间比较长，慎用
			list.add(s);
		}
		res.addAll(tmp.values());//map.values方法很慢，比较耗时
		return res;
	}
	//针对初版做优化，map只存放list的index
	public List<List<String>> groupAnagrams_v2(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		Map<String,Integer> tmp = new HashMap<>();
		for(String s : strs) {
			String key = sort(s);
			Integer index = tmp.get(key);
			List<String> list;
			if(index != null) {
				list = res.get(index);
			}else {
				list = new ArrayList<>();
				tmp.put(key, res.size());
				res.add(list);
			}
			list.add(s);
		}
		return res;
	}
	
	public String sort(String s) {
		char[] cs = s.toCharArray();
		Arrays.sort(cs);
		return new String(cs);
	}

	public static void main(String[] args) {
		String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = new Q049().groupAnagrams(strs);
		for (List<String> l : res) {
			System.out.print("\t");
			for (String s : l) {
				System.out.print(s + "\t");
			}
			System.out.println("]");
		}
	}
}
