package com.wong.leetcode.Q001_100;

import com.wong.leetcode.bean.ListNode;
import static com.wong.leetcode.bean.ListNode.*;

/**
 * 24. 两两交换链表中的节点
 * 
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 示例:
 * 
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 */
public class Q024 {

	// 递归 每次只交换头两个元素
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode h1 = head;
		ListNode h2 = head.next;
		ListNode tail = h2.next;
		h2.next = h1;
		h1.next = swapPairs(tail);
		return h2;
	}

	// 普通循环
	public ListNode swapPairs_v2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;
		ListNode q = p.next;
		while (q != null && q.next != null) {
			ListNode l = p.next;
			ListNode r = q.next;
			p.next = q.next;
			l.next = r.next;
			r.next = l;
			p = l;
			q = p.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l = transListNode(new int[] { 1, 2,3,4 });
		ListNode r = new Q024().swapPairs_v2(l);
		printListNode(r);
	}

}
