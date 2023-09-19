package com.hzp.algorithm.datastructure;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-17  21:38
 * @Description: TODO  通用节点类
 * @Version: 1.0
 */
public class ListNode {

    public int value;
    public ListNode next;


    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("[");
        ListNode p = this;
        while (p != null) {
            sb.append(p.value);
            if (p.next != null) {
                sb.append(",");
            }
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }
    //创建新链表并且赋值
    public static ListNode of(int... elements) {
        if (elements.length == 0) {
            return null;
        }
        ListNode p = null;
        for (int i = elements.length - 1; i >= 0; i--) {
            p = new ListNode(elements[i], p);
        }
        return p;
    }
}
