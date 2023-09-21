package com.hzp.algorithm.datastructure;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-21  14:48
 * @Description: TODO  合并有序链表-力扣 21 题
 * @Version: 1.0
 */
public class E06LetCode21 {
    //输入：l1 = [1,2,4], l2 = [1,3,4]
    //输出：[1,1,2,3,4,4]
    //
    //输入：l1 = [], l2 = []
    //输出：[]
    //
    //输入：l1 = [], l2 = [0]
    //输出：[0]

    //方法1
    public ListNode mergeTwoLists1(ListNode p1,ListNode p2){
        ListNode s = new ListNode(-1, null);
        ListNode p=s;
        while(p1!=null && p2!=null){
            if(p1.value<p2.value){
                p.next=p1;
                p1=p1.next;
            }else{
                p.next=p2;
                p2=p2.next;
            }
            p=p.next;
        }

        if(p1!=null){
            p.next=p1;
        }
        if(p2!=null){
            p.next=p2;
        }
        return s.next;
    }
    //方法2：递归
    public ListNode mergeTwoLists(ListNode p1,ListNode p2){
        if(p1==null){
            return p2;
        }
        if(p2==null){
            return p1;
        }
        if(p1.value<p2.value){
            p1.next=mergeTwoLists(p1.next,p2);
            return p1;
        }else{
            p2.next=mergeTwoLists(p1,p2.next);
            return p2;
        }
    }



    public static void main(String[] args) {
        ListNode p1 = ListNode.of(1,3,8,9);
        ListNode p2 = ListNode.of(2,4);
        System.out.println(new E06LetCode21().mergeTwoLists(p1,p2));
    }

}
