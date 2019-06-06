package com.wong.leetcode.Q001_100;


/**
 * 35. 搜索插入位置(难度：简单)
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 你可以假设数组中无重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,5,6], 5 输出: 2
 * 
 * 示例 2:
 * 
 * 输入: [1,3,5,6], 2 输出: 1
 * 
 * 示例 3:
 * 
 * 输入: [1,3,5,6], 7 输出: 4
 * 
 * 示例 4:
 * 
 * 输入: [1,3,5,6], 0 输出: 0
 */
public class Q035 {

	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}else if(nums.length == 1) {
			return target <= nums[0] ? 0 : 1;
		}
		return bin_search(nums,0,nums.length-1,target);
	}
	
	public int bin_search(int[] nums, int start, int end, int target) {
		while (start <= end) {
			int bin = (start + end) / 2;
			if (nums[bin] == target) {
				return bin;
			} else if (nums[bin] > target) {
				end = bin - 1;
			} else {
				start = bin + 1;
			}
		}
		return start;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] { 1};
		System.out.println(new Q035().searchInsert(nums,0)); ;
	}

}
