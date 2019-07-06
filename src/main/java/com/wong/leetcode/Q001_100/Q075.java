package com.wong.leetcode.Q001_100;

import java.util.Arrays;

public class Q075 {
	public void sortColors(int[] nums) {
		int[] count = new int[3];
		for (int i = 0; i < nums.length; i++) {
			count[nums[i]] += 1;
		}
		int pos = nums.length - 1;
		for (int i = 2; i >= 0; i--) {
			while (count[i] > 0) {
				nums[pos] = i;
				count[i]--;
				pos--;
			}
		}
	}
	
	public void sortColors_Two(int[] nums) {
		int p1=0,cur=0,p2=nums.length-1;
		while(cur <= p2) {
			if(nums[cur] == 0) {
				//交换
				int tmp = nums[cur] ;
				nums[cur] = nums[p1];
				nums[p1] = tmp;
				p1 ++;
//				cur ++; 这一行注释掉也不会影响结果，但会多循环几次，所以为什么可以加这一行代码呢？
			}else if(nums[cur] == 2) {
				int tmp = nums[cur] ;
				nums[cur] = nums[p2];
				nums[p2] = tmp;
				p2 --;
				//cur ++; 有一个小点要注意，这里是不需要把游标前移
				//因为游标前移的话，会跳过交换的那个数，导致漏判断一个
				//那么为什么0的时候需要，而2的时候不需要了呢？
				//原因如下：如果出现“ 0,0,2(p1),0(cur) ”这种情况，则直接将游标前移是错误的，
				//但可能出现这种情况嘛 
			}else {
				cur ++;
			}
		}
		
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1,0,2,0,1,1,1,1,0,1,2,2,0,1};
		new Q075().sortColors_Two(nums);
		Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
	}
}
