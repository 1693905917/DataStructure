package com.hzp.algorithm.datastructure;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-23  16:18
 * @Description: TODO  环形链表-力扣 141 题  142 题
 * @Version: 1.0
 */
public class E10LetCode141 {
    //判断是否有环
    public boolean hasCycle(ListNode head){
        ListNode h=head; //兔
        ListNode t=head;//龟
        //判断条件：h!=null:当兔子能走到终点时，不存在环
        //h.next!=null 防止兔子连续跳两次中第一次跳出现空指针
        while(h!=null && h.next!=null){
            t=t.next;
            h=h.next.next;
            //当兔子能追上龟时，可以判断存在环
            if(h==t){
                return true;
            }
        }
        return false;
    }

    //查出环的入口
    public ListNode detectCycle(ListNode head){
        ListNode h=head; //兔
        ListNode t=head;//龟
        //判断条件：h!=null:当兔子能走到终点时，不存在环
        //h.next!=null 防止兔子连续跳两次中第一次跳出现空指针
        while(h!=null && h.next!=null){
            t=t.next;
            h=h.next.next;
            //当兔子能追上龟时，可以判断存在环
            if(h==t){
                //当符合第一阶段时，就进行第二阶段
                //2.1龟回到起点，兔子保特原位不变
                t=head;
                while(true){
                    //把if条件提到while循环最前面，是为了判断一种特殊情况：当这个环是首尾相连的大环时,
                    //龟回到起点，兔子保特原位不变 这个时候就是它们再次相遇
                    if(t==h){
                        return h;
                    }
                    //龟和兔子一次都走一步
                    t=t.next;
                    h=h.next;
                }
            }
        }
        return null;
    }



    public static void main(String[] args) {
        // 构造一个带环链表
        ListNode n12 = new ListNode(12, null);
        ListNode n11 = new ListNode(11, n12);
        ListNode n10 = new ListNode(10, n11);
        ListNode n9 = new ListNode(9, n10);
        ListNode n8 = new ListNode(8, n9);
        ListNode n7 = new ListNode(7, n8);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        n12.next = n1;
        ListNode x = new E10LetCode141().detectCycle(n1);
        System.out.println(x.value);
    }




}
