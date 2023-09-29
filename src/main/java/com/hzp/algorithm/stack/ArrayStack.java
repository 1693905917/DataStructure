package com.hzp.algorithm.stack;

import java.util.Iterator;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.stack
 * @Author: ASUS
 * @CreateTime: 2023-09-29  10:35
 * @Description: TODO 以数组形式实现栈
 * @Version: 1.0
 */
public class ArrayStack<E>implements Stack<E>, Iterable<E>{
    private final E[] array;
    private int top = 0;//对0索引开始，一个一个放
    /*
    声明：数组以0索引为底部   原因：数组删除最顶层性能最高
    低			顶
    0	1	2	 3
    */

    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        array[top++] = value;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E value=array[top-1];
        top--;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[top-1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = top;//从栈的顶部开始遍历
            @Override
            public boolean hasNext() {
                return p > 0;
            }

            @Override
            public E next() {
                E value=array[p-1];
                p--;
                return value;
            }
        };
    }
}
