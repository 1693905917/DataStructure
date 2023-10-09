package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.queue.TreeNode;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-08  23:09
 * @Description: TODO  验证二叉搜索树
 * @Version: 1.0
 */
public class E01LetCode98 {
    // 解法1. 中序遍历非递归实现 1ms
    public boolean isValidBST1(TreeNode node) {
        TreeNode p = node;
        LinkedList<TreeNode> stack = new LinkedList<>();
        long prev = Long.MIN_VALUE; // 代表上一个值
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                // 处理值
//                System.out.println("compare:" + prev + " " + pop.val);
                if (prev >= pop.val) {
                    return false;
                }
                prev = pop.val;
                p = pop.right;
            }
        }
        return true;
    }

    // 解法2. 中序遍历递归实现(全局变量记录 prev) 0ms
    long prev = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean a = isValidBST2(node.left);
        if (!a) {
            return false;
        }
        if (prev >= node.val) {
            return false;
        }
        prev = node.val;
        return isValidBST2(node.right);
    }

    // 解法3. 中序遍历递归实现(局部变量记录 prev) 0ms
    public boolean isValidBST3(TreeNode node) {
        return doValid3(node, new AtomicLong(Long.MIN_VALUE));
    }
    private boolean doValid3(TreeNode node, AtomicLong prev) {
        if (node == null) {
            return true;
        }
        boolean a = doValid3(node.left, prev);
        if (!a) {
            return false;
        }
        if (prev.get() >= node.val) {
            return false;
        }
        prev.set(node.val);
        return doValid3(node.right, prev);
    }

    /*
        能否只判断父亲比左孩子大，比右孩子小? 答：不行的，案例2中：4的右边有个3就不符合，
        也就是说 这个思路只考虑了父与子之间的大小关系，而没有考虑到祖先与子孙之间的大小关系
   案例1：               4
                      /   \
                     2     6
                    / \
                   1   3
   */
    /*案例2：
                 4
               /   \
              2     6
                   / \
                  3   7
     */
    // 解法4. 上下限递归实现 0ms
    //			    -∞ 4 +∞
    //               /   \
    //           -∞ 2  4  6 +∞
    //                   / \
    //                4 3 6 7 +∞
    //什么叫上下限递归实现？  比如上面的4，4是根节点，所以4的上限：+∞  下限：-∞
    //2的上限：4   下限：-∞
    //6的上限：+∞  下限：4
    //3的上限：6  下限：4
    //7的上限：+∞  下限：6
    // 解法4. 上下限递归实现 0ms
    public boolean isValidBST(TreeNode node) {
        return doValid4(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean doValid4(TreeNode node, long min, long max){
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return doValid4(node.left, min, node.val) && doValid4(node.right, node.val, max);
    }


}
