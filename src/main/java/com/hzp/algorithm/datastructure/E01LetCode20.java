package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.stack.ArrayStack;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-29  10:55
 * @Description: TODO 有效的括号
 * @Version: 1.0
 */
//思路
//
//  * 遇到左括号, 把要配对的右括号放入栈顶
//  * 遇到右括号, 若此时栈为空, 返回 false，否则把它与栈顶元素对比
//  * 若相等, 栈顶元素弹出, 继续对比下一组
//  * 若不等, 无效括号直接返回 false
//  * 循环结束
//  * 若栈为空, 表示所有括号都配上对, 返回 true
//  * 若栈不为空, 表示右没配对的括号, 应返回 false
public class E01LetCode20 {
    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>(s.length() / 2 + 1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //遇到左括号, 把要配对的右括号放入栈顶
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {//遇到右括号, 若此时栈为空, 返回 false，否则把它与栈顶元素对比
                //!stack.isEmpty()：为了防止用户输入的字符都是右括号的字符(比如："((" )  那么我们stack就会报空指针异常
                if (!stack.isEmpty() && stack.peek() == c) { //* 若相等, 栈顶元素弹出, 继续对比下一组
                    stack.pop();
                } else {
                    return false;//若不等, 无效括号直接返回 false
                }
            }
        }
        //* 若栈为空, 表示所有括号都配上对, 返回 true
        //若栈不为空, 表示右没配对的括号, 应返回 false
        return stack.isEmpty();
    }

    /*
        (   [   ]

        底 - 栈 - 顶
        )

        遇到左括号, 把要配对的右括号放入栈顶
        遇到右括号, 把它与栈顶元素对比
            若相等, 栈顶元素弹出, 继续对比下一组
            若不等, 无效括号直接返回 false
     */

    public static void main(String[] args) {
        E01LetCode20 s = new E01LetCode20();
        System.out.println(s.isValid("([{}])"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("()"));
        System.out.println("---------------------");

        System.out.println(s.isValid("[)"));
        // ]
        System.out.println(s.isValid("([)]"));
        // ) ]
        System.out.println(s.isValid("([]"));
        // )
        System.out.println(s.isValid("("));

        System.out.println("---------------------");
        System.out.println(s.isValid(")("));
        System.out.println(s.isValid("]"));
    }
}
