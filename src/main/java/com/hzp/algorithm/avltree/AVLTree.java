package com.hzp.algorithm.avltree;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.avltree
 * @Author: ASUS
 * @CreateTime: 2023-10-10  23:22
 * @Description: TODO AVL
 * @Version: 1.0
 */
public class AVLTree {

    //处理高度

    static class AVLNode {
        int height = 1;
        int key;
        Object value;
        AVLNode left;
        AVLNode right;
        // ...
    }

    //**求高度代码**
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }


    //更新高度
    private void updateHeight(AVLNode node) {
        node.height = Integer.max(height(node.left), height(node.right)) + 1;
    }
}
