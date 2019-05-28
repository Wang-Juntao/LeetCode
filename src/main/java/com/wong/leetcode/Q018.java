package com.wong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c
 * + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 
 * @author weien
 *
 */
public class Q018 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ls = new ArrayList<>();
		if (nums == null || nums.length < 4)
			return ls;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { // 跳过可能重复的答案
				for (int j = i + 1; j < nums.length - 2; ++j) {
					if (j == i + 1 || j > i + 1 && nums[j] != nums[j - 1]) {
						int l = j + 1, r = nums.length - 1, sum = target - nums[i] - nums[j];
						while (l < r) {
							if (nums[l] + nums[r] == sum) {
								ls.add(Arrays.asList(nums[i],nums[j], nums[l], nums[r]));
								while (l < r && nums[l] == nums[l + 1])
									l++;
								while (l < r && nums[r] == nums[r - 1])
									r--;
								// 同时移动l跟r的原因是如果只移动一个，
								// 那么最后的结果一定偏大或偏小，即同时移动二者不会错过一个正确的解，
								// 所以干脆直接同时移动两个
								l++;
								r--;
							} else if (nums[l] + nums[r] < sum) {
								while (l < r && nums[l] == nums[l + 1])
									l++; // 跳过重复值
								l++;
							} else {
								while (l < r && nums[r] == nums[r - 1])
									r--;
								r--;
							}
						}
					}
				}

			}
		}
		return ls;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 0, -1, 0, -2, 2};
		int target = 1;
		List<List<Integer>> result = new Q018().fourSum(nums, target);
		result.forEach(x -> {
			x.forEach(y -> System.out.print(y + "\t"));
			System.out.println();
		});
	}

}
