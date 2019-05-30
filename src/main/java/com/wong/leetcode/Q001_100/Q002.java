package com.wong.leetcode.Q001_100;

import com.wong.leetcode.bean.ListNode;

public class Q002 {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int i1 = 0;
		while (l1 != null) {
			i1 = i1 * 10 + l1.val;
			l1 = l1.next;
		}
		int i2 = 0;
		while (l2 != null) {
			i2 = i2 * 10 + l2.val;
			l2 = l2.next;
		}
		int result = i1 + i2;
		System.out.println(result);
		ListNode header = new ListNode(result % 10);
		ListNode p = header;
		result = result / 10;
		while(result != 0) {
			ListNode cNode = new ListNode(result % 10);
			p.next = cNode;
			result = result / 10;
			p = cNode;
		}
		return header;
	}

	public static void main(String[] args) {
		ListNode l11 = new ListNode(1);
		ListNode l12 = new ListNode(8);
//		ListNode l13 = new ListNode(3);
		ListNode l21 = new ListNode(0);
//		ListNode l22 = new ListNode(6);
//		ListNode l23 = new ListNode(4);
		l11.next = l12;// l12.next = l13;l21.next = l22; l22.next = l23;
		System.out.println(addTwoNumbers(l11,l21));
	}

}
