package com.hzp.algorithm.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-23  17:18
 * @Description: TODO 合并有序数组
 * @Version: 1.0
 */
public class E01Merge2SortedArray {

    public static void main(String[] args) {
//        int[] a1 ={1,5,6,2,4,10,11};
//        int[] a2=new int[a1.length];
//        merge(a1,0,2,3,6,a2);
//        System.out.println(Arrays.toString(a2));
//        System.arraycopy(a2,0,a1,0,a2.length);
//        System.out.println(Arrays.toString(a1));
//        System.out.println(4+8+"Hello,world!");
        System.out.println(4 + 5 + "" + 3 + 6);

    }

    //方法1:递归实现
    //a1原始数组  a2结果数组(K:a2的索引)
    //i,iEnd第一个有序区间的起点终点,  j,jEnd第二个有序区间的起点终点
    public static void merge1(int[] a1,int i,int iEnd,int j,int jEnd,int[] a2,int k){
        if(i>iEnd){
            System.arraycopy(a1,j,a2,k,jEnd-j+1);
            return;
        }
        if(j>jEnd){
            System.arraycopy(a1,i,a2,k,iEnd-i+1);
            return;
        }
        if(a1[i]<a1[j]){
            a2[k]=a1[i];
            merge1(a1,i+1,iEnd,j,jEnd,a2,k+1);
        }else{
            a2[k]=a1[j];
            merge1(a1,i,iEnd,j+1,jEnd,a2,k+1);
        }
    }


    //方法2
    public static void merge(int[] a1,int i,int iEnd,int j,int jEnd,int[] a2){
        int k = i;
        while (i <= iEnd && j <= jEnd) {
            if (a1[i] < a1[j]) {
                a2[k] = a1[i];
                i++;
            } else {
                a2[k] = a1[j];
                j++;
            }
            k++;
        }
        if (i > iEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
        }
        if (j > jEnd) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
        }
    }

}
