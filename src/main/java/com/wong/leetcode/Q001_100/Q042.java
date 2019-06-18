package com.wong.leetcode.Q001_100;

/**
 * 42. 接雨水(难度：困难)
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1] 输出: 6
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Q042 {

	public static int trap(int[] height) {
		if (height == null || height.length <= 2)// 有一个边界需要判断
			return 0;
		int ans = 0;
		for (int i = 1; i < height.length - 1; ++i) {
			int max_left = 0, max_right = 0;
			for (int j = i; j >= 0; --j) {
				max_left = Math.max(max_left, height[j]);
			}
			for (int k = i; k < height.length; ++k) {
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
		System.out.println(trap_dp(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
	}

}
