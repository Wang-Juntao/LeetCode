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

	char[][] tmp;
	int count = 0;
	int N;

	// 放置一个皇后，则将该皇后可达位置标记为'x',如果回溯失败则重置为' . '
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		N = n;
		init(n);
		backtrace(res, 0, 0);
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//			}
//		}
		return res;
	}

	public void init(int n) {
		char[][] cc = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cc[i][j] = '.';
			}
		}
		tmp = cc;
	}

	public void backtrace(List<List<String>> res, int x, int y) {
		if (tmp[x][y] == '.') {
			put(tmp, x, y);
			placeNext(res, x, y);
			remove(tmp, x, y);
		} else {
			placeNext(res, x, y);
		}
	}

	public void placeNext(List<List<String>> res, int x, int y) {
		if (count == N) {
			List<String> list = new ArrayList<>();
			for (char[] cc : tmp) {
				list.add(new String(cc).replace('x', '.'));
			}
			res.add(list);
			return;
		}
		if (y == N - 1) {
			if (x >= N - 1) {
				return;
			}
			backtrace(res, x + 1, 0);
		} else {
			backtrace(res, x, y + 1);
		}
	}

	public void put(char[][] tmp, int x, int y) {
		for (int i = 0; i < tmp.length; ++i) {
			tmp[i][y] = 'x';
			tmp[x][i] = 'x';
			int x1 = i, y1 = i - x + y;
			if (y1 >= 0 && y1 < tmp.length) {
				tmp[x1][y1] = 'x';
			}
			int x2 = i, y2 = x + y - i;
			if (y2 >= 0 && y2 < tmp.length) {
				tmp[x2][y2] = 'x';
			}
		}
		tmp[x][y] = 'Q';
		count++;
		System.out.println(String.format("放置(%d,%d),count=%d", x, y, count));
	}

	public void remove(char[][] tmp, int x, int y) {
		for (int i = 0; i < tmp.length; ++i) {
			tmp[i][y] = '.';
			tmp[x][i] = '.';
			int x1 = i, y1 = i - x + y;
			if (y1 >= 0 && y1 < tmp.length) {
				tmp[x1][y1] = '.';
			}
			int x2 = i, y2 = x + y - i;
			if (y2 >= 0 && y2 < tmp.length) {
				tmp[x2][y2] = '.';
			}
		}
		count--;
		System.out.println(String.format("移除(%d,%d),count=%d", x, y, count));
	}

	public void print(char[][] tmp) {
		for (char[] cc : tmp) {
			for (char c : cc) {
				System.out.print(c + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		List<List<String>> list = new Q051().solveNQueens(5);
		for (List<String> l : list) {
			System.out.println("---------------------");
			for (String s : l) {
				System.out.println(s);
			}
			System.out.println("---------------------");
		}
//		char[][] tmp = new char[][] {{'.','.','.','.','.'},{'.','.','.','.','.'},{'.','.','.','.','.'},{'.','.','.','.','.'},{'.','.','.','.','.'}};
//		Q051 q = new Q051();
//		q.put(tmp, 2, 2);
//		q.print(tmp);
//		System.out.println();
//		q.remove(tmp, 2, 2);
//		q.print(tmp);
	}

}
