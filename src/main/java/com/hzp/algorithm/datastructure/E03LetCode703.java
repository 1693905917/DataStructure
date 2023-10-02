package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.heap.MinHeap;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-02  14:40
 * @Description: TODO  数据流中第K大元素
 * @Version: 1.0
 */
public class E03LetCode703 {
    private MinHeap heap;

    public E03LetCode703(int k, int[] nums) {
        heap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }

    // 此方法会被不断调用, 模拟数据流中新来的元素
    public int add(int val) {
        if (!heap.isFull()) {
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.replace(val);
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        E03LetCode703 test = new E03LetCode703(3,
                new int[]{});

        System.out.println(test.add(3)); // [3] 3
        System.out.println(test.add(5)); // [3 5] 3
        System.out.println(test.add(10));
        System.out.println(test.add(9));
        System.out.println(test.add(4));
    }
}
