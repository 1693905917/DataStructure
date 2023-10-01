package com.hzp.algorithm.priorityqueue;

import com.hzp.algorithm.queue.Queue;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.priorityqueue
 * @Author: ASUS
 * @CreateTime: 2023-10-01  08:59
 * @Description: TODO 堆实现
 * @Version: 1.0
 */
//利用大顶堆来实现  从索引 0 开始存储节点数据
public class PriorityQueue4<E extends Priority> implements Queue<E> {

    Priority[] array;
    int size;

    public PriorityQueue4(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    //1.添加元素的时候，要符合条件，从左往右依次填满
    //2.根据规律，我们填的元素一定是在数组中最后一位添加
    //3.找填加元素的父类利用公式：节点 i 的父节点为 floor((i-1)/2)，当 i>0 时
    //4.当添加的子元素值大于父类的元素值则要将父类的元素值与添加的子元素值进行交换，然后再让添加的子元素值再与上一级父类的元素值进行比较

    //简单来说：
    //1. 入堆新元素, 加入到数组末尾 (索引位置 child)
    //2. 不断比较新加元素与它父节点(parent)优先级 (上浮)
    //    - 如果父节点优先级低, 则向下移动, 并找到下一个 parent
    //    - 直至父节点优先级更高或 child==0 为止
    public boolean offer(E offered) {
        if (isFull()) {
            return false;
        }
        int child = size++;
        int parent = (child - 1) / 2;
        while (child > 0 && offered.priority() > array[parent].priority()) {
            array[child] = array[parent];
            child = parent;
            //java整数取整就是向下取整 所以不需要调用floor函数
            parent = (child - 1) / 2;
        }
        array[child] = offered;
        return true;
    }

    //交换堆顶和尾部元素
    private void swap(int i, int j) {
        Priority t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    @Override
    //移除优先级最高的元素
    /*
    1. 交换堆顶和尾部元素, 让尾部元素出队
    2. (下潜)
        - 从堆顶开始, 将父元素与两个孩子较大者交换
        - 直到父元素大于两个孩子, 或没有孩子为止
     */
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        // 1. 交换堆顶和尾部元素
        swap(0, size - 1);
        //让尾部元素出队
        size--;
        Priority e = array[size];
        array[size] = null;

        shiftDown(0);
        return (E) e;
    }

    //2. (下潜)
    //    - 从堆顶开始, 将父元素与两个孩子较大者交换
    //    - 直到父元素大于两个孩子, 或没有孩子为止
    void shiftDown(int parent) {
        //节点 i 的左子节点为 2i+1，右子节点为 2i+2，当然它们得 < size
        int left = 2 * parent + 1;
        int right = left + 1;
        int max = parent;//假设父元素优先级最高
        if (left < size && array[left].priority() > array[max].priority()) {
            max = left;
        }
        if (right < size && array[right].priority() > array[max].priority()) {
            max = right;
        }
        if (max != parent) {//有孩子比父亲大
            swap(max, parent);
            shiftDown(max);
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}