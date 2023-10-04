package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.queue.TreeNode;

import java.util.Arrays;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-03  17:32
 * @Description: TODO 根据中序与后序遍历结果构造二叉树
 * @Version: 1.0
 */
public class E10LetCode106 {
    //1. pre-order 前序遍历，对于每一棵子树，先访问该节点，然后是左子树，最后是右子树
    //2. in-order 中序遍历，对于每一棵子树，先访问左子树，然后是该节点，最后是右子树
    //3. post-order 后序遍历，对于每一棵子树，先访问左子树，然后是右子树，最后是该节点
    /*
            inOrder = {4,2,1,6,3,7}
            postOrder = {4,2,6,7,3,1}

        根据后序遍历postOrder的性质： 该数组的最后一个数就是根节点： 1
               in        post
            左 4,2       4,2
            右 6,3,7     6,7,3
         */
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        if (inOrder.length == 0) {
            return null;
        }
        // 根
        int rootValue = postOrder[postOrder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        // 切分左右子树
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootValue) {
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i);
                int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);

                int[] postLeft = Arrays.copyOfRange(postOrder, 0, i);
                int[] postRight = Arrays.copyOfRange(postOrder, i, postOrder.length - 1);

                root.left = buildTree(inLeft, postLeft);
                root.right = buildTree(inRight, postRight);
                break;
            }
        }
        return root;
    }
}
