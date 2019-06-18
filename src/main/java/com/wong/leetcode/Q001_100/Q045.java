package com.wong.leetcode.Q001_100;

public class Q045 {

	public int jump(int[] nums) {
		if(nums.length == 1) {
			return 0;
		}
		return backtrack(nums,0,0,nums.length-nums[0]);
	}
	public int backtrack(int[] nums,int pos, int count,int minStep) {
		if(pos == nums.length - 1) {
			return count;
		}
		if(count >= minStep) {
			return minStep;
		}
		int step = nums[pos];
		if(pos + step >= nums.length -1 ) {
			return count + 1;
		}
		for(int i= pos+1;i< nums.length && i<= pos + step;i++) {
			if(nums[i] > (i-pos)) {
				int cstep = backtrack(nums,i,count+1,minStep);
				if( cstep < minStep) {
					minStep = cstep;
				}
			}
		}
		return minStep;
	}
	
	public static void main(String[] args) {
//		int[] nums = new int[] {2,3,1,1,4};
//		int[] nums = new int[] {2,3};
		int[] nums = new int[] {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
		System.out.println(nums.length);
		System.out.println(new Q045().jump(nums));
	}
}
