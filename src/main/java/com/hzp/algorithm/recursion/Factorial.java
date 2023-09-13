package com.hzp.algorithm.recursion;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.recursion
 * @Author: ASUS
 * @CreateTime: 2023-09-13  21:45
 * @Description: TODO 递归
 * @Version: 1.0
 */
public class Factorial {

    //阶乘的定义 n!= 1⋅2⋅3⋯(n-2)⋅(n-1)⋅n，其中n为自然数
    public static int f(int n){
        if(n==1){
            return 1;
        }
        return n*f(n-1);
    }

    public static void main(String[] args) {
        int f = f(5);
        System.out.println(f);
    }


}
