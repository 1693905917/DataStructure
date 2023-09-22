package com.hzp.algorithm.datastructure;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-21  15:36
 * @Description: TODO 合并多个有序链表
 * @Version: 1.0
 */
public class E07LetCode23 {
    //合并两个有序链表
    //方法1
    public ListNode mergeTwoLists(ListNode p1,ListNode p2){
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


    //将链表数组拆分到底层只剩下一个链表
    public ListNode mergeKLists(ListNode[] lists ){
        if(lists.length==0){
            return null;
        }
        return split(lists,0, lists.length-1);
    }

    //返回合并后的链表，i,j代表左\右边界
    private ListNode split(ListNode[] lists,int i,int j){
        //当数组内只有一个链表
        if(i==j){
            return lists[i];
        }
        int m= (i+j)>>>1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m + 1, j);
        return mergeTwoLists(left,right);
    }

    public static void main(String[] args) {
        ListNode[] lists={ ListNode.of(1,4,5), ListNode.of(1,3,4), ListNode.of(2,6)};
        System.out.println(new E07LetCode23().mergeKLists(lists));
    }


}
