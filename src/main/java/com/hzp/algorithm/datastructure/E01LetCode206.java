package com.hzp.algorithm.datastructure;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-17  21:41
 * @Description: TODO
 * @Version: 1.0
 */
public class E01LetCode206 {

    //方法1
    //构造一个新链表，从旧链表依次拿到每个节点，创建新节点添加至新链表头部，完成后新链表即是倒序
    public ListNode reverseList1(ListNode o1){
        ListNode n1=null;
        ListNode p=o1;

        //将o1逆序存储
        while(p!=null){
             n1 = new ListNode(p.value, n1);
            p=p.next;
        }
        return n1;
    }

    //方法2
    public ListNode reverseList2(ListNode head){
        List list1 = new List(head);
        List list2 = new List(null);
        while(true){
            ListNode first = list1.removeFirst();
            //当都移除完了就退出循环
            if(first==null){
                break;
            }
            list2.addFirst(first);
        }
        return list2.head;
    }


    static class List{
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }
        //从头部开始添加新节点
        public void addFirst(ListNode first){
            first.next=head;
            head=first;
        }

        public ListNode removeFirst(){
            ListNode first=head;
            if(first!=null){
                head=first.next;
            }
            return first;
        }
    }
    //方法3：递归
    public ListNode reverseList3(ListNode p){
        //p==null的情况：防止链表是Null
        if(p==null||p.next==null){
            return p;
        }
        ListNode last = reverseList(p.next);
        //举例：5，4，3，2，1 当执行到最后“5”时，我们将5的下一个指针指向回"4"去
        p.next.next=p;
        //但是通过上述代码操作，会使得5->4 4——>5的死循环，
        //所以我们要进行p.next.next=p;也就是5->4时，进行p.next=null;操作也就是4——>null
        p.next=null;
        return last;
    }

    //方法4
    public ListNode reverseList4(ListNode o1){
        //对于特殊情况的处理  1.空链表 2.一个元素
        if(o1==null ||o1.next==null){
            return o1;
        }
        ListNode o2=o1.next;
        ListNode n1=o1;
        while(o2!=null){
            o1.next=o2.next;    //2.
            o2.next=n1;         //3.
            n1=o2;              //4.
            o2=o1.next;         //5.
        }
        return n1;
    }

    //方法5
    public ListNode reverseList(ListNode o1){
        //对于特殊情况的处理  1.空链表 2.一个元素
        if(o1==null || o1.next==null){
            return o1;
        }
        ListNode n1=null;
        while (o1!=null){
            ListNode o2=o1.next;    //2.
            o1.next=n1;             //3.
            n1=o1;                  //4.
            o1=o2;                  //4.
        }
        return n1;
    }


    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode n1 = new E01LetCode206().reverseList(o1);
        System.out.println(n1);
    }
}
