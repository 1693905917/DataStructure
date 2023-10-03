package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.queue.TreeNode;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-03  15:49
 * @Description: TODO 翻转二叉树
 * @Version: 1.0
 */
public class E07LetCode226 {

    public TreeNode invertTree(TreeNode root) {
        fn(root);
        return root;
    }

    private void fn(TreeNode node){
        if (node == null) {
            return;
        }
        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;
        fn(node.left);
        fn(node.right);
    }
}
