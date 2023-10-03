package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-03  11:24
 * @Description: TODO 二叉树最小深度-层序遍历求解
 * @Version: 1.0
 */
public class E05LetCode111_1 {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //找寻叶子节点：左右孩子都是Null就是叶子节点
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return level;
    }
}
