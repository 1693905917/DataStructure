package com.hzp.algorithm.recursion;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.recursion
 * @Author: ASUS
 * @CreateTime: 2023-09-14  21:58
 * @Description: TODO  用递归反向打印字符串，n 为字符在整个字符串 str 中的索引位置
 * @Version: 1.0
 */
public class ReversePrintString {

    public static void f(int n,String str){
        if(n>=str.length()){
            return;
        }
        f(n+1,str);
        System.out.println(str.charAt(n));
    }

    public static void main(String[] args) {
        f(0,"abcd");
        //注意：在java语言中，我们实现这个方法有两种：上面是第一种，
        //第二种：我直接从这个n=3开始，也就是从str.length-1开始递归
        //每次让这个n-1，当n小于0时，则退出递归。
        //以上两种方法在java语言中是可以实现的，但是在C语言中这第二种方法就不行：
        //如果是用C语言还是要选择第一种方法，
        //因为，因为C语言中这个字符串来讲，该开始这个长度是未知的，所以一直得从0开始向后，
        //什么时候到字符串的结尾了，也就是遇到特殊字符'\0'，才找到到字符串尾巴，这个时候要结束递归



    }

}
