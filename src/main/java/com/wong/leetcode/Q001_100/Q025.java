package com.wong.leetcode.Q001_100;

import com.wong.leetcode.bean.ListNode;
import static com.wong.leetcode.bean.ListNode.*;

/**
 * 25. K 个一组翻转链表
 * 
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 示例 :
 * 
 * 给定这个链表：1->2->3->4->5
 * 
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 
 * 说明 :
 * 
 * 你的算法只能使用常数的额外空间。 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Q025 {

	// 普通遍历
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = head;
		ListNode[] tmp = new ListNode[k]; // 用数组保存，也可以用栈，代码会更简单
		int pos = 0;// 记录当前数组已填充的数量
		ListNode pre = dummy;// 记录每个分组的上一个节点
		while (p != null || pos == k) { // 每达到k个，组内进行翻转
			if (pos == k) {// 由于达到k个时才会翻转，所以当剩余数量小于k时，就不会反转
				ListNode last = tmp[k - 1].next;
				for (int i = k - 1; i > 0; --i) {
					tmp[i].next = tmp[i - 1];
				}
				tmp[0].next = last;
				pre.next = tmp[k - 1];
				pre = tmp[0];
				pos = 0;
			} else {
				tmp[pos++] = p;
				p = p.next;
			}
		}
		return dummy.next;
	}

	// 尝试递归
	public ListNode reverseKGroup_v2(ListNode head, int k) {
		ListNode cur = head;
		int count = 0;
		while (cur != null && count != k) {
			cur = cur.next;
			count += 1;
		}
		if (count == k) {
			cur = reverseKGroup(cur, k);
			while (count > 0) {//反转前k个节点
				ListNode tmp = head.next;
				head.next = cur;
				cur = head;
				head = tmp;
				count -= 1;
			}
			head = cur;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode l = transListNode(new int[] { 1, 2, 3, 4 });
		ListNode r = new Q025().reverseKGroup_v2(l, 3);
		printListNode(r);
	}

}
