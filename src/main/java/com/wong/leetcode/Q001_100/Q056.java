package com.wong.leetcode.Q001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 
 * 示例 1:
 * 
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5] 输出: [[1,5],[6,9]]
 * 
 * 示例 2:
 * 
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8] 输出:
 * [[1,2],[3,10],[12,16]] 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 
 */
public class Q056 {

	public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1) {
			return intervals;
		}
		List<int[]> res = new ArrayList<>();
		Arrays.sort(intervals, new Comparator<int[]>() {// leetcode-cn的oj对lambda表达式执行效率很低，避免使用
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
//		int start = intervals[0][0] , end = intervals[0][1];
		for (int i = 0; i < intervals.length; i++) {
			if (res.isEmpty() || res.get(res.size() - 1)[1] < intervals[i][0]) {
				res.add(intervals[i]);
			} else {
				res.get(res.size() - 1)[1] = Math.max(intervals[i][1], res.get(res.size() - 1)[1]);
			}
		}
//		res.add(new int[] {start,end});
		return res.toArray(new int[0][2]);
	}

	public static void main(String[] args) {
		int[][] intervals = new int[][] { { 1, 6 }, { 2, 3 }, { 3, 4 } };
		int[][] res = new Q056().merge(intervals);
		for (int[] in : res) {
			System.out.println("[" + in[0] + "," + in[1] + "]");
		}
	}

}
