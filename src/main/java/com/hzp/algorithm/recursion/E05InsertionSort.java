package com.hzp.algorithm.recursion;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.recursion
 * @Author: ASUS
 * @CreateTime: 2023-09-16  14:34
 * @Description: TODO  递归实现插入排序
 * @Version: 1.0
 */
public class E05InsertionSort {

    public static void sort(int[] a){
        insertion(a,1);//初始Low的索引是在1
    }


    //low:未排序的初始索引
    private static void insertion(int[] a,int low){
        //递归的结束标志
        if(low==a.length){
            return;
        }
        int t=a[low];//存放需要插入的数字
        int i=low-1;//已排序区域指针
        //没有找到插入位置  i>=0：是为了防止在插入位置在索引0的情况就要结束while循环
        while (i>=0&&a[i]>t){
            a[i+1]=a[i];//空出插入位置
            i--;
        }
        //找到插入位置
        a[i+1]=t;
        insertion(a,low+1);
    }
}
