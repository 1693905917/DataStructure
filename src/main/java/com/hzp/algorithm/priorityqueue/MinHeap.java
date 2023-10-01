package com.hzp.algorithm.priorityqueue;

import com.hzp.algorithm.datastructure.ListNode;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.priorityqueue
 * @Author: ASUS
 * @CreateTime: 2023-10-01  12:29
 * @Description: TODO 小顶堆
 * @Version: 1.0
 */
//小顶堆的操作与大顶堆的操作基本相似  但是我们这里就没有实现E，我们直接利用Node的val来实现
public class MinHeap {

    /*
              min
        1->4->5->null
        1->3->4->null
        2->6->null

        小顶堆
            1 2 4
        新链表
            s->1
     */
    ListNode[] array;
    int size;

    public MinHeap(int capacity) {
        array = new ListNode[capacity];
    }

    public void offer(ListNode offered) {
        int child = size++;
        int parent = (child - 1) / 2;
        while (child > 0 && offered.value < array[parent].value) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = offered;
    }

    public ListNode poll() {
        if (isEmpty()) {
            return null;
        }
        swap(0, size - 1);
        size--;
        ListNode e = array[size];
        array[size] = null; // help GC

        down(0);

        return e;
    }

    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int min = parent;
        if (left < size && array[left].value < array[min].value) {
            min = left;
        }
        if (right < size && array[right].value < array[min].value) {
            min = right;
        }
        if (min != parent) {
            swap(min, parent);
            down(min);
        }
    }

    private void swap(int i, int j) {
        ListNode t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
