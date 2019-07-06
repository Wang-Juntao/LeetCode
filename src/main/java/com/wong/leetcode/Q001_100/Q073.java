package com.wong.leetcode.Q001_100;

/**
 * 73. 矩阵置零(难度：中等)
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 
 * 示例 1:
 * 
 * 输入: [ [1,1,1], [1,0,1], [1,1,1] ] 输出: [ [1,0,1], [0,0,0], [1,0,1] ]
 * 
 * 示例 2:
 * 
 * 输入: [ [0,1,2,0], [3,4,5,2], [1,3,1,5] ] 输出: [ [0,0,0,0], [0,4,5,0], [0,3,1,0]
 * ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Q073 {
	/*
	 * 	一开始想到用两个数组存放标志位，但这样空间占用比较大，
	 * 	后来想到其实第一行和第一列可以用来存放这个标志位，当某一行或者某一列为0时可以将该行或者该列的第一个元素置为0
	 * 	然后利用这个标志位进行处理。
	 * 有两点需要注意：
	 * 1.第一行，第一列因为保存着标志位，需单独处理
	 * 2.如果用matrix[0][0]=0是不知道是第一行有零，还是第一列有零，所以需要另外一个标志
	 */
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		final int ROW0 = 1;//第一行有零
		final int COL0 = 2;//第一列有零
//		int[] row = new int[m];我们只需要知道哪一行那一列需要被置零，所以需要保存m+n个标志位
//		int[] col = new int[n];
		int flag = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0) {
						flag = flag | ROW0;//通过与或运算可以更清晰的判断
					}
					if (j == 0) {
						flag = flag | COL0;
					}
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int j = 1; j < n; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}
		if (matrix[0][0] == 0) {
			if ((flag & ROW0) == ROW0) {//通过与或运算可以更清晰的判断
				for (int j = 0; j < n; j++)
					matrix[0][j] = 0;
			}
			if ((flag & COL0) == COL0) {
				for (int i = 0; i < m; i++)
					matrix[i][0] = 0;
			}
		}

	}

	// [[0, 1, 0, 0],
	// [0, 4, 0, 2],
	// [1, 3, 1, 5]]
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 1, 0 }, { 1, 1, 2 }, { 0, 1, 2 } };
		new Q073().setZeroes(matrix);
		for (int[] ii : matrix) {
			System.out.print(" ");
			for (int i : ii) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

//		int flag = 0;
//		flag = flag | 2;
//		flag = flag | 1;
//		System.out.println(flag & 2);
//		System.out.println(flag);
	}

}
