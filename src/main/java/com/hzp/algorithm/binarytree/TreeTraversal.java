package com.hzp.algorithm.binarytree;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.binarytree
 * @Author: ASUS
 * @CreateTime: 2023-10-02  17:32
 * @Description: TODO 二叉树深度优先遍历递归实现
 * @Version: 1.0
 */
public class TreeTraversal {
    /**
     * <h3>前序遍历：对于每一棵子树，先访问该节点，然后是左子树，最后是右子树</h3>
     * @param node 节点
     */
    static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        //先访问该节点
        System.out.print(node.val + "\t"); // 值
        //然后是左子树
        preOrder(node.left); // 左
        //最后是右子树
        preOrder(node.right); // 右
    }

    /**
     * <h3>中序遍历:对于每一棵子树，先访问左子树，然后是该节点，最后是右子树</h3>
     * @param node 节点
     */
    static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        //先访问左子树
        inOrder(node.left); // 左
        //然后是该节点
        System.out.print(node.val + "\t"); // 值
        //最后是右子树
        inOrder(node.right); // 右
    }

    /**
     * <h3>后序遍历:对于每一棵子树，先访问左子树，然后是右子树，最后是该节点</h3>
     * @param node 节点
     */
    static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        //先访问左子树
        postOrder(node.left); // 左
        //然后是右子树
        postOrder(node.right); // 右
        //最后是该节点
        System.out.print(node.val + "\t"); // 值
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             /   / \
            4   5   6
         */
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();

        postOrder(root);
        System.out.println();
    }
}
