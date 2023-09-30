package com.hzp.algorithm.priorityqueue;

import com.hzp.algorithm.queue.Queue;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.priorityqueue
 * @Author: ASUS
 * @CreateTime: 2023-09-30  15:48
 * @Description: TODO 基于无序数组实现优先级队列
 * @Version: 1.0
 */
public class PriorityQueue1 <E extends Priority> implements Queue<E> {

    Priority[] array;
    int size;

    public PriorityQueue1(int capacity) {
        array = new Priority[capacity];
    }

    @Override // O(1)
    public boolean offer(E e) {
        if (isFull()) {
            return false;
        }
        array[size++] = e;
        return true;
    }

    // 返回优先级最高的索引值
    private int selectMax() {
        int max = 0;
        for (int i = 1; i < size; i++) {
            if (array[i].priority() > array[max].priority()) {
                max = i;
            }
        }
        return max;
    }

    @Override // O(n)
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax();
        E e = (E) array[max];
        remove(max);
        return e;
    }

    //这里的删除操作有两种：一、如果是最大索引上的元素要被删除，则只需要将数组大小-1即可
    //二、如果不是最大索引上的元素要被删除，则要从要被删除的索引后面的数字集体向前移动
    private void remove(int index) {
        if (index < size - 1) { //说明不是最后一个元素
            System.arraycopy(array, index + 1,
                    array, index, size - 1 - index);
        }
        array[--size] = null; // help GC
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax();
        return (E) array[max];
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
//    PriorityQueue1<Entry> queue = new PriorityQueue1<>(5);
//    queue.offer(new Entry("task1", 4));
//    queue.offer(new Entry("task2", 3));
//    queue.offer(new Entry("task3", 2));
//    queue.offer(new Entry("task4", 5));
//    queue.offer(new Entry("task5", 1));
//    assertFalse(queue.offer(new Entry("task6", 7)));
//    System.out.println(Arrays.toString(queue.array));
//    assertEquals(5, queue.poll().priority());
//    System.out.println(Arrays.toString(queue.array));
//    assertEquals(4, queue.poll().priority());
//    assertEquals(3, queue.poll().priority());
//    assertEquals(2, queue.poll().priority());
//    assertEquals(1, queue.poll().priority());
//}
