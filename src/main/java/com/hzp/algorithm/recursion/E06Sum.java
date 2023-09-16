package com.hzp.algorithm.recursion;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.recursion
 * @Author: ASUS
 * @CreateTime: 2023-09-16  15:56
 * @Description: TODO  递归求和
 * @Version: 1.0
 */
public class E06Sum {

    //用递归做 n + (n-1) + (n-2) ... + 1
    public static long sum(long n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }



}
