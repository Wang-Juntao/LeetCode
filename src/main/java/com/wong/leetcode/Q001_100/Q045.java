package com.wong.leetcode.Q001_100;

public class Q045 {

	public int jump(int[] nums) {
		if(nums.length == 1) {
			return 0;
		}
		return backtrack(nums,0,0,nums.length-1);
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
		int maxPosCanJump = pos + 1;
		for(int i= pos+1;i<= pos + step;i++) {
			//核心在于这句判断，这里选择收益率最高的节点：即本次跳跃+下次可能跳跃的总和，即i+nums[i]
			if(nums[i] + i >= nums[maxPosCanJump] + maxPosCanJump){
				maxPosCanJump = i;
			}
		}
		return backtrack(nums,maxPosCanJump,count+1,minStep);
	}
	
	public static void main(String[] args) {
//		int[] nums = new int[] {2,3,1,1,4};
//		int[] nums = new int[] {2};
		int[] nums = new int[] {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
//		int[] nums = new int[]{10,9,8,7,6,5,4,3,2,1,1,0};
		System.out.println(nums.length);
		System.out.println(new Q045().jump(nums));
	}
}
