package com.hzp.algorithm.queue;

import java.util.Iterator;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.queue
 * @Author: ASUS
 * @CreateTime: 2023-09-25  11:26
 * @Description: TODO  环形数组实现1.0
 * @Version: 1.0
 */
public class ArrayQueue1<E> implements Queue<E>, Iterable<E>{

    private int head = 0;
    private int tail = 0;
    private  final E[] array;
    private  final int length;

    //SuppressWarnings:抑制警告
    @SuppressWarnings("all")
    public ArrayQueue1(int capacity) {
        //你设定的容量+1：在你添加满容量时，需要有多出一个的位置给尾指针
        length = capacity + 1;
        array = (E[]) new Object[length];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        //当加到数组最大索引位置时，应该让tail=数组初始索引位置0
        tail = (tail + 1) % length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        //当加到数组最大索引位置时，应该让tail=数组初始索引位置0
        head = (head + 1) % length;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return tail == head;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % length == head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
                return value;
            }
        };
    }
}
