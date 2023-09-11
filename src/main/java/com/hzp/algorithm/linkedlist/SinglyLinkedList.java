package com.hzp.algorithm.linkedlist;

import javafx.scene.chart.ValueAxis;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.linkedlist
 * @Author: ASUS
 * @CreateTime: 2023-09-08  15:08
 * @Description: TODO  单向链表
 * @Version: 1.0
 */
//如果要实现迭代器遍历，首先要实现Iterable<>接口，
// 这个接口还有个泛型 泛型呢就是说你将来要遍历出来那个值的类型
public class SinglyLinkedList implements Iterable<Integer>{  //将SinglyLinkedList看成单向链表整体
    private Node head=new Node(666,null);  //头指针  加入哨兵
    //private Node head; //头指针  未加哨兵

    @Override
    public Iterator<Integer> iterator() {
        //匿名内部类
        return new NodeIterator();
    }

    //迭代器遍历
    private class NodeIterator implements Iterator<Integer> {
        Node p=head.next;

        @Override
        public boolean hasNext() {//是否有下一个元素
            return p!=null;
        }

        @Override
        public Integer next() {//返回当前值，并指向下一个元素
            int v=p.value;
            p=p.next;
            return v;
        }
    }
    //节点类
    //问题：为什么要做成SinglyLinkedList为外部类，Node设置为内部类？
    //答：对外隐藏实现细节  设置private static为了访问安全问题
    private static class Node{
        int value;//值
        Node next;//下一个节点的指针
        //创造这个构造方法是为了方便赋值
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /*
     * @description:向链表头部添加
     * @author:  HZP
     * @date: 2023/9/8 15:22
     * @param:value-待添加值
     * @return:
     **/
    public void addFirst(int value){
        insert(0,value);
        //1.链表为空
        //head=new Node(value,null);
        //2.链表非空  其实“2.链表非空”就包含了"1.链表为空"
        //head=new Node(value,head);
    }

    /*
     * @description:遍历链表
     * @author:  HZP
     * @date: 2023/9/8 15:36
     * @param:
     * @return:
     **/
    //为什么要使用Consumer<Integer> consumer？
    //答：要执行的操作最好不要把它写在循环里面，而是把它当成参数传递进来
    //consumer会把要执行的操作从外界传递过来
    public void loop1(Consumer<Integer> consumer){
        Node p=head.next;
        while(p!=null){
            consumer.accept(p.value);
            p=p.next;
        }
    }

    //for循环遍历
    public void loop2(Consumer<Integer> consumer){
        for (Node p=head.next;p!=null; p=p.next){
            consumer.accept(p.value);
        }
    }

    public void loop3(){
        recursion(head);
    }

    private void recursion(Node curr){//curr：当前节点
        if(curr==null){
            return;
        }
        System.out.println("before:"+curr.value);
        recursion(curr.next);
        System.out.println("after:"+curr.value);
    }

    //从头找到最后一个链表
    private Node findLast(){
        Node p=head;
        while(p.next!=null){
            p=p.next;
        }
//        Node p;
//        for (p=head;p.next!=null;p=p.next){}
        return p;
    }

    //**尾部添加**操作
    public void addLast(int value){
        Node last = findLast();
        //在尾部添加链表
        last.next=new Node(value,null);
    }



    //根据索引查找相应链表
    private Node findNode(int index){
        //确保在索引是0时，对于index - 1指向哨兵
        int i=-1;
        for (Node p=head;p!=null;p=p.next,i++){
            if(i==index){
                return p;
            }
        }
        return null;//没有找到
    }


    //根据索引得到相应链表的值
    public int get(int index){
        Node node = findNode(index);
        if(node==null){
            illegalIndex(index);
        }
        return node.value;
    }

    private void illegalIndex(int index) {
        throw new IllegalArgumentException(
                String.format("index {%d} 不合法\n", index));
    }

    //向索引位置插入
    //Params:index-索引
    //value-待插入值
    //Throws:IllegalArgumentException-找不到，抛出index非法异常
    public void insert(int index,int value){
        //如果给予的index是0，则相当于向头部添加新索引
//        if(index==0){
//            addFirst(value);
//            return;
//        }
        Node prev = findNode(index - 1);//找到上一个节点
        if(prev==null){  //如果index是找不到的
            illegalIndex(index);
        }
        prev.next=new Node(value,prev.next);
    }

    //删除链表中第一个节点
    public void removeFirst(){
        remove(0);
//        if(head==null){
//            illegalIndex(0);
//        }
//        head=head.next;
    }


    //根据索引来上传链表中相对应的节点
    public void remove(int index){
//        if(index==0){  //当索引是0
//            removeFirst();
//            return;
//        }
        //上一个节点
        Node prev = findNode(index - 1);
        if(prev==null){  //如果未找到相应的节点
            illegalIndex(index);
        }
        //被删除的节点
        Node removed=prev.next;
        if(removed==null){
            illegalIndex(index);
        }
        prev.next=removed.next;

    }



}
