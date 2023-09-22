package com.hzp.algorithm.datastructure;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-21  16:20
 * @Description: TODO  查找链表中间节点
 * @Version: 1.0
 */
public class E08LetCode876 {

    public ListNode middleNode(ListNode head){
        ListNode p1=head;
        ListNode p2=head;

        while(p2!=null && p2.next!=null){
            p1=p1.next;
            p2=p2.next;
            p2=p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode p1 = ListNode.of(1,2,3,4,5);
        System.out.println(new E08LetCode876().middleNode(p1));
        ListNode p2 = ListNode.of(1,2,3,4,5,6);
        System.out.println(new E08LetCode876().middleNode(p2));
    }


}
