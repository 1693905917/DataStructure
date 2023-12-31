package com.hzp.algorithm.heap;

import java.util.Arrays;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.heap
 * @Author: ASUS
 * @CreateTime: 2023-10-02  10:41
 * @Description: TODO 小顶堆Plus_增加了堆化等方法
 * @Version: 1.0
 */
public class MinHeap {
    int[] array;
    int size;

    public MinHeap(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 获取堆顶元素
     *
     * @return 堆顶元素
     */
    public int peek() {
        //注意:当传入的数组是null时，我们可以设置一个判断来抛个异常，在这里我们就不去判断，请有需要的自行
        return array[0];
    }

    /**
     * 删除堆顶元素
     *
     * @return 堆顶元素
     */
    public int poll() {
        //注意:当传入的数组是null,可以设置一个判断来抛个异常，在这里我们就不去判断，请有需要的自行
        if(isEmpty()){
            throw new IllegalArgumentException("数组有问题");
        }
        int top = array[0];
        swap(0, size - 1);
        size--;
        //从索引位置0开始下潜
        down(0);
        return top;
    }

    private boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        return size==array.length;
    }

    /**
     * 删除指定索引处元素  这个方法与删除堆顶元素方法思路一样
     *
     * @param index 索引
     * @return 被删除元素
     */
    public int poll(int index) {
        //注意:当传入的数组是null,可以设置一个判断来抛个异常，在这里我们就不去判断，请有需要的自行
        if(isEmpty()){
            throw new IllegalArgumentException("数组有问题");
        }
        int deleted = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return deleted;
    }

    /**
     * 替换堆顶元素
     * @param replaced 新元素
     */
    public void replace(int replaced) {
        array[0] = replaced;
        down(0);
    }

    /**
     * 堆的尾部添加元素
     *
     * @param offered 新元素
     * @return 是否添加成功
     */
    public boolean offer(int offered) {
        if (size == array.length) {
            return false;
        }
        up(offered);
        size++;
        return true;
    }

    //向堆的尾部添加元素： 将 offered 元素上浮: 直至 offered 小于父元素或到堆顶
    private void up(int offered) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (offered < array[parent]) {
                array[child] = array[parent];
            } else {
                break;
            }
            child = parent;
        }
        array[child] = offered;
    }

    public MinHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    // 建堆
    private void heapify() {
        // 如何找到最后这个非叶子节点 ：套用公式 size / 2 - 1
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    // 将 parent 索引处的元素下潜: 与两个孩子较大者交换, 直至没孩子或孩子没它大
    private void down(int parent) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int min = parent;
        //left < size:必须是有效的索引  不可能超出数组最大长度吧
        if (left < size && array[left] < array[min]) {
            min = left;
        }
        if (right < size && array[right] < array[min]) {
            min = right;
        }
        if (min != parent) { // 找到了更大的孩子
            swap(min, parent);
            down(min);
        }
    }

    // 交换两个索引处的元素
    private void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 4, 5, 6, 7};
//        MaxHeap maxHeap = new MaxHeap(array);
//        System.out.println(Arrays.toString(maxHeap.array));

        //1. heapify 建立小顶堆
        //2. 将堆顶与堆底交换（最大元素被交换到堆底），缩小并下潜调整堆
        //3. 重复第二步直至堆里剩一个元素
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        //1. heapify 建立大顶堆
        MinHeap maxHeap = new MinHeap(array);
        System.out.println(Arrays.toString(maxHeap.array));
        //3. 重复第二步直至堆里剩一个元素
        while(maxHeap.size>1){
            //将堆顶与堆底交换（最大元素被交换到堆底），缩小并下潜调整堆
            maxHeap.swap(0, maxHeap.size-1);
            maxHeap.size--;
            maxHeap.down(0);
        }
        System.out.println(Arrays.toString(maxHeap.array));
    }
}
