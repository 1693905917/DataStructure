package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-03  11:24
 * @Description: TODO 二叉树最大深度-后序遍历求解-非递归法
 * @Version: 1.0
 */
public class E05LetCode104_2 {
    /*
     思路：
     1. 使用非递归后序遍历, 栈的最大高度即为最大深度
  */
    public int maxDepth(TreeNode root) {
        TreeNode curr = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int max = 0;
        TreeNode pop = null;
        while (curr != null || !stack.isEmpty()) {
            //先访问左子树
            if (curr != null) {
                //访问左子树时记得压栈
                stack.push(curr);
                //通过栈的大小来记录其最大深度
                int size = stack.size();
                if (size > max) {
                    max = size;
                }
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if(peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                } else {
                    curr = peek.right;
                }
            }
        }
        return max;
    }
}
