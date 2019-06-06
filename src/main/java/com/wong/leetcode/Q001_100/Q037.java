package com.wong.leetcode.Q001_100;

import static com.wong.leetcode.bean.Sodoku.*;

/**
 * 37. 解数独(难度：困难) 编写一个程序，通过已填充的空格来解决数独问题。
 * 
 * 一个数独的解法需遵循如下规则：
 * 
 * 数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 
 * 空白格用 '.' 表示。
 */
public class Q037 {

	int n = 3;
	int N = n * n;

	int[][] rows = new int[N][N + 1];
	int[][] cols = new int[N][N + 1];
	int[][] boxs = new int[N][N + 1];

	char[][] board;

	boolean solved = false;

	public boolean canPlaceNumber(int row, int col, int num) {
		if (rows[row][num] == 0 && cols[col][num] == 0 && boxs[(row / n) * n + col / n][num] == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void placeNumber(int row, int col, int num) {
//		System.out.println(String.format("放置[%d][%d]=%d", row, col, num));
		rows[row][num]++;
		cols[col][num]++;
		boxs[(row / n) * n + col / n][num]++;
		board[row][col] = (char) ('0' + num);
	}

	public void removeNumber(int row, int col, int num) {
//		System.out.println(String.format("移除[%d][%d]=%d", row, col, num));
		rows[row][num]--;
		cols[col][num]--;
		boxs[(row / n) * n + col / n][num]--;
		board[row][col] = '.';
	}
	
	public void placeNextNumer(int row, int col) {
		if (row == N - 1 && col == N - 1) { // 调用的上一句是先填充一个有效的数字，既然可以填充有效，又是最后一个数字，就意味着解决
			solved = true;
		} else {
			if (col == N - 1) {
				backtrack(row + 1, 0);
			} else {
				backtrack(row, col + 1);
			}
		}
	}

	public void backtrack(int row, int col) {
		if (board[row][col] == '.') {
			for (int i = 1; i <= N; i++) {
				if (!solved) {
					if (canPlaceNumber(row, col, i)) {
						placeNumber(row, col, i);
						/*
						 * 	回溯其实就是一个多叉树
						   *      调用这一句即进入当前节点的一个分叉
						   *      当这一句返回时，则这颗分叉已遍历完成，如果此时solved为true，则数独已解。
						 *	同时，犹豫存在短路的原因，不是所有的分叉都需要尝试到[]8[8]。
						 *	比如执行到【0】【7】，   发现已经没有数可以填，那这个时候，分叉就会提前回溯
						 */
						placeNextNumer(row, col);
						if (!solved) {
							removeNumber(row, col, i);
						}
					}
				}
			}
		} else {
			placeNextNumer(row, col);
		}
	}

	/*
	 * 	LeetCode官方给出的回溯解法。 
	 * 	回溯与暴力穷举的区别在于：
	 * 	暴力算法需要先生成数独，再判断有效性；
	 * 	回溯则再填充的过程中就校验当前的路径是否可行
	 */
	public void solveSudoku(char[][] board) {
		this.board = board;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				char num = board[i][j];
				if (num != '.') {
					int d = Character.getNumericValue(num);
					placeNumber(i, j, d);
				}
			}
		}
		backtrack(0, 0);
	}

	public static void main(String[] args) {
//		char[][] board = new char[][] { 
//			{'5','3','.','.','7','.','.','.','.'}, 
//			{'6','.','.','1','9','5','.','.','.'}, 
//			{'.','9','8','.','.','.','.','6','.'}, 
//			{'8','.','.','.','6','.','.','.','3'}, 
//			{'4','.','.','8','.','3','.','.','1'}, 
//			{'7','.','.','.','2','.','.','.','6'}, 
//			{'.','6','.','.','.','.','2','8','.'}, 
//			{'.','.','.','4','1','9','.','.','5'}, 
//			{'.','.','.','.','8','.','.','7','9'} 
//			};
		char[][] board = new char[][] { // 据说是世界上最难的数独
				{ '.', '.', '5', '3', '.', '.', '.', '.', '.' },
				{ '8', '.', '.', '.', '.', '.', '.', '2', '.' },
				{ '.', '7', '.', '.', '1', '.', '5', '.', '.' }, 
				{ '4', '.', '.', '.', '.', '5', '3', '.', '.' },
				{ '.', '1', '.', '.', '7', '.', '.', '.', '6' }, 
				{ '.', '.', '3', '2', '.', '.', '.', '8', '.' },
				{ '.', '6', '.', '5', '.', '.', '.', '.', '9' }, 
				{ '.', '.', '4', '.', '.', '.', '.', '3', '.' },
				{ '.', '.', '.', '.', '.', '9', '7', '.', '.' } };
//		print(board);
		new Q037().solveSudoku(board);
		print(board);
		System.out.println(new Q036().isValidSudoku(board));
	}

}
