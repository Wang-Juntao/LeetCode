package com.wong.leetcode.Q001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例: 输入: [ 1->4->5, 1->3->4, 2->6 ] 输出: 1->1->2->3->4->4->5->6
 */
public class Q023 {
	
	// 第一版，把k个合并转换为k-1次2个链表合并，效率必然很低 （属于25%之后的）
	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		} else if (lists.length == 1) {
			return lists[0];
		}
		ListNode n = mergeTwoLists(lists[0], lists[1]);
		for (int i = 2; i < lists.length; ++i) {
			n = mergeTwoLists(n, lists[i]);
		}
		return n;
	}
	//同步遍历 450+ms
	public static ListNode mergeKLists_V2(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		ListNode cur = new ListNode(0); // 增加虚拟节点，使逻辑简化，同时可以顺便实现null检查
		ListNode pp = cur;
		ListNode[] ps = new ListNode[lists.length];
		for (int i = 0; i < lists.length; ++i) {
			ps[i] = lists[i];
		}
		boolean hasNode = true;
		while (hasNode) {
			ListNode minNode = null;
			int pos = -1;
			for (int i = 0; i < ps.length; ++i) {
				if (minNode == null || (ps[i] != null && minNode.val > ps[i].val)) {
					minNode = ps[i];
					pos = i;
				}
			}
			if (minNode != null) {
				ps[pos] = ps[pos].next;
				pp.next = minNode;
				pp = minNode;
			} else {
				hasNode = false;
			}
		}
		return cur.next;
	}
	//先收集数字，排序后新建链表 80+ms
	public static ListNode mergeKLists_V3(ListNode[] lists) {
		List<Integer> nums = new ArrayList<>();
		for (ListNode p : lists) {
			while (p != null) {
				nums.add(p.val);
				p = p.next;
			}
		}
		ListNode cur = new ListNode(0);
		ListNode p = cur;
		nums.sort((x1, x2) -> x1 - x2);
		for (Integer i : nums) {
			ListNode n = new ListNode(i);
			p.next = n;
			p = n;
		}
		return cur.next;
	}
	//利用优先级队列 80+ms
	public static ListNode mergeKLists_V4(ListNode[] lists) {
		Queue<ListNode> q = new PriorityQueue<>((x1,x2)->x1.val - x2.val);
		for (ListNode p : lists) {
			if (p != null) {
				q.add(p);
			}
		}
		ListNode cur = new ListNode(0); // 增加虚拟节点，使逻辑简化，同时可以顺便实现null检查
		ListNode pp = cur;
		while (!q.isEmpty()) {
			ListNode minNode = q.poll();
			pp.next = minNode;
			pp = minNode;
			minNode = minNode.next;
			if(minNode != null) {
				q.add(minNode);
			}
		}
		return cur.next;
	}
	//归并 目前最快的算法 6ms
	public static ListNode mergeKLists_V5(ListNode[] lists) {
		if(lists == null || lists.length == 0) {
			return null;
		}else if (lists.length == 1) {
			return lists[0];
		}else if(lists.length == 2) {
			return mergeTwoLists(lists[0],lists[1]);
		}else {
			int pos = lists.length /2 ;
			ListNode[] ll = Arrays.copyOfRange(lists, 0, pos);
			ListNode[] lr = Arrays.copyOfRange(lists, pos, lists.length);
			return mergeTwoLists(mergeKLists_V5(ll),mergeKLists_V5(lr));
		}
	}

	public static void main(String[] args) {
		ListNode l1 = transListNode(new int[] { 1, 4, 5 });
		ListNode l2 = transListNode(new int[] { 1, 3, 4 });
		ListNode l3 = transListNode(new int[] { 2, 6 });
		ListNode rr = mergeKLists_V5(new ListNode[] { l1 ,l2,l3});
		printListNode(rr);
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode cur = new ListNode(0); // 增加虚拟节点，使逻辑简化，同时可以顺便实现null检查
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
