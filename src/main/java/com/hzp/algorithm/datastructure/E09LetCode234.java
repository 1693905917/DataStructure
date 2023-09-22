package com.hzp.algorithm.datastructure;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-22  15:45
 * @Description: TODO
 * @Version: 1.0
 */
public class E09LetCode234 {
    //    步骤1. 找中间点
    //    步骤2. 中间点后半个链表反转
    //    步骤3. 反转后链表与原链表逐一比较


    //方法1
    public boolean isPalindrome1(ListNode head){
        //    步骤1. 找中间点
        ListNode middle = middle(head);
        System.out.println(middle);
        //    步骤2. 中间点后半个链表反转
        ListNode reverse = reverse(middle);
        System.out.println(reverse);
        while(reverse!=null){
            if(head.value!= reverse.value){
                return false;
            }
            head=head.next;
            reverse=reverse.next;
        }
        return true;
    }

    //    步骤2. 中间点后半个链表反转
    private ListNode reverse(ListNode middle){
        //创建一个新链表来存储反转以后的链表
        ListNode newHead=null;
        while (middle!=null){
            //创建一个中间值
            ListNode p=middle.next;
            middle.next=newHead;
            newHead=middle;
            middle=p;
        }
        return newHead;
    }



    //    步骤1. 找中间点
    //     返回：新节点   利用慢指针来找中间点
    private ListNode  middle(ListNode head){
        ListNode p1=head;//慢指针
        ListNode p2=head;//快指针

        while (p2!=null && p2.next!=null){
            p1=p1.next;
            p2=p2.next;
            p2=p2.next;
        }
        return p1;
    }

    //方法2
    public boolean isPalindrome(ListNode h1){
        if (h1 == null || h1.next == null) {
            return true;
        }
        ListNode p1 = h1; 	// 慢指针，中间点
        ListNode p2 = h1; 	// 快指针
        ListNode n1 = null;	// 新头
        ListNode o1 = h1;	// 旧头
        // 快慢指针找中间点
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            // 反转前半部分
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }
        if (p2 != null) { // 节点数为奇数
            p1 = p1.next;
        }
        // 同步比较新头和后半部分
        while (n1 != null) {
            if (n1.value != p1.value) {
                return false;
            }
            p1 = p1.next;
            n1 = n1.next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new E09LetCode234().isPalindrome1(ListNode.of(1,2,2,1)));
        System.out.println(new E09LetCode234().isPalindrome(ListNode.of(1,2,3,2,1)));
    }



}
