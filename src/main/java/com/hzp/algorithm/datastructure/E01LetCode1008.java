package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.queue.TreeNode;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-09  16:05
 * @Description: TODO 根据前序遍历结果构造二叉搜索树
 * @Version: 1.0
 */
public class E01LetCode1008 {

    //第一种方法:直接插入法
    // 8 5 1 7 10
/*
                8
               / \
              5   10
             / \   \
            1   7  12
         */
    public TreeNode bstFromPreorder(int[] preorder) {
        //数组索引[0]的位置为根节点
        TreeNode root = insert(null, preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }
        return root;
    }

    private TreeNode insert(TreeNode node, int val) {
        //找到空位了就创建一个新节点将val插入进去
        if (node == null) {
            return new TreeNode(val);
        }
        if(val < node.val) {
            //继续查询空位 如果查询到空位，要和父节点建立关系
            node.left = insert(node.left, val);
        } else if(node.val < val){
            node.right = insert(node.right, val);
        }
        return node;
    }

    //第二种方法:上限法
    //依次处理prevorder中每个值，返回创建好的节点或者null
//1.如果超过上限，返回null 作为孩子返回
//2.如果没超过上限，创建节点，并设置其左右孩子
//  左右孩子完整后返回
//    public TreeNode bstFromPreorder(int[] preorder) {
//        return insert(preorder, Integer.MAX_VALUE);
//    }
//
//    int i = 0;
//    private TreeNode insert(int[] preorder, int max) {
//        //递归结束条件
//        if (i == preorder.length) {
//            return null;
//        }
//        int val = preorder[i];
//        System.out.println(val + String.format("[%d]", max));
//        if (val > max) {
//            //如果超过上限，返回null 作为孩子返回
//            return null;
//        }
//        //如果没超过上限，创建节点，并设置其左右孩子
//        TreeNode node = new TreeNode(val);
//        i++;
//        node.left = insert(preorder, node.val);
//        node.right = insert(preorder, max);
//        return node;
//    }


    //第三种方法：**分治法**
    //分治法 8,5,1,7,10,12
//8根  左：5,1,7   右：10,12
//5根  左：1     右：7
//10根 左：null  右：12
    //我们如何去分治呢？首先我们找到的是 题目给出的是前序遍历出来的，那么我们只要找到比根节点大的数开始就可以区分左、右子树的范围
//    public TreeNode bstFromPreorder(int[] preorder) {
//        return partition(preorder, 0, preorder.length - 1);
//    }
//    //int start, int end 告诉处理范围
//    private TreeNode partition(int[] preorder, int start, int end) {
//        //结束条件
//        if (start > end) {
//            return null;
//        }
//        //获取根节点  创建根节点对象
//        TreeNode root = new TreeNode(preorder[start]);
//        //跳过根节点开始找左、右子树的范围
//        int index = start + 1;
//        //条件是一直找到区域的结束
//        while (index <= end) {
//            //区分左、右子树的范围
//            if (preorder[index] > preorder[start]) {
//                break;
//            }
//            index++;
//        }
//        //此时 index 就是左、右子树的分界线
//        root.left = partition(preorder, start + 1, index - 1);
//        root.right = partition(preorder, index, end);
//        return root;
//    }
}
