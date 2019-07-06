package com.wong.leetcode.Q001_100;

import java.util.ArrayList;
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
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Q057 {

	public int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals.length == 0) {
			return new int[][] { newInterval };
		}
		if (newInterval.length < 2) {
			return intervals;
		}
		List<int[]> res = new ArrayList<>();
		int pos = 0;
		boolean isAdded = false;
		while (pos <= intervals.length) {
			int[] tmp;
			if (pos < intervals.length && (intervals[pos][0] < newInterval[0] || isAdded)) {
				tmp = intervals[pos];
				pos++;
			} else {
				tmp = newInterval;
				isAdded = true;
				if (pos == intervals.length) {
					pos++;
				}
			}
			if (res.size() == 0 || res.get(res.size() - 1)[1] < tmp[0]) {
				res.add(tmp);
			} else {
				res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], tmp[1]);
			}
		}
		return res.toArray(new int[][] {});
	}

	public static void main(String[] args) {
		int[][] intervals = new int[][] { { 4, 8 } };
		int[] newInterval = new int[] {};
		int[][] res = new Q057().insert(intervals, newInterval);
		for (int[] in : res) {
			System.out.println("[" + in[0] + "," + in[1] + "]");
		}
	}

}
