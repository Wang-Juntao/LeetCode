package com.wong.leetcode.Q001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * 
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2] 输出: [ [1,1,2], [1,2,1], [2,1,1] ]
 */
public class Q047 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums); // 为方便去重，先将数组排序
		int[] visted = new int[nums.length];
		backtrack(list, nums, new ArrayList<Integer>(), visted);
		return list;
	}

	/**
	 * 
	 * @param res    存放结果
	 * @param nums   nums
	 * @param tmp    保存临时数据
	 * @param visted 标记是否已使用 0-未使用 1-已使用
	 */
	public void backtrack(List<List<Integer>> res, int[] nums, List<Integer> tmp, int[] visted) {
		if (tmp.size() == nums.length) {
			res.add(new ArrayList<>(tmp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visted[i] == 0) {
				tmp.add(nums[i]);
				visted[i] = 1;
				backtrack(res, nums, tmp, visted);
				visted[i] = 0;
				tmp.remove(tmp.size() - 1);
				while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++; // 与上一题区别
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 1, 2 };
		List<List<Integer>> list = new Q047().permuteUnique(nums);
		for (List<Integer> l : list) {
			System.out.print("[ ");
			for (Integer i : l) {
				System.out.print(i + "\t");
			}
			System.out.println("]");
		}
	}

}
