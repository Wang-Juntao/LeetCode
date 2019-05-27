package com.wong.leetcode;

public class Q012 {
	
	public static int trap(int[] height) {
		if (height == null || height.length <= 2)//有一个边界需要判断
			return 0;
		int ans = 0;
		for (int i = 1; i < height.length - 1; ++i) {
			int max_left = 0, max_right = 0;
			for (int j = i ; j >= 0; --j) {
				max_left = Math.max(max_left, height[j]);
			}
			for (int k = i ; k < height.length; ++k) {
				max_right = Math.max(max_right, height[k]);
			}
			ans += Math.min(max_left, max_right) - height[i];
		}
		return ans;
	}
	
	public static int trap_dp(int[] height) {
		if (height == null || height.length <= 2)
			return 0;
		int ans = 0;
		int[] max_left = new int[height.length];
		int[] max_right = new int[height.length];
		max_left[0] = height[0];
		for (int i = 1; i < height.length - 1; ++i) {
			max_left[i] = Math.max(max_left[i - 1], height[i]);
		}
		max_right[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; --i) {
			max_right[i] = Math.max(max_right[i + 1], height[i]);
		}
		
		for (int i = 1; i < height.length - 1; ++i) {
			
			ans += Math.min(max_left[i], max_right[i]) - height[i];
		}
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(trap_dp(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
	}

}
