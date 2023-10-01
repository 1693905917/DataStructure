package com.itheima.algorithm.blockingqueue;

import java.util.Arrays;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.itheima.algorithm.blockingqueue
 * @Author: ASUS
 * @CreateTime: 2023-10-01  14:11
 * @Description: TODO
 * @Version: 1.0
 */
public class TestThreadUnsafe {

    private final String[] array = new String[10];
    private int tail = 0;

    public void offer(String e) {
        array[tail] = e;
        tail++;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        TestThreadUnsafe queue = new TestThreadUnsafe();
        new Thread(()-> queue.offer("e1"), "t1").start();
        new Thread(()-> queue.offer("e2"), "t2").start();
    }
}
