package com.wong.leetcode.Q001_100;

import com.wong.leetcode.bean.ListNode;

import static com.wong.leetcode.bean.ListNode.*;

public class Q061 {
	
	//先求长度，再快慢指针
	public ListNode rotateRight(ListNode head, int k) {
		ListNode p = head, q = head;
		// 先得到长度
		int len = 0;
		while (p != null) {
			len++;
			p = p.next;
		}
		if (len <= 1) {
			return head;
		}
		k = k % len;
		p = head;
		while (k > 0) {
			p = p.next;
			k--;
		}
		while (p.next != null) {
			p = p.next;
			q = q.next;
		}
		;
		p.next = head;
		head = q.next;
		q.next = null;
		return head;
	}

	/*
	 * 将原链表连成环，再找到相应的点，断开连接
	 */
	public ListNode rotateRight_roll(ListNode head, int k) {
		ListNode p = head;
		// 先得到长度
		int len = 0;
		while (p != null && p.next != null) {
			len++;
			p = p.next;
		}
		len = p == null ? len : len+1;
		if (len <= 1) {
			return head;
		}
		p.next = head;
		k = len - k % len;
		while(k > 0) {
			p = p.next;
			k--;
		}
		ListNode tmp = p.next;
		p.next = null;
		return tmp;
	}

	public static void main(String[] args) {
		ListNode l = transListNode(new int[] {1,2});
		ListNode r = new Q061().rotateRight_roll(l, 99);
		printListNode(r);
	}
}
