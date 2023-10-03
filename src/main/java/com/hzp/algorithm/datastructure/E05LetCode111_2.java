package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-03  11:24
 * @Description: TODO 二叉树最小深度-递归求解
 * @Version: 1.0
 */
public class E05LetCode111_2 {
    public int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int d1 = minDepth(node.left);
        int d2 = minDepth(node.right);
        //不应该再把为 null 子树的深度 0 参与最小值比较
        //第一种写法：
        //if (d1 == 0 || d2 == 0) {
        //    return d1 + d2 + 1;
        //}
        //第二种写法：
        if(d1==0){//当右子树为NULL
            return d2+1;//返回左子树深度+1
        }
        if(d2==0){//当左子树为NULL
            return d1+1;//返回右子树深度+1
        }
        //只有两边子树都不为null时
        return Integer.min(d1, d2) + 1;
    }
}
