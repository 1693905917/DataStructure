package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.binarytree.TreeNode;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-03  11:24
 * @Description: TODO 二叉树最大深度-后序遍历求解-递归法
 * @Version: 1.0
 */
public class E05LetCode104_1 {
    /*
    思路：
    1. 得到左子树深度, 得到右子树深度, 二者最大者加一, 就是本节点深度
    2. 因为需要先得到左右子树深度, 很显然是后序遍历典型应用
    3. 关于深度的定义：从根出发, 离根最远的节点的总边数,这个总边数指的就是下面的线段数
        注意: 力扣里的深度定义要多一,在你现在看来下面的深度确实是1 2 0  但是力扣官方觉得：在你看来的基础上+1才是正确的深度

  你的视角：      深度:1         深度:2         深度:0
  力扣的视角：      深度:2         深度:3         深度:1
                    1            1            1
                   / \          / \
                  2   3        2   3
                                    \
                                     4
 */
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0; // 非力扣题目改为返回 -1
        }
        int d1 = maxDepth(node.left);
        int d2 = maxDepth(node.right);
        return Integer.max(d1, d2) + 1;
    }
}
