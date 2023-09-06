package com.itheima.algorithm.binarysearch;

import org.junit.Test;

import java.util.Arrays;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.itheima.algorithm.binarysearch
 * @Author: ASUS
 * @CreateTime: 2023-09-06  08:27
 * @Description: TODO
 * @Version: 1.0
 */
public class TestBinarySearch {

    @Test
    public void test(){
        int a[]={2,5,8};
        int target=4;
        int i= Arrays.binarySearch(a,target);
        System.out.println(Arrays.toString(a));
        // -2 =-插入点-1
        // -2+1=-插入点

        if(i<0){
            int insertIndex = Math.abs(i + 1);
            int []b=new int[a.length+1];
            System.arraycopy(a,0,b,0,insertIndex);
            b[insertIndex]=target;
            System.arraycopy(a,insertIndex,b,insertIndex+1,a.length-insertIndex);
            System.out.println(Arrays.toString(b));
        }
    }

}
