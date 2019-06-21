package com.wong.leetcode.Q001_100;


/**
 * 52. N皇后 II
 */
public class Q052 {

	
	
	int count = 0;
	int N;
	int[] queen ;
	
	//如果只使用一个queen数组的话，在判断是否可放置，则必须使用一个循环，这必然增大时间复杂度
	//所以可用用数组缓存数据用于判断是否可放置，因为数组定位元素是O(1)时间复杂度的，可以用空间来换时间
	int[] rows;// 当前行是否有皇后 有则为1
	int[] hills;// 斜上角度是否有皇后，每一条斜上线上的点row+col值相等
	int[] dales;// 斜下角度是否有皇后，每一条斜下线上的点row-col值相等
	
	int sovleCount = 0;
	
	public int totalNQueens(int n) {
		N = n;
		init(n);
		backtrace(0);
		return sovleCount;
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
	public void backtrace(int col) {
		if(count == N) {
			sovleCount++;
			return;
		}
		for(int row = 0;row<N;row++) {
			if (canPlace(row,col)) {
				putOne(row, col);
				backtrace(col+1);
				removeOne(row, col);
			} 
		}
	}
	
	public boolean canPlace(int row, int col) {
		int res = rows[row] + hills[row+col] + dales[row-col + N];
		return res == 0 ;
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
	
	public static void main(String[] args) {
		System.out.println(new Q052().totalNQueens(20));
	}

}
