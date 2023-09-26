package com.hzp.algorithm.queue;

import java.util.Iterator;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.queue
 * @Author: ASUS
 * @CreateTime: 2023-09-25  11:26
 * @Description: TODO  环形数组实现2.0
 * @Version: 1.0
 */
//修改在数组满的时候，不用给尾指针留个位置
public class ArrayQueue2<E> implements Queue<E>, Iterable<E>{

    private int head = 0;
    private int tail = 0;
    private  final E[] array;
    private  int size=0;//元素个数

    //SuppressWarnings:抑制警告
    @SuppressWarnings("all")
    public ArrayQueue2(int capacity) {
        array = (E[]) new Object[ capacity ];//这个时候就不需要给尾指针留个位置
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        //当加到数组最大索引位置时，应该让tail=数组初始索引位置0
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        //当加到数组最大索引位置时，应该让tail=数组初始索引位置0
        head = (head + 1) % array.length;
        size--;
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
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size== array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            int count=0;//记录循环个数
            @Override
            public boolean hasNext() {
                return count<size;  //当size==count时，就退出循环
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
                count++;
                return value;
            }
        };
    }
}
