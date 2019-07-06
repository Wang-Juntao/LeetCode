package com.wong.leetcode.Q001_100;

/**
 * 72. 编辑距离(难度：困难)
 * 
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 
 * 你可以对一个单词进行如下三种操作：
 * 
 * 插入一个字符 删除一个字符 替换一个字符
 * 
 * 示例 1:
 * 
 * 输入: word1 = "horse", word2 = "ros" 输出: 3 解释: horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r') rose -> ros (删除 'e')
 * 
 * 示例 2:
 * 
 * 输入: word1 = "intention", word2 = "execution" 输出: 5 解释: intention -> inention
 * (删除 't') inention -> enention (将 'i' 替换为 'e') enention -> exention (将 'n' 替换为
 * 'x') exention -> exection (将 'n' 替换为 'c') exection -> execution (插入 'u')
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Q072 {
	
	/*
	 * 	 看了相关知识，看到了动态规划，但是想不出怎么运用动态规划，所以直接看了题解
	 * 官方的题解跳跃太大，可以看看这个题解
	 * 	https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
	 * 总的来说就是一个二维dp数组，
	 */
	public int minDistance(String word1, String word2) {
		
		int[][] dp = new int[word1.length()+1][word2.length()+1];
		
		for(int i=1;i<=word1.length();i++) dp[i][0] = i;
		for(int i=1;i<=word2.length();i++) dp[0][i] = i;
		
		for(int i=1;i<=word1.length();i++) {
			for(int j=1;j<=word2.length();j++) {
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1]+1, dp[i-1][j]),dp[i][j-1]);
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}
	
	public static void main(String[] args) {
		String w1 = "";
		String w2 = "a";
		System.out.println(new Q072().minDistance(w1, w2));
	}

}
