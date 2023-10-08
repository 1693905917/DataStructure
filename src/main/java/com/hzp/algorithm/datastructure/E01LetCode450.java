package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.queue.TreeNode;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-08  17:30
 * @Description: TODO 删除节点
 * @Version: 1.0
 */
public class E01LetCode450 {
    public TreeNode deleteNode(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.val) {
            node.left = deleteNode(node.left, key);
            return node;
        }
        if (node.val < key) {
            node.right = deleteNode(node.right, key);
            return node;
        }
        if (node.left == null) { // 情况1 - 只有右孩子
            return node.right;
        }
        if (node.right == null) { // 情况2 - 只有左孩子
            return node.left;
        }
        TreeNode s = node.right; // 情况3 - 有两个孩子
        while (s.left != null) {
            s = s.left;
        }
        s.right = deleteNode(node.right, s.val);
        s.left = node.left;
        return s;
    }
}
