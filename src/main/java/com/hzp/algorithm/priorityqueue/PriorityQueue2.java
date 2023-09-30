package com.hzp.algorithm.priorityqueue;

import com.hzp.algorithm.queue.Queue;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.priorityqueue
 * @Author: ASUS
 * @CreateTime: 2023-09-30  15:48
 * @Description: TODO 基于有序数组实现优先级队列
 * @Version: 1.0
 */
public class PriorityQueue2<E extends Priority> implements Queue<E> {

    Priority[] array;
    int size;

    public PriorityQueue2(int capacity) {
        array = new Priority[capacity];
    }

    // O(n)
    @Override
    public boolean offer(E e) {
        if (isFull()) {
            return false;
        }
        insert(e);
        size++;
        return true;
    }

    // 一轮插入排序
    private void insert(E e) {
        int i = size - 1;
        //循环条件：1.遍历到低就退出  2.当遍历到第一次比自己低的索引时就退出
        while (i >= 0 && array[i].priority() > e.priority()) {
            //将优先级比搜索值要小都向上移动
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = e;
    }

    // O(1)
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E e = (E) array[size - 1];
        array[--size] = null; // help GC
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}

//测试用例:
//@Test
//public void poll() {
//    PriorityQueue2<Entry> queue = new PriorityQueue2<>(5);
//    queue.offer(new Entry("task1", 4));
//    queue.offer(new Entry("task2", 3));
//    queue.offer(new Entry("task3", 2));
//    queue.offer(new Entry("task4", 5));
//    queue.offer(new Entry("task5", 1));
//    assertFalse(queue.offer(new Entry("task6", 7)));
//    assertEquals("task4", queue.peek().value);
//    assertEquals("task4", queue.poll().value);
//    assertEquals("task1", queue.poll().value);
//    assertEquals("task2", queue.poll().value);
//    assertEquals("task3", queue.poll().value);
//    assertEquals("task5", queue.poll().value);
//}
