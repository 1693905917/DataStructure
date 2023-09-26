package com.hzp.algorithm.array;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.array
 * @Author: ASUS
 * @CreateTime: 2023-09-24  20:42
 * @Description: TODO
 * @Version: 1.0
 */
public class StackExample {
    private static ArrayDeque<Integer> stack;
    // private int[] stack;
    // private int top;

    public StackExample(){
        stack=new ArrayDeque<>();
    }

    public void push(int d){
        stack.addLast(d);
    }
    public void pop(){
        if(!stack.isEmpty()){
            System.out.println(stack.removeLast());
        }else{
            System.out.println("invalid");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            int operation=sc.nextInt();
            if(operation==1){
                int value=sc.nextInt();
                stack.push(value);
            }else if(operation==0){
                if(!stack.isEmpty()){
                    System.out.println(stack.pop());
                }else{
                    System.out.println("invalid");
                }
            }
        }
        sc.close();
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
//            Scanner sc=new Scanner(System.in);
//            int n=sc.nextInt();
//            int[][] operations=new int[n][2];
//            for(int i=0;i<n;i++){
//                operations[i][0]=sc.nextInt();
//                if(operations[i][0]==1){
//                    operations[i][1]=sc.nextInt();
//                }
//            }
//            StackExample stack=new StackExample();
//            for(int i=0;i<n;i++){
//                if(operations[i][0]==1){
//                    stack.push(operations[i][1]);
//                }else{
//                    stack.pop();
//                }
//            }


//            int n;
//            Scanner sc=new Scanner(System.in);
//            n=sc.nextInt();
//            int a[]=new int[n+1];
//            int i,end,j,xh,caozuo;
//            end=0;
//            for(i=1;i<=n;i++){
//                caozuo=sc.nextInt();
//                if(caozuo==0){
//                    if(end==0){
//                        System.out.println("invalid");
//                    }else{
//                        System.out.println(a[end]);
//                        end--;
//                    }
//                }else{
//                    xh=sc.nextInt();
//                    end++;
//                    a[end]=xh;
//                }
//            }

//            Scanner scanner = new Scanner(System.in);
//            int n = scanner.nextInt();
//            Stack<Integer> stack = new Stack<>();
//            for (int i = 0; i < n; i++) {
//                int operation = scanner.nextInt();
//                if (operation == 1) {
//                    int number = scanner.nextInt();
//                    stack.push(number);
//                } else if (operation == 0) {
//                    if (!stack.isEmpty()) {
//                        System.out.println(stack.pop());
//                    } else {
//                        System.out.println("Error: Stack is empty");
//                    }
//                }
//            }


//            Scanner sc=new Scanner(System.in);
//            Stack<Integer> stack=new Stack<>();
//            int num=sc.nextInt();
//            int i,j;
//            for(i=0;i<num;i++){
//                int n=sc.nextInt();
//                if(n==1){
//                    int m=sc.nextInt();
//                    //压栈操作
//                    stack.push(m);
//                }else{
//                    if(!stack.isEmpty()){
//                        System.out.println(stack.pop());
//                    }else{
//                        System.out.println("invalid");
//                    }
//                }
//                //光标换到下一行
//                sc.nextLine();
//            }
//            Stack<Integer> stack = new Stack<>();
//            int[] pushElements = {1, 2, 3, 4};
//            int[] popElements = {4, 3, 2, 1};
//
//            // 压栈操作
//            for (int i = 0; i < pushElements.length; i++) {
//                stack.push(pushElements[i]);
//            }
//
//            // 弹栈操作并输出每次弹栈的元素
//            for (int i = 0; i < popElements.length; i++) {
//                if (!stack.isEmpty() && stack.peek() == popElements[i]) {
//                    System.out.println(stack.pop());
//                } else {
//                    System.out.println("Error: Invalid Pop Operation");
//                    break;
//                }
//            }
        }
}
