package com.wong.leetcode.Q001_100;


public class Q060 {

	int target;
	int N;
	/*
	 * 回溯法，参考了leetcode的题解
	 * 最初版的时候按照46题全排列的思路，这样中间会发生很多次不必要的排序，而我们只需要一个解
	 * 回溯算法的求解过程就是一颗数，而我们需要的解就是其中的一条路径，那么我们就是先找到这条路径
	 * 对于每一层level，设第一层level=1，那么每一个节点下边有(n-level)!个解，
	 * 我们从第一层开始，每一层确定一个节点，最终可以找到这条唯一的路径
	 */
	public String getPermutation(int n, int k) {
		if (n == 1) {
			return "1";
		}
		N = n;
		target = k;
		char[] ctmp = new char[N];
		backtrack(ctmp, new int[N],0);
		return new String(ctmp);
	}
	//
	public void backtrack(char[] ctmp, int[] visted,int pos) {
		if (pos >= N) {
			return;
		}
		int factor = Factorial(N - 1 - pos);
		for (int i = 0; i < N; i++) {
			if (visted[i] == 0) {
				if(target - factor > 0) {
					target -= factor;
				}else {
						ctmp[pos] = (char) (i + 1 + '0');
						visted[i] = 1;
						backtrack(ctmp, visted,pos+1);
					}
			}
		}
	}
	
	public int Factorial(int n) {
		if(n == 0) {
			return 1;
		}
		int res = n;
		for (int i = n - 1; i > 0; i--)
			res *= i;
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Q060().getPermutation(9, 362820));
	}
}
