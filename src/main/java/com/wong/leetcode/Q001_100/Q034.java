package com.wong.leetcode.Q001_100;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置(难度:中等)
 * 
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1: 输入: nums = [5,7,7,8,8,10], target = 8 输出: [3,4]
 * 
 * 示例 2: 输入: nums = [5,7,7,8,8,10], target = 6 输出: [-1,-1]
 */
public class Q034 {

	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[] { -1, -1 };
		} else if (nums.length == 1) {
			return nums[0] == target ? new int[] { 0, 0 } : new int[] { -1, -1 };
		}
		int index = bin_search(nums, 0, nums.length - 1, target);
		if (index == -1) {
			return new int[] { -1, -1 };
		}
		int left = bin_left(nums, 0, index, target);
		int right = bin_right(nums, index, nums.length - 1, target);
		return new int[] { left, right };
	}

	public int bin_left(int[] nums, int start, int end, int target) {
		while (start <= end) {
			int bin = (start + end) / 2;
			if (nums[bin] == target && (bin == 0 || nums[bin - 1] != target)) {
				return bin;
			} else if (nums[bin] >= target) {
				end = bin - 1;
			} else {
				start = bin + 1;
			}
		}
		return -1;
	}

	public int bin_right(int[] nums, int start, int end, int target) {
		while (start <= end) {
			int bin = (start + end) / 2;
			if (nums[bin] == target && (bin == nums.length - 1 || nums[bin + 1] != target)) {
				return bin;
			} else if (nums[bin] <= target) {
				start = bin + 1;
			} else {
				end = bin - 1;
			}
		}
		return -1;
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
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2 };
		int[] result = new Q034().searchRange(nums, 1);
		Arrays.stream(result).forEach(x -> System.out.print(x + " "));
	}

}
