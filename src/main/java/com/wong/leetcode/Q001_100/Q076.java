package com.wong.leetcode.Q001_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q076 {
	//滑动窗口
	public String minWindow(String s, String t) {
		if(s.length() == 0 || t.length() == 0)
			return "";
		int left = 0,right = 0;
		Map<Character,Integer> tmap = new HashMap<>();
		for(int i=0;i<t.length();i++) {
			char c = t.charAt(i);
			int count = tmap.getOrDefault(c, 0);
			tmap.put(c, count+1);
		}
		int[] ans = new int[3];//记录开始结束，长度
		int formated = tmap.size();
		int snow = 0;
		Map<Character,Integer> smap = new HashMap<>();
		while(right < s.length()) {
			while(snow < formated && right < s.length()) {
				char c = s.charAt(right);
				if(tmap.containsKey(c)) {
					int count = smap.getOrDefault(c, 0);
					count++;
					smap.put(c, count);
					if(count == tmap.get(c).intValue()) {
						snow++;
					}
				}
				right ++;
			}
			while(left < right && snow == formated) {
				if(ans[2]==0 || ans[2] > right - left) {
					ans[0] = left;
					ans[1] = right;
					ans[2] = right - left;
				}
				char c = s.charAt(left);
				if(tmap.containsKey(c)) {
					int count = smap.getOrDefault(c, 0);
					count--;
					smap.put(c, count);
					if(count < tmap.get(c).intValue()) {
						snow--;
					}
				}
				left ++;
			}
		}
		return new String(s.toCharArray(),ans[0],ans[2]);
	}
	//用哈希表，时间空间效率都不高
	public String minWindow_Op(String s, String t) {
		if(s.length() == 0 || t.length() == 0)
			return "";
		Map<Character,Integer> dictT = new HashMap<>();
		for(int i=0;i<t.length();i++) {
			char c = t.charAt(i);
			int count = dictT.getOrDefault(c, 0);
			dictT.put(c, count+1);
		}
		List<Integer> filterIndex = new ArrayList<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(dictT.containsKey(c)) {
				filterIndex.add(i);
			}
		}
		int[] ans = {0,0,0};//记录开始结束，长度
		int formated = dictT.size();
		int snow = 0;
		Map<Character,Integer> window = new HashMap<>();
		int left = 0,right = -1;
		while(right < filterIndex.size()) {
			while(snow < formated && ++right < filterIndex.size()) {
				char c = s.charAt(filterIndex.get(right));
				int count = window.getOrDefault(c, 0);
				count++;
				window.put(c, count);
				if (count == dictT.get(c).intValue()) {
					snow++;
				}
			}
			while(left <= right && snow == formated) {
				int sleft = filterIndex.get(left);
				int sright = filterIndex.get(right);
				if(ans[2]==0 || ans[2] > sright - sleft + 1) {
					ans[0] = sleft;
					ans[1] = sright;
					ans[2] = sright - sleft + 1;
				}
				char c = s.charAt(sleft);
				int count = window.getOrDefault(c, 0);
				count--;
				window.put(c, count);
				if (count < dictT.get(c).intValue()) {
					snow--;
				}
				left ++;
			}
		}
		return new String(s.toCharArray(),ans[0],ans[2]);
	}
	//一般带字母的题都可以用字母表来做
	public String minWindow_Op2(String s ,String t) {
		if (s.isEmpty()) 
            return "";
		/*
		 * 	这段代码的思路是利用一个int[128]数组和一个len变量来检查是否已经全部覆盖。
		 * 	1.先将int[128]，len初始化，初始完成后数组的相应ascii码值位保存着t字符串每个字符出现的次数，len则为t字符串长度
		 * 	2.设想一下，如果这时候对数组每一个数做减1操作，则不为零的数就是t中出现过的字符。
		 * 	3.在执行2的操作后，如果发现数组中有不为零的元素，则对len--，表示我们已经找到一个字母
		 * 	4.如果某一个字母在t中n次出现，那么当我们对其进行n次减一才会等于0
		 * 	5.基于滑动窗口算法，这时我们对left加一，并对相应的字母加1，考虑到left走过的字母是right已经做过—1操作的，所以未出现在t中的字母在滑动过程中数值大于0的情况
		 * 		而对于t中出现过的字母，一旦出现大于0的情况，即说明已经划走了一个，我们将len+1（可以将len理解为我们还需要查找的字母数）
		 */
        int[] record = new int[128]; 
        for (char c: t.toCharArray()) {
            record[c]++;
        }
        int i = 0, j = 0;
        int l = 0, r = 0;
        int len = t.length();
        char[] c = s.toCharArray();
        while (r < c.length) {
            if (record[c[r]] > 0) {
                len--;
            }
            record[c[r]]--;
            r++;
            while (len == 0) {
                if (j == 0 || r - l < j - i) {
                    j = r;
                    i = l;
                }
                record[c[l]]++;
                if (record[c[l]] > 0) {
                    len++;
                }
                l++;
            }
        }
        return s.substring(i,j);
	}
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(new Q076().minWindow_Op2(s, t));
	}

}
