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
public class ArrayQueue3_2<E> implements Queue<E>, Iterable<E>{

    private int head = 0;
    private int tail = 0;
    private  E[] array;
    //public static void main(String[] args) {
        /*
        当我输入的是数是30
        c=30;
        2^4 == 16
        2^4.？ == 30
        2^5 == 32

        我们要找到的是这个数最近并且大于这个数的2^n：
        对于幂的获取：log2(30)==4.?  --->(int)log2(30)==4 -->(int)log2(30)+1 ==5

        同时由于java的Math函数没有以2为低的log函数
        所以我们要进行转换运算：log2(x)=log10(x)/log10(2)

        int c=30;
        int n= (int)(Math.log10(c)/Math.log10(2))+1;
        System.out.println(n);
        System.out.println(1<<n);
         */
//        int c=30;
//        int n= (int)(Math.log10(c)/Math.log10(2))+1;
//        System.out.println(n);
//        System.out.println(1<<n);
        /*
        验证1<<n == 2^n ==将1向左移动n位就是2^n
        1           2^0
        10          2^1
        100         2^2
        1000        2^3
         */
//        c -= 1;
//        c |= c >> 1;
//        c |= c >> 2;
//        c |= c >> 4;
//        c |= c >> 8;
//        c |= c >> 16;
//        c += 1;
    //}

    //SuppressWarnings:抑制警告
    @SuppressWarnings("all")
    //这个方法的条件就是 capacity的取值必须是2的n次方
    public ArrayQueue3_2(int capacity) {
        //1.抛异常:当输入的数不是2的幂则跑异常
        if(((capacity&capacity-1)!=0)){
            throw new IllegalArgumentException("capactiy 必须是2的幂");
        }
        //2.将输入的数不是2的幂改成2^n
        capacity -= 1;
        capacity |= capacity >> 1;
        capacity |= capacity >> 2;
        capacity |= capacity >> 4;
        capacity |= capacity >> 8;
        capacity |= capacity >> 16;
        capacity += 1;
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
