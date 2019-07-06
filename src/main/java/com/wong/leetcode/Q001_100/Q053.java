package com.wong.leetcode.Q001_100;

/**
 * 53. 最大子序和 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */
public class Q053 {
	
	/*
	 * 动态规划的思路应该是：
	 * 一个dp[]数组，dp[i]表示0-i的最大自序和
	 * dp[i] = dp[i-1] > 0 ? dp[i-1] + nums[i] : nums[i];
	 * leetcode有个题解将这个过程更加的简化，因为每次只用上一次的和，所以只需要一个变量
	 */
	public int maxSubArray(int[] nums) {
		int ans = nums[0];
		int sum = 0;
		for (int num : nums) {
			if (sum > 0) {
				sum += num;
			} else {
				sum = num;
			}
			ans = Math.max(ans, sum);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(new Q053().maxSubArray(nums));
	}
}
