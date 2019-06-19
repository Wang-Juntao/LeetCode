package com.wong.leetcode.Q001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. 全排列 
 * 	给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 	示例:
 * 
 * 	输入: [1,2,3] 输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 */
public class Q046 {
	/*
	 * 字典序列算法，每次计算下一个字典序列，具体算法参看第31题
	 */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		list.add(convert(nums));
		while (next(nums) >= 0) {
			list.add(convert(nums));
		}
		return list;
	}

	public int next(int[] nums) {
		int pos = nums.length - 2;
		while (pos >= 0 && nums[pos] >= nums[pos + 1]) {
			pos--;
		}
		if (pos < 0) {
			return pos;
		}
		int j = nums.length - 1;
		while (j > pos && nums[j] <= nums[pos]) {
			j--;
		}
		int tmp = nums[pos];
		nums[pos] = nums[j];
		nums[j] = tmp;
		reverse(nums, pos + 1, nums.length - 1);
		return pos;
	}

	public void reverse(int[] nums, int start, int end) {
		for (int i = start; i <= (start + end) / 2; ++i) {
			int right = end - i + start;
			int tmp = nums[i];
			nums[i] = nums[right];
			nums[right] = tmp;
		}
	}

	public List<Integer> convert(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i : nums) {
			list.add(i);
		}
		return list;
	}
	
	/*
	 * 回溯算法
	 */
	public List<List<Integer>> permute_backtrack(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		int[] visted = new int[nums.length];
		backtrack(list,nums,new ArrayList<Integer>(),visted);
		return list;
	}
	/**
	 * 
	 * @param res 存放结果
	 * @param nums nums
	 * @param tmp 保存临时数据
	 * @param visted 标记是否已使用 0-未使用 1-已使用
	 */
	public void backtrack(List<List<Integer>> res, int[] nums,List<Integer> tmp,int[] visted) {
		if(tmp.size() == nums.length ) {
			res.add(new ArrayList<>(tmp));
			return;
		}
		for(int i = 0;i<nums.length;i++) {
			if(visted[i] == 0) {
				tmp.add(nums[i]);
				visted[i] = 1;
				backtrack(res,nums,tmp,visted);
				visted[i] = 0;
				tmp.remove(tmp.size()-1);
			}
		}
	}
	

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 2, 3 ,1};
		List<List<Integer>> list = new Q046().permute_backtrack(nums);
		for (List<Integer> l : list) {
			System.out.print("[ ");
			for (Integer i : l) {
				System.out.print(i + "\t");
			}
			System.out.println("]");
		}
	}

}
