package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.queue.TreeNode;

import java.util.LinkedList;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-08  23:41
 * @Description: TODO 求范围和
 * @Version: 1.0
 */
public class E01LetCode938 {
    // 解法2. 上下限递归 0ms
    public int rangeSumBST(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }
        if (node.val < low) {
            return rangeSumBST(node.right, low, high);
        }
        if (node.val > high) {
            return rangeSumBST(node.left, low, high);
        }
        // 在范围内
        return node.val + rangeSumBST(node.left, low, high) + rangeSumBST(node.right, low, high);
    }

    /*
                 10
                /  \
               5    15
              / \    \
             3   7    18        low=7  high=15
         */
//我们从根节点10开始时，10属于low-high范围内，就累加然后向下递归，到5时，5<low就不需要再去判断5的左子树了，而是去递归5的右子树
//那么这样就实现了《中序非递归实现》的不足之处
    // 解法1. 中序遍历非递归实现 4ms
    public int rangeSumBST1(TreeNode node, int low, int high) {
        TreeNode p = node;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int sum = 0;
        while(p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                // 处理值
                if (pop.val > high) {
                    break;
                }
                if (pop.val >= low) {
                    sum += pop.val;
                }
                p = pop.right;
            }
        }
        return sum;
    }

}
