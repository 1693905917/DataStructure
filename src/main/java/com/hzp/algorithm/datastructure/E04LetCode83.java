package com.hzp.algorithm.datastructure;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-20  20:50
 * @Description: TODO  有序链表去重
 * @Version: 1.0
 */
public class E04LetCode83 {
    //输入：head = [1,1,2]
    //输出：[1,2]
    //
    //输入：head = [1,1,2,3,3]
    //输出：[1,2,3]
    public ListNode deleteDuplication(ListNode head){
        //节点数 <2
        if(head ==null ||head.next==null){
            return head;
        }
        //节点数>=2
        ListNode p1=head;
        ListNode p2=p1.next;
        while(p2!=null){
            if(p1.value==p2.value){
                //删除p2
                p1.next=p2.next;
            }else{
                //p1、p2向后移动
                p1=p1.next;
            }
            p2=p1.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 1, 2, 3, 3);
        System.out.println(head);
        System.out.println(new E04LetCode83().deleteDuplication(head));
    }


}
