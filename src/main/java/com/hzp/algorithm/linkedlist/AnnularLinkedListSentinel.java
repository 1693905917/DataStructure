package com.hzp.algorithm.linkedlist;

import java.util.Iterator;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.linkedlist
 * @Author: ASUS
 * @CreateTime: 2023-09-11  16:19
 * @Description: TODO
 * @Version: 1.0
 */
public class AnnularLinkedListSentinel implements Iterable<Integer>{

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p=sentinel.next;
            @Override
            public boolean hasNext() {
                return p!=sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p=p.next;
                return value;
            }
        };
    }

    private static class Node{
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
    //创建哨兵节点
    private  Node sentinel=new Node(null,-1,null);

    public AnnularLinkedListSentinel(){
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
    }

    //添加到第一个节点   对于特殊情况：只有sentinel(哨兵)时，也符合要求
    public void addFirst(int value){
        Node a=sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next=added;
        b.prev=added;
    }

    //添加到最后一个
    public void addLast(int value){
        Node a = sentinel.prev;
        Node b=sentinel;

        Node added = new Node(a, value, b);
        a.next=added;
        b.prev=added;
    }

    //删除第一个
    public void removeFirst(){
        Node removed=sentinel.next;
        //判断是否删除的哨兵
        if(removed==sentinel){
            illegalIndex(0);
        }
        Node a=sentinel;
        Node b=removed.next;
        a.next=b;
        b.prev=a;
    }
    //删除最后一个
    public void removeLast(){
        Node removed=sentinel.prev;
        //判断是否删除的哨兵
        if(removed==sentinel){
            illegalIndex(0);
        }
        Node a=removed.prev;
        Node b=sentinel;
        a.next=b;
        b.prev=a;
    }


    private Node findByValue(int value){
        Node p=sentinel.next;
        while(p!=sentinel){
            if(p.value==value){
                return p;
            }
            p=p.next;
        }
        return null;
    }

    //根据值删除
    public void removeByValue(int value){
        Node removed = findByValue(value);
        if(removed==null){
            return;  //不用删
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next=b;
        b.prev=a;
    }






    private void illegalIndex(int index) {
        throw new IllegalArgumentException(
                String.format("index {%d} 不合法\n", index));
    }

}
