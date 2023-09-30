package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.stack.ArrayStack;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-29  17:41
 * @Description: TODO 双栈模拟队列
 * @Version: 1.0
 */
public class E04LetCode232 {
    /*
       队列头      队列尾
       s1       	s2
       顶   底   底   顶
                a	  b
       队列尾添加
       s2.push(a)
       s2.push(b)

       队列头移除:先把s2的所有元素移动到s1，也就是先s2.pop(),再将s2.pop()的值进行s1.push(）
       s1.pop()
    */
    ArrayStack<Integer> s1 = new ArrayStack<>(100);
    ArrayStack<Integer> s2 = new ArrayStack<>(100);

    public void push(int x) { //向队列尾添加
        s2.push(x);
    }

    public int pop() {  //从对列头移除
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return s1.pop();
    }

    public int peek() {  //从对列头获取
        if (s1.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
