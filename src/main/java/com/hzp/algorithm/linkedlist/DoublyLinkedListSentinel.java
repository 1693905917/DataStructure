package com.hzp.algorithm.linkedlist;

import java.util.Iterator;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.linkedlist
 * @Author: ASUS
 * @CreateTime: 2023-09-11  11:35
 * @Description: TODO  双向链表（带哨兵）
 * @Version: 1.0
 */
public class DoublyLinkedListSentinel implements Iterable<Integer>{


    static class Node{
        Node prev;//上一节点指针
        int value;//值
        Node next;//下一个节点指针

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;//头哨兵
    private Node tail;//尾哨兵

    //初始化双向链表---哨兵版本
    public DoublyLinkedListSentinel(){
        head=new Node(null,666,null);
        tail=new Node(null,888,null);
        head.next=tail;//初始化时，头哨兵的尾是指向尾哨兵的头
        tail.prev=head;//初始化时，尾哨兵的尾是指向头哨兵的头
    }

    //根据index寻找节点
    private Node findNode(int index){
        int i=-1;
        //从头哨兵开始查，结束条件是到尾哨兵时就结束
        for (Node p=head;p!=tail;p=p.next,i++){
            if(i==index){
                return p;
            }
        }
        return null;
    }

    //根据index来插入节点
    public void insert(int index,int value){
        //前一节点
        Node prev = findNode(index - 1);
        //当index输入不合法
        if(prev==null){
            illegalIndex(index);
        }
        //后一节点
        Node next=prev.next;
        Node inserted = new Node(prev, value, next);
        //使得新插入的节点的值指向前一节点的尾
        prev.next=inserted;
        //使得新插入的节点的值指向后一节点的头
        next.prev=inserted;
    }

    //在头部添加新节点
    public void addFirst(int value){
        insert(0,value);
    }
    //在尾部添加新节点
    public void addLast(int value){
        //获取当前尾节点的前一个节点
        Node last = tail.prev;
        //新建节点
        Node added = new Node(last, value, tail);
        last.next=added;
        tail.prev=added;
    }

    //根据index进行删除节点操作
    public void remove(int index){
        Node prev = findNode(index - 1);
        if(prev==null){
            illegalIndex(index);
        }
        //找到需要删除的节点
        Node removed = prev.next;
        //对于删除的是尾节点，我们要进行判断
        if(removed==tail){
            illegalIndex(index);
        }
        Node next = removed.next;
        //被删除节点的前后节点进行对接
        prev.next=next;
        next.prev=prev;
    }

    public void removeFirst(){
        remove(0);
    }

    //删除最后的节点
    public void removeLast(){
        Node removed = tail.prev;
        //判断删除的是头哨兵时
        if(removed==head){
            illegalIndex(0);
        }
        Node prev = removed.prev;
        prev.next=tail;
        tail.prev=prev;

    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {

                return p!=tail;
            }
            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private void illegalIndex(int index) {
        throw new IllegalArgumentException(
                String.format("index {%d} 不合法\n", index));
    }


}
