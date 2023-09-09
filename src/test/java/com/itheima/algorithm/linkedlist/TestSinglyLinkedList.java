package com.itheima.algorithm.linkedlist;

import com.hzp.algorithm.linkedlist.SinglyLinkedList;
import org.junit.Test;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.itheima.algorithm.linkedlist
 * @Author: ASUS
 * @CreateTime: 2023-09-08  15:36
 * @Description: TODO
 * @Version: 1.0
 */
public class TestSinglyLinkedList {

    @Test
    public void test1(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        list.loop2(value->{
            System.out.println(value);
        });
    }

    @Test
    public void test2(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        for (Integer value : list) {
            System.out.println(value);
        }
    }

    //测试**尾部添加**操作
    @Test
    public void test3(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3); //2
        list.addLast(4);

        int i=list.get(10);
        System.out.println(i);
//        for (Integer value : list) {
//            System.out.println(value);
//        }
    }

    //测试插入操作
    @Test
    public void test4(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3); //2
        list.addLast(4);

        list.insert(4,5);
        for (Integer value : list) {
            System.out.println(value);
        }
    }
    //测试 删除链表中第一个节点
    @Test
    public void test5(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3); //2
        list.addLast(4);

        list.removeFirst();
        for (Integer value : list) {
            System.out.println(value);
        }

        System.out.println("===========");

        list.removeFirst();
        for (Integer value : list) {
            System.out.println(value);
        }


        System.out.println("===========");

        list.removeFirst();
        for (Integer value : list) {
            System.out.println(value);
        }

        System.out.println("===========");

        list.removeFirst();
        for (Integer value : list) {
            System.out.println(value);
        }

        System.out.println("===========");

        list.removeFirst();
        for (Integer value : list) {
            System.out.println(value);
        }

    }


    //测试 根据索引来上传链表中相对应的节点
    @Test
    public void test6(){
//        SinglyLinkedList list1 = new SinglyLinkedList();
//        list1.addLast(1);
//        list1.addLast(2);
//        list1.addLast(3); //2
//        list1.addLast(4);
//        list1.remove(2);
//
//        for (Integer value : list1) {
//            System.out.println(value);
//        }

//        SinglyLinkedList list2 = new SinglyLinkedList();
//        list2.addLast(1);
//        list2.addLast(2);
//        list2.addLast(3); //2
//        list2.addLast(4);
//        list2.remove(0);
//
//        for (Integer value : list2) {
//            System.out.println(value);
//        }

//        SinglyLinkedList list3 = new SinglyLinkedList();
//        list3.addLast(1);
//        list3.addLast(2);
//        list3.addLast(3); //2
//        list3.addLast(4);
//        list3.remove(5);
//
//        for (Integer value : list3) {
//            System.out.println(value);
//        }

        SinglyLinkedList list4 = new SinglyLinkedList();
        list4.addLast(1);
        list4.addLast(2);
        list4.addLast(3); //2
        list4.addLast(4);
        list4.remove(4);

        for (Integer value : list4) {
            System.out.println(value);
        }



    }



}
