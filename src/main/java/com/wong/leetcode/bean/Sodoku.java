package com.wong.leetcode.bean;

public class Sodoku {

	public static char[][] trans(String s) {
		s = s.replace("\"", "");
		char[][] sudoku = new char[9][9];
		int count = 0;
		for (int i = 1; i < s.length() - 1; ++i) {
			char c = s.charAt(i);
			if ((c >= '1' && c <= '9') || c == '.') {
				sudoku[count / 9][count % 9] = c;
				count++;
			}
		}
		return sudoku;
	}
	
	public static void print(char[][] sudoku) {
		for(char[] cc : sudoku) {
			System.out.print("[");
			for(int i=0;i<cc.length-1;++i) {
				System.out.print(cc[i]+"  ");
			}
			System.out.print(cc[cc.length-1]+"]");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		char[][] sudoku = trans("[\r\n" + 
				"  [\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],\r\n" + 
				"  [\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],\r\n" + 
				"  [\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],\r\n" + 
				"  [\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],\r\n" + 
				"  [\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],\r\n" + 
				"  [\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],\r\n" + 
				"  [\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],\r\n" + 
				"  [\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],\r\n" + 
				"  [\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]\r\n" + 
				"]");
		print(sudoku);
	}

}
