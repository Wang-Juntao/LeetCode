package com.wong.leetcode.Q001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和(难度：中等) 给定一个无重复元素的数组 candidates 和一个目标数 target ， 找出 candidates
 * 中所有可以使数字和为 target 的组合。 candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 所有数字（包括 target）都是正整数。 解集不能包含重复的组合。
 * 
 * 示例 1:
 * 
 * 输入: candidates = [2,3,6,7], target = 7, 所求解集为: [ [7], [2,2,3] ]
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,3,5], target = 8, 所求解集为: [ [2,2,2,2], [2,3,3], [3,5] ]
 * 
 */
public class Q039 {
	/*
	 *	 回溯算法 
	 * 	为了防止出现重复结果，我们现将candidates排序，然后再从前往后从数组中选取数字
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if(candidates == null || candidates.length == 0){
			return res;
		}
		Arrays.sort(candidates); //
		backtrack(res, new ArrayList<>(), candidates, 0, target);
		return res;
	}
	/**
	 * @param res 用来存放结果的集合
	 * @param current 当前用来缓存对象的集合
	 * @param candidates 数组
	 * @param i	当前可选取数字的开始下标
	 * @param target 目标数
	 * @return
	 */
	public int backtrack(List<List<Integer>> res, List<Integer> current, int[] candidates, int i, int target) {
		int compare = compare(current, target);
		if (compare == 0) {//回溯条件 
			List<Integer> copy = new ArrayList<>(current);//这里一定要是复制，而不是直接添加。原因是list是引用
			res.add(copy);
			return compare;
		} else if (compare > 0) {//必须回溯
			return compare;
		} else {//继续执行
			for (int k = i; k < candidates.length; k++) {
				current.add(candidates[k]);
				int last_c = backtrack(res, current, candidates, k, target); //这一层的回溯结束后，移除本层添加的数据
				current.remove(current.size() - 1);
				if(last_c >= 0) {
					break;
				}
			}
			return -1;
		}
	}

	public int compare(List<Integer> current, int target) {
		int sum = 0;
		for (Integer i : current) {
			sum += i;
		}
		return sum - target;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 2,3,5 };
		List<List<Integer>> res = new Q039().combinationSum(nums, 8);
		res.forEach(x -> {
			System.out.print("[");
			x.forEach(y -> {
				System.out.print(y + "\t");
			});
			System.out.print("]");
			System.out.println();
		});
	}

}
