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

	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		ListNode l = transListNode(new int[] {1,2,3,4});
		ListNode r = new Q024().swapPairs(l);
		printListNode(r);
	}
	
	

}
