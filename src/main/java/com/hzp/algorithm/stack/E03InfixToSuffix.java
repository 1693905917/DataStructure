package com.hzp.algorithm.stack;

import java.util.LinkedList;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.stack
 * @Author: ASUS
 * @CreateTime: 2023-09-29  15:54
 * @Description: TODO 中缀表达式转后缀
 * @Version: 1.0
 */
public class E03InfixToSuffix {
    /*
        思路

        |   |
        |   |
        |   |
        _____

        a+b             ab+
        a+b-c           ab+c-
        a*b+c           ab*c+
        a+b*c           abc*+
        a+b*c-d         abc*+d-
        (a+b)*c         ab+c*
        (a+b*c-d)*e     abc*+d-e*
        a*(b+c)         abc+*

        1. 遇到非运算符 直接拼串
        2. 遇到 + - * /
            - 它的优先级比栈顶运算符高, 入栈, 如: 栈中是 + 当前是 *
            - 否则把栈里优先级 >= 它 的都出栈, 它再入栈, 如: 栈中是 +*, 当前是 -
        3. 遍历完成, 栈里剩余运算符依次出栈
        4. 带()
            - 左括号直接入栈, 左括号优先设置为0
            - 右括号就把栈里到左括号为止的所有运算符出栈
     */


    //1.我们以a+b*c-d为例：我们要先给"+"、"-"、"*"、"/"这四个设置优先级
    static  int priority(char c){//c:是"+"、"-"、"*"、"/"其中的一个
        switch (c){
//            4. 带()
//            - 左括号直接入栈, 左括号优先设置为0
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                throw new IllegalArgumentException("不合法的运算符:"+c);
        }
    }

    //参数exp:a+b*c-d
    static String infixToSuffix(String exp){
        LinkedList<Character> stack=new LinkedList<>();
        //我们对于exp参数中的值a+b*c-d进行重组  得到这个后缀形式：abc*+d-
        StringBuilder sb=new StringBuilder(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            //从exp中获取每一个字符
            char c=exp.charAt(i);
            switch (c){
                //当c为运算符时，进行的操作：
                //2. 遇到 + - * /
                //            - 它的优先级比栈顶运算符高, 入栈, 如: 栈中是 + 当前是 *
                //            - 否则把栈里优先级 >= 它 的都出栈, 它再入栈, 如: 栈中是 +*, 当前是 -
                case '*':
                case '/':
                case '+':
                case '-':
                    if(stack.isEmpty()){//当我们栈为空时,我们就加运算符直接压栈
                        stack.push(c);
                    }else{
                        //当栈不为空时,我们就要判断当前c的运算符优先级与栈顶的优先级谁高,谁高先将谁从栈中挑出进行字符串拼接
                        if(priority(c)>priority(stack.peek())){
                            stack.push(c);
                        }else{
                            while (!stack.isEmpty()&&priority(stack.peek())>=priority(c)){
                                sb.append(stack.pop());
                            }
                            stack.push(c);
                        }
                    }
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    while (!stack.isEmpty()&&stack.peek()!='('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default: //当c为非运算符，进行的操作：
                    //1. 遇到非运算符 直接拼串
                    sb.append(c);
                    break;
            }
        }
        //3.遍历完成, 栈里剩余运算符依次出栈
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(infixToSuffix("a+b"));
        System.out.println(infixToSuffix("a+b-c"));
        System.out.println(infixToSuffix("a+b*c"));
        System.out.println(infixToSuffix("a*b-c"));
        System.out.println(infixToSuffix("(a+b)*c"));
        System.out.println(infixToSuffix("(a+b*c-d)*e"));
        System.out.println(infixToSuffix("a*(b+c)"));
    }



}
