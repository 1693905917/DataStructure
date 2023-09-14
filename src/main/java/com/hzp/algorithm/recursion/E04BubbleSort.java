package com.hzp.algorithm.recursion;

import java.util.Arrays;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.recursion
 * @Author: ASUS
 * @CreateTime: 2023-09-14  22:37
 * @Description: TODO
 * @Version: 1.0
 */
public class E04BubbleSort {

    public static void main(String[] args) {
        int a[]={6,5,4,3,2,1};
        bubble(a,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    //j 代表末排序区域右边界
    //在范围[0-j]内冒泡最大元素到右侧
    //a-数组
    private static void bubble(int a[],int j){
        //当只剩下一个数时即可结束递归
        if(j==0){
            return;
        }
        int x=0;//增加x是为了减少不必要的递归
        for (int i=0;i<j;i++){
            if(a[i]>a[i+1]){
                int t=a[i];
                a[i]=a[i+1];
                a[i+1]=t;
                x=i;  //当在每次循环中执行最后一次交换时，让x=i的索引时，此时x是处于有序与无序的分界线，因为最后一次交换一定是i以后的的索引一定是有序的
            }
        }
        bubble(a,x);
    }




}
