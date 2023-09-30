package com.hzp.algorithm.deque;

import java.util.Iterator;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.deque
 * @Author: ASUS
 * @CreateTime: 2023-09-30  09:59
 * @Description: TODO 基于循环数组实现双端队列
 * @Version: 1.0
 */
public class ArrayDeque1<E> implements Deque<E>,Iterable<E> {
    /*
    h - head:头指针
    t - tail:尾指针
    我们以索引为0为低   索引高为顶
       h
       t
索引:   0   1   2   3
       a

    offerLast(a)    先添加元素 tail++  ：当tail超过了数组长度-1的索引时,我们可以利用之前学习的取模运算,但是我们这里又有一个新方法来限定head、tail的索引范围：inc()、dec()
    offerLast(b)
    offerFirst(c)   先 head-- 再添加元素 ：head低于数组索引0的长度时,我们可以利用之前学习的取模运算

    pollFirst()     先获取要移除的值 head++：
    pollLast()      先 tail-- 再获取要移除的值

    head == tail 空
    head ~ tail == 数组长度-1 满
 */

    E[] array;
    int head;//头指针 无须初始化,全局
    int tail;//尾指针 无须初始化,全局

    @SuppressWarnings("all")
    public ArrayDeque1(int capacity) {
        //注意：循环数组，我们的tail的特点：停下来的位置不存储, 会浪费一个位置
        array = (E[]) new Object[capacity + 1];
    }

    /*
                h
        t
        0   1   2   3
                a   b
     */
    static int inc(int i, int length) {
        if (i + 1 >= length) {
            return 0;
        }
        return i + 1;
    }

    /*
                    h
            t
        0   1   2   3
        a           b
     */
    static int dec(int i, int length) {
        if (i - 1 < 0) {
            return length - 1;
        }
        return i - 1;
    }



    @Override
    public boolean offerFirst(E e) {
        if (isFull()) {
            return false;
        }
        head = dec(head, array.length);
        array[head] = e;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) {
            return false;
        }
        array[tail] = e;
        tail = inc(tail, array.length);
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        E e = array[head];
        array[head] = null; // help GC
        head = inc(head, array.length);
        return e;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        tail = dec(tail, array.length);
        E e = array[tail];
        array[tail] = null; // help GC
        return e;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return array[dec(tail, array.length)];
    }

    @Override
    public boolean isEmpty() {
        //head == tail 空
        return head==tail;
    }

        /*
        h
                    t
        0   1   2   3
        a   b   c
        当执行offerLast
        tail>head
        3-0==array.length-1
     */

    /*
            h
        t
        0   1   2   3
            c   b   a
        当执行offerFirst
        tail<head
        head-tail==1
     */
    @Override
    public boolean isFull() {
        if (tail > head) {
            return tail - head == array.length - 1;
        } else if (tail < head) {
            return head - tail == 1;
        } else {
            return false;
        }
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
                E e = array[p];
                p = inc(p, array.length);
                return e;
            }
        };
    }
}
