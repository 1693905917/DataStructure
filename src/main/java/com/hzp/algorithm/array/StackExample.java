package com.hzp.algorithm.array;

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
        public static void main(String[] args) {
            Stack<Integer> stack = new Stack<>();
            int[] pushElements = {1, 2, 3, 4};
            int[] popElements = {4, 3, 2, 1};

            // 压栈操作
            for (int i = 0; i < pushElements.length; i++) {
                stack.push(pushElements[i]);
            }

            // 弹栈操作并输出每次弹栈的元素
            for (int i = 0; i < popElements.length; i++) {
                if (!stack.isEmpty() && stack.peek() == popElements[i]) {
                    System.out.println(stack.pop());
                } else {
                    System.out.println("Error: Invalid Pop Operation");
                    break;
                }
            }
        }
}
