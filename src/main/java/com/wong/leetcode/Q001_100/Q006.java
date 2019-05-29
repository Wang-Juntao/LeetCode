package com.wong.leetcode.Q001_100;

public class Q006 {
	/**
	 * 比较直观的算法，先排好，再遍历
	 * 执行用时 : 57 ms, 在ZigZag Conversion的Java提交中击败了48.38% 的用户
	 * 内存消耗 : 48.6 MB, 在ZigZag Conversion的Java提交中击败了63.18% 的用户
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert(String s, int numRows) {
		if(numRows <= 1) {
			return s;
		}
		char[][] zag = new char[Math.min(s.length(), numRows)][s.length()/2+1]; //粗略估计，最大应该是1/2
		int x = 0;
		int y = 0;
		boolean isdown = true; //这里只有两个方向，向下和斜向上
		for(int i=0;i<s.length();++i) {
			zag[x][y] = s.charAt(i);
			//计算下一个位置
			if (isdown) {
				if (x + 1 >= numRows) {// 触底
					isdown = false;
					x = x - 1;
					y = y + 1;
				} else {
					x = x + 1;
				}
			} else {
				if (x - 1 < 0) {//达到最高点
					isdown = true;
					x = x + 1;
				} else {
					x = x - 1;
					y = y + 1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<zag.length;++i) {
			for(int j=0;j<zag[i].length;++j) {
				if(zag[i][j] != '\0') {
					sb.append(zag[i][j]);
				}
			}
		}
		return sb.toString();
    }
	
	public static void main(String[] args) {
		String str = "LEETCODEISHIRING";
		System.out.println(convert(str,4));
	}
}
