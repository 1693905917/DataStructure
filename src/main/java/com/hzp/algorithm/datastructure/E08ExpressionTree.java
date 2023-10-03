package com.hzp.algorithm.datastructure;

import java.util.LinkedList;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-03  16:18
 * @Description: TODO 后缀表达式转二叉树
 * @Version: 1.0
 */
public class E08ExpressionTree {
    static class TreeNode {
        public String val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(String val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, String val, TreeNode right) {
            this.left = left;
            this.val = val;
            this.right = right;
        }

        @Override
        public String toString() {
            return this.val;
        }
    }

    /*
        中缀表达式           (2-1)*3
        后缀（逆波兰）表达式   21-3*

        1.遇到数字入栈
        2.遇到运算符, 出栈两次（先出战的放入right中,后出战的放入left中）, 然后将运算符放入栈中，再进行第一步操作

        栈
        |   |
        |   |
        |   |
        _____

        '-'.right = 1
        '-'.left  = 2

        '*'.right = 3
        '*'.left  = -

        表达式树
            *
           / \
          -   3
         / \
        2   1

        21-3*
     */
    public TreeNode constructExpressionTree(String[] tokens) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        for (String t : tokens) {
            switch (t) {
                case "+":// 运算符
                case "-":
                case "*":
                case "/":
                    //遇到运算符, 出栈两次
                    TreeNode right = stack.pop();
                    TreeNode left = stack.pop();
                    //然后将运算符放入栈中
                    TreeNode parent = new TreeNode(t);
                    //先出战的放入right中,后出战的放入left中
                    parent.left = left;
                    parent.right = right;
                    stack.push(parent);
                    break;
                default :// 数字
                    //1.遇到数字入栈
                    stack.push(new TreeNode(t));
                    break;
                }
            }
        return stack.peek();
        }
}
