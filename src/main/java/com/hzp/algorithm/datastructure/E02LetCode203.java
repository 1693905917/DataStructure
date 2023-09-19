package com.hzp.algorithm.datastructure;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-19  21:37
 * @Description: TODO
 * @Version: 1.0
 */
public class E02LetCode203 {


    //head:s -> 1 -> 2 -> 6 -> 3 -> 6 -> null
    //方法一：
    public ListNode removeElements1(ListNode head,int value){
        //创建一个哨兵节点
        ListNode s=new ListNode(-1,head);
        ListNode p1=s;//p1初始指向的是哨兵s
        ListNode p2=s.next; //p2指向的是1
        while (p2!=null){
            if(p2.value ==value){
                //删除
                p1.next=p2.next;
                p2=p2.next; //p2后移
            }else {
                //p1 p2 向后移动
                p1=p1.next;
                p2=p2.next;
            }
        }
        return s.next;
    }

    //方法2：递归
    public ListNode removeElements(ListNode p,int value){
        if(p==null){
            return null;
        }
        if(p.value==value){
            return removeElements(p.next,value);
        }else{
            p.next=removeElements(p.next,value);
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 6, 3, 6);
        System.out.println(head);
        System.out.println(new E02LetCode203().removeElements(head,6));
    }

}
