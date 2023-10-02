package com.hzp.algorithm.datastructure;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-02  11:13
 * @Description: TODO 数组中第K大元素
 * @Version: 1.0
 */

import com.hzp.algorithm.heap.MinHeap;

/**
 * <h3>求数组中第 K 大的元素</h3>
 * <p>
 * 解体思路
 * <ol>
 *     1.向小顶堆放入前k个元素
 *     2.剩余元素
 *         若 <= 堆顶元素, 则略过
 *         若 > 堆顶元素, 则替换堆顶元素
 *     3.这样小顶堆始终保留的是到目前为止,前K大的元素
 *     4.循环结束, 堆顶元素即为第K大元素
 * </ol>
 */
public class E02LetCode215 {
    public int findKthLargest(int[] numbers, int k) {
        MinHeap heap = new MinHeap(k);
        //向小顶堆放入前k个元素
        for (int i = 0; i < k; i++) {
            heap.offer(numbers[i]);
        }
        for (int i = k; i < numbers.length; i++) {
            if(numbers[i] > heap.peek()) {
                //若 > 堆顶元素, 则替换堆顶元素
                heap.replace(numbers[i]);
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        // 应为5
        System.out.println(new E02LetCode215().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        // 应为4
        System.out.println(new E02LetCode215().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
