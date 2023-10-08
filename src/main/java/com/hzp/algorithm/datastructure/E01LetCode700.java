package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.queue.TreeNode;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-08  17:32
 * @Description: TODO 查询节点
 * @Version: 1.0
 */
public class E01LetCode700 {
    public TreeNode searchBST(TreeNode node, int val) {
        if(node == null) {
            return null;
        }
        if(val < node.val) {
            return searchBST(node.left, val);
        } else if(node.val < val) {
            return searchBST(node.right, val);
        } else {
            return node;
        }
    }
}
