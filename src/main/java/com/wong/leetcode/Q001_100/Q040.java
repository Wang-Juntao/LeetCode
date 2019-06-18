package com.wong.leetcode.Q001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II(难度：中等) 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为
 * target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 所有数字（包括目标数）都是正整数。 解集不能包含重复的组合。
 * 
 * 示例 1:
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8, 所求解集为: [ [1, 7], [1, 2, 5],
 * [2, 6], [1, 1, 6] ]
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5, 所求解集为: [ [1,2,2], [5] ]
 *
 * 
 * 
 */
public class Q040 {
	/*
	 * 	与上一题解法类似，我们只需要注意两点：
	 * 1.下一层回溯的开始下标应该是k+1 
	 * 2.因为存在重复的数字，在本层回溯完成时，应跳过相同的数字
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates); //
		backtrack(res, new ArrayList<>(), candidates, 0, target);
		return res;
	}

	public int backtrack(List<List<Integer>> res, List<Integer> current, int[] candidates, int i, int target) {
		int compare = compare(current, target);
		if (compare == 0) {// 回溯条件
			List<Integer> copy = new ArrayList<>(current);// 这里一定要是复制，而不是直接添加。原因是list是引用
			res.add(copy);
			return compare;
		} else if (compare > 0) {// 必须回溯
			return compare;
		} else {// 继续执行
			for (int k = i; k < candidates.length; k++) {
				current.add(candidates[k]);
				int last_c = backtrack(res, current, candidates, k + 1, target); // 这一层的回溯结束后，移除本层添加的数据
				current.remove(current.size() - 1);
				if (last_c >= 0) { //当下一层回溯返回的结果已经超过了target，这时候再继续循环已经没有意义，可以提前结束
					break;
				}
				while(k<candidates.length-1 && candidates[k] == candidates[k+1])k++;
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
		int[] nums = new int[] { 2,5,2,1,2};
		List<List<Integer>> res = new Q040().combinationSum2(nums, 8);
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
