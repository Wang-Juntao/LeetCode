package com.wong.leetcode.Q001_100;

/**
 * 59. 螺旋矩阵 II 
 * 
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 
 * 示例:
 * 
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Q059 {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		if(n <= 0) {
			return matrix;
		}
		int r1 = 0, r2 = n-1;
		int c1 = 0, c2 = n-1;
		int count = 1;
		while (r1 <= r2 && c1 <= c2) {
			for (int c = c1; c <= c2; c++)
				matrix[r1][c] = count++;
			for (int r = r1 + 1; r <= r2; r++)
				matrix[r][c2] = count++;
			if (r1 < r2 && c1 < c2) {
				for (int c = c2 - 1; c > c1; c--)
					matrix[r2][c]  = count++;
				for (int r = r2; r > r1; r--)
					matrix[r][c1]  = count++;
			}
			r1++;
			r2--;
			c1++;
			c2--;
		}
		return matrix;
	}
	public static void main(String[] args) {
		int[][] res = new Q059().generateMatrix(9);
		for(int[] mm : res ) {
			System.out.print("[ ");
			for(int i : mm) {
				System.out.print(i+" ");
			}
			System.out.println("]");
		}
	}
}
