package com.hzp.algorithm.queue;

import java.util.Iterator;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.queue
 * @Author: ASUS
 * @CreateTime: 2023-09-25  11:26
 * @Description: TODO  环形数组实现3.1
 * @Version: 1.0
 */
//求模运算：
//        如果除数是2的n次方
//        那么被除数的后n位即为余数（馍）
//        求被除数的后n位方法：与2^n-1按位与
public class ArrayQueue3_1<E> implements Queue<E>, Iterable<E>{

    private int head = 0;
    private int tail = 0;
    private  E[] array;

    //SuppressWarnings:抑制警告
    @SuppressWarnings("all")
    //这个方法的条件就是 capacity的取值必须是2的n次方
    public ArrayQueue3_1(int capacity) {
        array = (E[]) new Object[ capacity ];//这个时候就不需要给尾指针留个位置
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        //进行(int):数组中只能存储Int类型，不能是long类型所以要转换
        //array[(int) (Integer.toUnsignedLong(tail)% array.length)] = value;
        //以下方法比以上方法的优点：1.&的运算更加优化   2.这也防止了int类型超出最大值的情况
        array[tail& (array.length-1)]=value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        //E value = array[(int) (Integer.toUnsignedLong(head)% array.length)];
        E value = array[head& (array.length-1)];
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        //return array[(int) (Integer.toUnsignedLong(head)% array.length)];
        return array[head& (array.length-1)];
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
                //E value = array[(int) (Integer.toUnsignedLong(p)%array.length)];
                E value = array[p& (array.length-1)];
                p++;
                return value;
            }
        };
    }
}
