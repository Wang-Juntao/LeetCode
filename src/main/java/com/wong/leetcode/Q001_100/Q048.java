package com.wong.leetcode.Q001_100;

/**
 * 48. 旋转图像 给定一个 n × n 的二维矩阵表示一个图像。
 * 
 * 将图像顺时针旋转 90 度。
 * 
 * 说明：
 * 
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 
 */
public class Q048 {
	/*
	 * 	首先顺时针90度旋转 坐标转换函数f(x,y) = (y,n-1-x);(自己运算)
	 * 	同样可得逆时针旋转函数为f(x,y) = (n-1-x,y);
	 * 	接下来讲解算法：
	 * 	1.可以发现旋转时数据只在一个环上旋转，从里到外共有 n/2个
	 *  2.对于每一个环（长度length），每次只旋转四个数，可以根据坐标转换函数得到每个目标位，每个环需要循环length-1次
	 *  3.对于单次循环，可以做一个优化：
	 *  	比如正常思路应该是 a1->a2->a3->a4->a1,这样的顺序，但这样需要缓存a2,a3的值
	 *  	我们可以缓存a4的值，然后按照 a3->a4,	a2->a3,	a1->a2 ,的顺序赋值，最后再对a1赋值
	 */
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int k = i; k < n - 1 - i; k++)
			{
				int t;
				t = matrix[n - 1 - k][i];
				matrix[n - 1 - k][i] = matrix[n - 1 - i][n - 1 - k];
				matrix[n - 1 - i][n - 1 - k] = matrix[k][n - 1 - i];
				matrix[k][n - 1 - i] = matrix[i][k];
				matrix[i][k] = t;
				System.out.println(String.format("(%d,%d),(%d,%d),(%d,%d),(%d,%d)", 
						n - 1 - k, i, 
						n - 1 - i, n - 1 - k,
						k, n - 1 - i, 
						i, k));
			}
		}
	}
	
	public void xx(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int tmp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = tmp;
			}
		}

	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { 
			{1,	2,	3,	4,	5},
			{6,	7,	8,	9,	10},
			{11,12,	13,	14,	15},
			{16,17,	18,	19,	20},
			{21,22,	23,	24,	25} };
//		int[][] matrix = new int[][] { 
//			{ 2, 29, 20, 26, 16, 28 }, 
//			{ 12, 27, 9, 25, 13, 21 }, 
//			{ 32, 33, 32, 2, 28, 14 },
//			{ 13, 14, 32, 27, 22, 26 }, 
//			{ 33, 1, 20, 7, 21, 7 }, 
//			{ 4, 24, 1, 6, 32, 34 } };
		new Q048().xx(matrix);
		for (int[] row : matrix) {
			System.out.print("[\t");
			for (int i : row) {
				System.out.print(i + "\t");
			}
			System.out.println("]");
		}
	}

}
