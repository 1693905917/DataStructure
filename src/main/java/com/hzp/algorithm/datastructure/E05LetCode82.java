package com.hzp.algorithm.datastructure;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-21  10:11
 * @Description: TODO 有序链表去重-力扣 82 题
 * @Version: 1.0
 */
public class E05LetCode82 {

    //输入：head = [1,2,3,3,4,4,5]
    //输出：[1,2,5]
    //
    //输入：head = [1,1,1,2,3]
    //输出：[2,3]

    //注意：**重复元素一个不留**

    //方法1  递归
    public ListNode deleteDuplication1(ListNode p){
        //当节点数<2
        if(p==null ||p.next ==null){
            return p;
        }

        //当节点数>=2
        if(p.value==p.next.value){
            ListNode x = p.next.next;
            while (x!=null && x.value==p.value){
                x=x.next;
            }
            //跳出while循环时，x就是与p取值不同的节点
            return deleteDuplication1(x);
        }else {
            p.next=deleteDuplication1(p.next);
            return p;
        }
    }

    //方法2
    public ListNode deleteDuplication(ListNode p){
        //当节点数<2
        if(p==null ||p.next ==null){
            return p;
        }
        ListNode s=new ListNode(-1,p);
        ListNode p1=s;
        ListNode p2=p1.next;
        ListNode p3=p2.next;

        while (p2!=null && p3!=null){
            if(p2.value==p3.value){//如果相等，咱们就移动p3
                while (p3!=null&&p2.value==p3.value){
                    p3=p3.next;
                }
                p1.next=p3;
                p2=p1.next;
                p3=p2.next;
            }else {
               p1=p1.next;
               p2=p1.next;
               p3=p2.next;
            }
        }
        return s.next;
    }


    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 3,4,4,5);
        System.out.println(head);
        System.out.println(new E05LetCode82().deleteDuplication(head));
    }


}
