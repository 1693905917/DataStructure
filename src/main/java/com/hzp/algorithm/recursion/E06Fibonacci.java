package com.hzp.algorithm.recursion;

import java.util.Arrays;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.recursion
 * @Author: ASUS
 * @CreateTime: 2023-09-16  14:55
 * @Description: TODO  递归实现斐波那契数列
 * @Version: 1.0
 */
public class E06Fibonacci {

    //普通版
    public static int f(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int x = f(n-1);
        int y=f(n-2);
        return x+y;
    }


    //记忆版

    public static int fibonacci(int n){
        int[] cache=new int[n+1];
        Arrays.fill(cache,-1);//将cache数组初始化为-1
        cache[0]=0;
        cache[1]=1;//[0,1,-1,-1,-1,...,-1]
        return f(n,cache);
    }
    public static int f(int n,int[] cache){
        //cache[n]不等于-1说明：我们cache数组之前存储过这个数可以在cache中获取，而不用重新计算
        if(cache[n]!=-1){
            return cache[n];
        }
        int x=f(n-1,cache);
        int y=f(n-2,cache);
        //对于计算好的值存储到cache数组中
        cache[n]=x+y;
        return cache[n];
    }




}
