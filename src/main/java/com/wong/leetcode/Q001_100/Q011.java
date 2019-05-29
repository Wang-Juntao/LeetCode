package com.wong.leetcode.Q001_100;

public class Q011 {
	
	public static int maxArea(int[] height) {
		int max =0;
		for (int i = 0; i < height.length - 1; ++i) {
			for (int j = i + 1; j < height.length; ++j) {
				int area = (j - i) * Math.min(height[i], height[j]);
				System.out.println(String.format("(%d-%d)*min(%d,%d)=%d", j,i,height[i], height[j],area));
				if (area > max) {
					max = area;
				}
			}
		}
		return max;
	}
	
	public static int maxArea2(int[] height) {
		 if(height.length <= 1) return -1;
	        int i = 0, j = height.length - 1, res = 0;
	        while(i < j){
	            int h = Math.min(height[i], height[j]);
	            res = Math.max(res, h * (j - i));
	            if(height[i] < height[j]) ++i;
	            else --j;
	        }
	        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(maxArea2(new int[] {1,2,3,4,5,6,7,6,53,2,5}));
	}

}
