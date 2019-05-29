package com.wong.leetcode.Q001_100;

/**
 * 21. 合并两个有序链表
 * 
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 * 
 */
public class Q021 {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode cur = new ListNode(0); //增加虚拟节点，使逻辑简化，同时可以顺便实现null检查
		ListNode pp = cur;
		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				pp.next = p1;
				pp = p1;
				p1 = p1.next;
			} else {
				pp.next = p2;
				pp = p2;
				p2 = p2.next;
			}
		}
		if (p1 != null) {
			pp.next = p1;
		} else if (p2 != null) {
			pp.next = p2;
		}
		return cur.next;
	}

	// 递归，真的好久不写，现在都没有递归思路了
	public static ListNode mergeTwoLists_recursion(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists_recursion(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists_recursion(l1, l2.next);
			return l2;
		}
	}

	public static void main(String[] args) {
		ListNode l1 = transListNode(new int[] { 7 });
		ListNode l2 = transListNode(new int[] { 4, 5, 6 });
		ListNode l3 = mergeTwoLists(l1, l2);
		printListNode(l3);
	}

	public static ListNode transListNode(int[] nums) {
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

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		public String toString() {
			return val + "";
		}
	}

}
