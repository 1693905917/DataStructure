package com.hzp.algorithm.recursion;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.recursion
 * @Author: ASUS
 * @CreateTime: 2023-09-14  22:18
 * @Description: TODO 递归-二分查找函数
 * @Version: 1.0
 */
public class E03BinarySearch {
    public static int search(int a[],int target){
        return f(a,target,0,a.length-1);
    }

    private static int f(int a[],int target,int i,int j){
        //对于二分查找递归的结束条件：1.找到了  2.没找到
        if(i>j){//没找到情况
            return -1;
        }
        //找到的情况
        int m=(i+j)>>>1;
        if(target<a[m]){
           return f(a,target,i,m-1);
        }else if(target>a[m]){
           return f(a,target,m+1,j);
        }else {
            return m;
        }
    }



}
