package com.wong.leetcode.Q001_100;

/**
 * 33. 搜索旋转排序数组 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0 输出: 4
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3 输出: -1
 */
public class Q033 {

	// 测试用例问题，这个也能排在99%前面
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target)
				return i;
		}
		return -1;
	}

	public int search_v2(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}else if(nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}
		
		int index = bin_find_rotate_index(nums);
		if (nums[index] == target) {
			return index;
		}
		if (index == 0) {
			return bin_search(nums, 0, nums.length - 1, target);
		}
		if (nums[0] > target) {
			return bin_search(nums, index, nums.length - 1, target);
		} else {
			return bin_search(nums, 0, index - 1, target);
		}
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

	public int bin_find_rotate_index(int[] nums) {
		if (nums[0] < nums[nums.length - 1])
			return 0;
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int bin = (left + right) / 2;
			if (nums[bin] > nums[bin + 1])
				return bin + 1;
			else {
				if (nums[left] > nums[bin]) {
					right = bin - 1;
				} else {
					left = bin + 1;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 8,9,2,3,4 };
//		int[] nums = new int[] {0,1,2,3,4,5,6,7};
		System.out.println(new Q033().bin_find_rotate_index(nums));
		System.out.println(new Q033().search_v2(nums, 9));
	}

}
