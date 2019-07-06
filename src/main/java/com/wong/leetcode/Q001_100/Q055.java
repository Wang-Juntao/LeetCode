package com.wong.leetcode.Q001_100;

/**
 * 55. 跳跃游戏 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个位置。
 * 
 * 示例 1:
 * 
 * 输入: [2,3,1,1,4] 输出: true 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 
 * 示例 2:
 * 
 * 输入: [3,2,1,0,4] 输出: false 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ，
 * 所以你永远不可能到达最后一个位置。
 *
 */
public class Q055 {
	/*
	 * 一开始打算用动态规划的，后来发现写不出来（水平限制）
	 * 后来发现可以用一个数组记下每个点可以到达的最远距离，然后我们再从后往前遍历，如果中间可以连上，直到走到第一个点，则说明是整个链路是可达的
	 * 然后再精简一下发现并不需要预先计算最远可达距离
	 */
	public boolean canJump(int[] nums) {
		if (nums.length == 1) {
			return true;
		}
		int pos = nums.length - 1;
		while (pos > 0) {
			int p = pos - 1;
			while (p >= 0 && p + nums[p] < pos)
				p--;
			pos = p;
		}
		return pos == 0;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 2, 1, 1, 4 };
		System.out.println(new Q055().canJump(nums));
	}
}
