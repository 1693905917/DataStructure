package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.queue.ArrayQueue3;
import com.hzp.algorithm.queue.ArrayQueue3_2;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-29  18:06
 * @Description: TODO
 * @Version: 1.0
 */
public class E05LetCode225 {

    /*

        栈顶      栈底
        d    c    b    a
        队列头    队列尾

        queue.offer(a)
        queue.offer(b)
        queue.offer(c)

        push 添加
            - 将新加入元素，前面的所有元素从队列头移动到队列尾
        pop 移除
            - 直接移除队列头元素

     */

    ArrayQueue3<Integer> queue = new ArrayQueue3(100);
    private int size = 0; //用来记录栈里有多少个数

    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
        size++;
    }

    public int pop() {
        size--;
        return queue.poll();
    }

    public int top() { //获取栈顶的数
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }




}
