package com.wong.leetcode.Q001_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N皇后 n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4 输出: [ [".Q..", // 解法 1 "...Q", "Q...", "..Q."],
 * 
 * ["..Q.", // 解法 2 "Q...", "...Q", ".Q.."] ] 解释: 4 皇后问题存在两个不同的解法。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q051 {

	int count = 0;
	int N;
	int[] queen ;
	
	//如果只使用一个queen数组的话，在判断是否可放置，则必须使用一个循环，这必然增大时间复杂度
	//所以可用用数组缓存数据用于判断是否可放置，因为数组定位元素是O(1)时间复杂度的，可以用空间来换时间
	int[] rows;// 当前行是否有皇后 有则为1
	int[] hills;// 斜上角度是否有皇后，每一条斜上线上的点row+col值相等
	int[] dales;// 斜下角度是否有皇后，每一条斜下线上的点row-col值相等
	
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		N = n;
		init(n);
		backtrace(res, 0);
		return res;
	}

	public void init(int n) {
		int[] xx = new int[N];
		for (int i = 0; i < n; i++) {
			xx[i] = -1;
		}
		queen = xx;
		rows = new int[N];
		hills = new int[N*2];
		dales = new int[N*2];
	}
	//N皇后问题的解是每个皇后必须不能再同一列上（或同一行上）
	//那么只需要每个
	public void backtrace(List<List<String>> res, int col) {
		if(count == N) {
			res.add(convert());
			return;
		}
		for(int row = 0;row<N;row++) {
			if (canPlace(row,col)) {
				putOne(row, col);
				backtrace(res, col+1);
				removeOne(row, col);
			} 
		}
	}
	
	public boolean canPlace(int row, int col) {
		int res = rows[row] + hills[row+col] + dales[row-col + N];
		return res == 0 ;
		
//		for (int i = 0; i < count; i++) {
//			if (queen[i] == row || row + col == i + queen[i] || row - col == queen[i] - i) {
//				return false;
//			}
//		}
//		return true;
	}
	
	public void putOne(int row, int col) {
		queen[col] = row;
		rows[row] = 1;
		hills[row+col] = 1;
		dales[row-col + N] = 1;
		count++;
	}
	
	public void removeOne(int row,int col) {
		queen[col] = -1;
		rows[row] = 0;
		hills[row+col] = 0;
		dales[row-col + N] = 0;
		count--;
	}
	
	public List<String> convert(){
		List<String> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<N;j++) {
				sb.append(queen[j] == i ? 'Q' : '.');
			}
			list.add(sb.toString());
		}
		return list;
	}
	
	public static void main(String[] args) {
		List<List<String>> list = new Q051().solveNQueens(20);
		System.out.println(list.size());
		for (List<String> l : list) {
			System.out.println("---------------------");
			for (String s : l) {
				System.out.println(s);
			}
			System.out.println("---------------------");
		}
	}

}
