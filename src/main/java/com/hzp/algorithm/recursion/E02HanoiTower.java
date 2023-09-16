package com.hzp.algorithm.recursion;

import java.util.LinkedList;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.recursion
 * @Author: ASUS
 * @CreateTime: 2023-09-16  19:15
 * @Description: TODO  递归实现汉罗塔
 * @Version: 1.0
 */
public class E02HanoiTower {
    static LinkedList<Integer> a=new LinkedList<>();//左边柱子
    static LinkedList<Integer> b=new LinkedList<>();//中间柱子
    static LinkedList<Integer> c=new LinkedList<>();//右边柱子

    //3 2 1:左边是底部   右边是顶部
    static void init(int n){
        for (int i=n;i>=1;i--){
            a.addLast(i);
        }
    }


    static void move(int n,LinkedList<Integer> a,
                     LinkedList<Integer> b,
                     LinkedList<Integer> c){
        if(n==0){
            return;
        }

        move(n-1,a,c,b);//在上面的n-1个盘子都是从借助c，从a到b
        c.addLast(a.removeLast());//中间
        print();
        move(n-1,b,a,c);//在上面的n-1个盘子都是从借助a，从b到c

    }

    public static void main(String[] args) {
        init(3);
        print();
        move(3,a,b,c);
    }

    private static void print() {
        System.out.println("-------------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }


}
