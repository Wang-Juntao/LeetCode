package com.wong.leetcode.bean;

public class ListNode {

	public static ListNode transListNode(int[] nums) {
		if(nums == null || nums.length == 0)
			return null;
		ListNode header = new ListNode(nums[0]);
		ListNode p = header;
		for (int i = 1; i < nums.length; ++i) {
			ListNode n = new ListNode(nums[i]);
			p.next = n;
			p = n;
		}
		return header;
	}

	public static void printListNode(ListNode header) {
		ListNode p = header;
		while (p != null) {
			System.out.print(p.val + (p.next != null ? "->" : ""));
			p = p.next;
		}
	}

	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	public String toString() {
		return val + "";
	}

}
