package com.wong.leetcode.Q001_100;

/**
 * 41. 缺失的第一个正数(难度：困难) 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,0] 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: [3,4,-1,1] 输出: 2
 * 
 * 示例 3:
 * 
 * 输入: [7,8,9,11,12] 输出: 1
 * 
 * 说明:
 * 
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * 
 */
public class Q041 {

	public int firstMissingPositive(int[] nums) {
		int min = 0;
		int max = 0;
		for(int i=0 ;i< nums.length;i++) {
			if(nums[i] > 0) {
				if(nums[i] < min) {
					min = nums[i];
				}
				if(nums[i] > max) {
					max = nums[i];
				}
			}
		}
		if(min > 1) {
			return Math.min(1, min-1);
		}
		min = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i] == min + 1) {
				min += 1;
			}
		}
		for(int i=nums.length-1;i>=0;i--) {
			if(nums[i] == min + 1) {
				min += 1;
			}
		}
		
		return min+1;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {3,4,-1,1,2,7,8};
		System.out.println(new Q041().firstMissingPositive(nums));
	}

}
