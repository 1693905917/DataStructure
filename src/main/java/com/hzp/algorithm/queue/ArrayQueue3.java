package com.hzp.algorithm.queue;

import java.util.Iterator;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.queue
 * @Author: ASUS
 * @CreateTime: 2023-09-25  11:26
 * @Description: TODO  环形数组实现3.0
 * @Version: 1.0
 */
//修改在数组满的时候，不用给尾指针留个位置
public class ArrayQueue3<E> implements Queue<E>, Iterable<E>{

    private int head = 0;
    private int tail = 0;
    private  E[] array;

    //SuppressWarnings:抑制警告
    @SuppressWarnings("all")
    public ArrayQueue3(int capacity) {
        array = (E[]) new Object[ capacity ];//这个时候就不需要给尾指针留个位置
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        //进行(int):数组中只能存储Int类型，不能是long类型所以要转换
        array[(int) (Integer.toUnsignedLong(tail)% array.length)] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[(int) (Integer.toUnsignedLong(head)% array.length)];
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[(int) (Integer.toUnsignedLong(head)% array.length)];
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }

    @Override
    public boolean isFull() {
        return tail-head==array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p!=tail;
            }

            @Override
            public E next() {
                E value = array[(int) (Integer.toUnsignedLong(p)%array.length)];
                p++;
                return value;
            }
        };
    }
}
