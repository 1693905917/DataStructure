package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.heap.Heap;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-02  15:57
 * @Description: TODO
 * @Version: 1.0
 */
public class E04LetCode295_1 {

    //设置左边履行的是大顶堆
    private Heap left = new Heap(10, false);
    //设置右边履行的是小顶堆
    private Heap right = new Heap(10, true);

    /**
     为了保证两边数据量的平衡
     <ul>
     <li>两边数据一样时,加入左边</li>
     <li>两边数据不一样时,加入右边</li>
     </ul>
     但是, 随便一个数能直接加入吗?
     <ul>
     <li>加入左边前, 应该挑右边最小的加入</li>
     <li>加入右边前, 应该挑左边最大的加入</li>
     </ul>
     */
    public void addNum(int num) {
        if (left.size() == right.size()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    /**
     * <ul>
     *     <li>两边数据一致, 左右各取堆顶元素求平均</li>
     *     <li>左边多一个, 取左边元素</li>
     * </ul>
     */
    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }


    public static void main(String[] args) {
        E04LetCode295_1 test = new E04LetCode295_1();
        test.addNum(1);
        test.addNum(2);
        test.addNum(3);
        test.addNum(7);
        test.addNum(8);
        test.addNum(9);
        System.out.println(test);
        System.out.println(test.findMedian());
        test.addNum(10);
        System.out.println(test);
        System.out.println(test.findMedian());
        test.addNum(4);
        System.out.println(test);
        System.out.println(test.findMedian());
    }
}
