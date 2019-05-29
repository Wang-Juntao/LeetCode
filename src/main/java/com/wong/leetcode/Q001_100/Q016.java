package com.wong.leetcode.Q001_100;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * 
 * @author weien
 *
 */
public class Q016 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int sumClosest = nums[0] + nums[1] + nums[2]  ;
		for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                	int sum = nums[i] + nums[l] + nums[r];
                	if(sum == target)
                		return sum;
                	System.out.println(Math.abs(sum - target) + " : " + Math.abs(sumClosest - target));
					if (Math.abs(sum - target) < Math.abs(sumClosest - target)) {
						sumClosest = sum;
					}
					if(sum > target) {
						r--;
					}else {
						l++;
					}
                }
            }
        }
		return sumClosest;
	}
	
	public static void main(String[] args) {
		int[] nums = {-1,0,1,1,55};
		int target = 3;
		System.out.println(new Q016().threeSumClosest(nums, target));
	}

}
