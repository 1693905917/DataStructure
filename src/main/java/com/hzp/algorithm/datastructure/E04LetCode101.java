package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.binarytree.TreeNode;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-03  11:09
 * @Description: TODO 对称二叉树
 * @Version: 1.0
 */
public class E04LetCode101 {
    public boolean isSymmetric(TreeNode root) {
        //刚刚开始，传入的是顶堆的左、右两个子叶
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        // 若同时为 null：也就是整个二叉树就只有一个元素就是顶堆
        if (left == null && right == null) {
            return true;
        }
        // 若有一个为 null (有上一轮筛选，另一个肯定不为 null)
        if (left == null || right == null) {
            return false;
        }
        //都不为null，则查看值相不相同
        if (left.val != right.val) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
