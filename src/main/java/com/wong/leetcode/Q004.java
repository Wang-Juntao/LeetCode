package com.wong.leetcode;

/**
 * 
 * @author weien
 *
 */
public class Q004 {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length == 0) {
			return nums2.length % 2 == 0 ? (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2] ) / 2f : nums2[nums2.length / 2];
		}else if(nums2.length == 0) {
			return nums1.length % 2 == 0 ? (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2] ) / 2f : nums1[nums1.length / 2];
		}
		int sum = nums1.length + nums2.length;
		int point = sum % 2 == 0 ? sum / 2  : sum / 2 + 1;
		int idx1 = 0;
		int idx2 = 0;
		int filtered = 0;
		boolean isOneFinsh = false;
		while (filtered < point - 1 && !isOneFinsh) {
			if (nums1[idx1] < nums2[idx2]) {
				++idx1;
				isOneFinsh = idx1 >= nums1.length;
			} else {
				++idx2;
				isOneFinsh = idx2 >= nums2.length;
			}
			++filtered;
			System.out.println(String.format("[%d : %d : %d :%d : %b]", filtered, point, idx1, idx2,isOneFinsh));
		}
		if (isOneFinsh) {
			int[] nums = idx1 >= nums1.length ? nums2 : nums1;
			int length = idx1 >= nums1.length ? nums1.length : nums2.length;
			return sum % 2 == 0 ? (nums[point - length -1] + nums[point - length]) / 2f : nums[point - length -1 ];
		} else {
			if(sum % 2 == 0) {
				if(nums1[idx1] < nums2[idx2] && idx1 < nums1.length - 1 && nums2[idx2] > nums1[idx1+1]) {
					return (nums1[idx1] + nums1[idx1+1]) /2f;
				}else if(nums2[idx2] < nums1[idx1] && idx2 < nums2.length -1 && nums1[idx1] > nums2[idx2+1]) {
					return (nums2[idx2] + nums2[idx2+1]) /2f;
				}else {
					return (nums1[idx1] + nums2[idx2]) /2f;
				}
			}else {
				return (nums1[idx1] > nums2[idx2] ? nums2[idx2] : nums1[idx1]);
			}
		}

	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 2,3,4};
		int[] nums2 = new int[] {1};
		System.out.println(findMedianSortedArrays(nums2, nums1));
	}

}
