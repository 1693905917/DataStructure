package com.hzp.algorithm.datastructure;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-20  20:12
 * @Description: TODO 删除倒数节点
 * @Version: 1.0
 */
public class E03LetCode19 {

    //输入：head = [1,2,3,4,5], n = 2
    //输出：[1,2,3,5]

    //方法1
    //n:是从1开始
    public ListNode removeNthFromEnd1(ListNode head,int n){
        //设置哨兵s  ：为了是对于1也能够获取相应的索引数  如果不加哨兵 我们就不知道最前面的数的索引位置
        ListNode s = new ListNode(-1, head);
        recursion(s,n);
        return head;
    }

    private int recursion(ListNode p,int n){
        if(p==null){
            return 0;
        }
        //nth:下一个节点的倒数位置
        int nth=recursion(p.next,n);
        System.out.println(p.value+" "+nth);
        if(nth==n){
            //p=3 p.next=4  p.next.next=5
            p.next=p.next.next;
        }
        return nth+1;
    }
    //方法2
    public ListNode removeNthFromEnd(ListNode head,int n){
        //设置哨兵
        ListNode s = new ListNode(-1, head);
        ListNode p1=s;
        ListNode p2=s;
        for (int i=0;i<n+1;i++){
            p2=p2.next;
        }
        while (p2!=null){
            p1=p1.next;
            p2=p2.next;
        }
        //删除
        p1.next=p1.next.next;
        return s.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(head);
        System.out.println(new E03LetCode19().removeNthFromEnd(head,5));
    }

}
