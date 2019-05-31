package com.wong.leetcode.Q001_100;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 
 * 必须原地修改，只允许使用额外常数空间。
 * 
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 1,2,3 → 1,3,2 3,2,1 → 1,2,3 1,1,5 → 1,5,1
 * [以上是官方的解释，简单来说把数字换成字母，想象一下它们随机组成的所有单词排成的字典序列。题目要求解的就是排在当前这个组合的下一个单词。]
 */
public class Q031 {
	//求解思路是 
	//【1】从右往左遍历，找到a[i],这个a[i]满足以下两点：1.a[i]<a[i+] 2.i右边的数字满足倒序排列
	//【2】然后再从从右遍历 i+1 - length中找到一个第一大于a[i]的元素 a[j]
	//【3】交换a[i] a[j]
	// 对a[i]右边的元素进行排序
	public void nextPermutation(int[] nums) {
		// 边界判断
		if (nums == null || nums.length == 0) {
			return;
		}
		int pos = nums.length - 2;
		while (pos >= 0 && nums[pos] >= nums[pos + 1]) {
			pos--;
		}
		if (pos < 0) {
			Arrays.sort(nums);
			return;
		}
		int j = nums.length - 1;
		while (j > pos && nums[j] <= nums[pos]) {
			j--;
		}
//		while (j > pos && nums[j] == nums[j - 1]) {
//			j--;
//		}
		int tmp = nums[pos];
		nums[pos] = nums[j];
		nums[j] = tmp;
		//用了库的排序算法，自己写的话可能会更快，这里就懒的写了
		Arrays.sort(nums, pos + 1, nums.length);
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2,2,2,2,2,2 };
		new Q031().nextPermutation(nums);
		Arrays.stream(nums).forEach(x -> System.out.print(x + "\t"));
	}

}
