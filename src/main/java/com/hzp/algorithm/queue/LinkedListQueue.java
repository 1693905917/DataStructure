package com.hzp.algorithm.queue;

import java.util.Iterator;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.queue
 * @Author: ASUS
 * @CreateTime: 2023-09-25  10:17
 * @Description: TODO 以**单向环形带哨兵**链表方式来实现队列
 * @Version: 1.0
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E>{

    //初始化链表
    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head = new Node<>(null, null);
    private Node<E> tail = head;
    private int size = 0;//节点数
    private int capacity = Integer.MAX_VALUE;//容量  默认初始容量：Integer.MAX_VALUE

    //在java里，如果构造方法里有重复的代码，可以写在初始化语句块中
    {
        tail.next = head;
    }

    public LinkedListQueue() {
        //tail.next = head;
    }
    //如果调用了有参构造,可以设置容量
    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
        //tail.next = head;
    }

    @Override
    public boolean offer(E value) {
        //如果容量满了，就停止添加操作
        if (isFull()) {
            return false;
        }
        Node<E> added = new Node<>(value, head);
        tail.next = added;
        tail = added;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        //当链表中只有一个节点
        if (first == tail) {
            tail = head;
        }
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        //当头指向尾，就是没有节点
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                //当我最后一个节点的下一个节点不是头节点
                return p != head;
            }
            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
