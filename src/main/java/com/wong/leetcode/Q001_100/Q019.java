package com.wong.leetcode.Q001_100;

import com.wong.leetcode.bean.ListNode;
import static com.wong.leetcode.bean.ListNode.*;
/**
 * 19. 删除链表的倒数第N个节点 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 * 示例：
 * 
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 
 * 说明：
 * 
 * 给定的 n 保证是有效的。
 * 
 *
 */
public class Q019 {
	//第一版，不考虑优化
	public ListNode removeNthFromEnd(ListNode head, int n) {
		//先遍历，得到n
		ListNode p = head;
		int length = 0;
		while (p != null) {
			length++;
			p = p.next;
		}
		ListNode vh = new ListNode(0); //增加一个虚拟的header，已应对移除头部节点的情况
		vh.next = head;
		int target = length - n;
		p = vh;
		while(target > 0) {
			target--;
			p = p.next;
		}
		p.next = p.next.next;
		return vh.next;
	}
	
	// 第二版，两步走，利用p，q两个指针，先让p走n步，再让p,q同时走，当p走到末尾时，q指向的就是我们需要的节点（即为倒数n-1位）
	public ListNode removeNthFromEnd_V2(ListNode head, int n) {
		ListNode vh = new ListNode(0); // 增加一个虚拟的header，已应对移除头部节点的情况
		vh.next = head;
		ListNode p = vh;
		ListNode q = vh;
		while(n > 0) {
			p = p.next;
			n--;
		}
		while(p.next != null) {
			p = p.next;
			q = q.next;
		}
		q.next = q.next.next;
		return vh.next;
	}


	public static void main(String[] args) {
		Q019 q = new Q019();
		ListNode header = transListNode(new int[]{1,2,3,4,5});
		ListNode rr = q.removeNthFromEnd_V2(header, 1);
		printListNode(rr);
	}
}
