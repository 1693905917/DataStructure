package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.priorityqueue.MinHeap;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-01  12:32
 * @Description: TODO 利用小顶堆来实现合并多个有序链表
 * @Version: 1.0
 */
public class E01LetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 1. 使用 jdk 的优先级队列实现
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        // 2. 使用自定义小顶堆实现
        MinHeap queue = new MinHeap(lists.length);
        //将链表加入到小顶堆
        for (ListNode head : lists) {
            //注意：当List传入的是空
            if (head != null) {
                queue.offer(head);
            }
        }
        //新链表创建哨节点
        ListNode s = new ListNode(-1, null);
        ListNode p = s;
        //不断从堆顶移除最小元素，加入新链表
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            p = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return s.next;
    }

    //用例测试
    public static void main(String[] args) {
        ListNode[] lists = {
                ListNode.of(1, 4, 5),
                ListNode.of(1, 3, 4),
                ListNode.of(2, 6),
                null,
        };
        ListNode m = new E01LetCode23().mergeKLists(lists);
        System.out.println(m);
    }
}
