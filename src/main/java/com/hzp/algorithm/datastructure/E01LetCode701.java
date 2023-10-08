package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.queue.TreeNode;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-08  17:32
 * @Description: TODO 新增节点
 * @Version: 1.0
 */
public class E01LetCode701 {
    //这个递归的缺点：多出一些不必要的赋值动作，来时的所有节点又要在重新建立父子关系  如果要用非递归实现就不会有这种情况
    public TreeNode insertIntoBST(TreeNode node, int val) {
        //找到空位了
        if(node == null) {
            return new TreeNode(val);
        }
        if(val < node.val) {
            //一直找到有null的位置时就新增节点
            node.left = insertIntoBST(node.left, val);//将新创建好的新节点与父节点建立联系
        } else if(node.val < val) {
            node.right = insertIntoBST(node.right, val);
        }
        return node;
    }

}
