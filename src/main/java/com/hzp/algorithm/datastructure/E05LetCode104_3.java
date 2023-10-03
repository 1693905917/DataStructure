package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-03  11:24
 * @Description: TODO 二叉树最大深度-层序遍历求解
 * @Version: 1.0
 */
public class E05LetCode104_3 {
    /*
    思路：
    1. 使用层序遍历, 层数即最大深度
 */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        //LinkedList既可以做为双向链表、队列、栈
        Queue<TreeNode> queue = new LinkedList<>();
        //将根节点加入到队列中
        queue.offer(root);
        int level = 0;//深度
        //不断从队列的头部取出元素,然后把其子节点加入到队列中
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();//获取每层节点个数
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
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
