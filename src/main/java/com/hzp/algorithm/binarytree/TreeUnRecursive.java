package com.hzp.algorithm.binarytree;

import com.hzp.algorithm.stack.LinkedListStack;

import java.util.LinkedList;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.binarytree
 * @Author: ASUS
 * @CreateTime: 2023-10-03  10:28
 * @Description: TODO 二叉树深度优先遍历非递归实现
 * @Version: 1.0
 */
public class TreeUnRecursive {
    /**
     * <h3>前序遍历：对于每一棵子树，先访问该节点，然后是左子树，最后是右子树</h3>
     *
     */

    static void preOrder(){
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        LinkedListStack<TreeNode> stack = new LinkedListStack<>();
        TreeNode curr = root;

        //curr != null是为了限制去的路   !stack.isEmpty()是为了判断回的路
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);//记住回来的路，将之前路过的节点放入栈
                System.out.println(curr);
                curr = curr.left;
            } else {
                //往回走
                TreeNode pop = stack.pop();
                //回的时候看看当前节点右边有没有节点，有则记录右边节点
                curr = pop.right;
            }
        }
    }

    /**
     * <h3>中序遍历:对于每一棵子树，先访问左子树，然后是该节点，最后是右子树</h3>
     *
     */
    static void inOrder() {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        LinkedListStack<TreeNode> stack = new LinkedListStack<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.println(pop);
                curr = pop.right;
            }
        }

    }

    /**
     * <h3>后序遍历:对于每一棵子树，先访问左子树，然后是右子树，最后是该节点</h3>
     *
     */
    static void postOrder() {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        LinkedListStack<TreeNode> stack = new LinkedListStack<>();
        TreeNode curr = root;
        TreeNode pop = null;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                //首先拿到栈顶元素
                TreeNode peek = stack.peek();
                //确保左右子树都处理完成，再弹栈
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                    System.out.println(pop);
                } else {
                    curr = peek.right;
                }
            }
        }
    }
    /**
     * 下面是一种统一的写法，依据后序遍历修改
     *
     */
    static void CommonOrder() {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode curr = root; // 代表当前节点
        TreeNode pop = null; // 最近一次弹栈的元素
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                colorPrintln("前: " + curr.val, 31);
                stack.push(curr); // 压入栈，为了记住回来的路
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                // 右子树可以不处理, 对中序来说, 要在右子树处理之前打印
                if (peek.right == null) {
                    colorPrintln("中: " + peek.val, 36);
                    pop = stack.pop();
                    colorPrintln("后: " + pop.val, 34);
                }
                // 右子树处理完成, 对中序来说, 无需打印
                else if (peek.right == pop) {
                    pop = stack.pop();
                    colorPrintln("后: " + pop.val, 34);
                }
                // 右子树待处理, 对中序来说, 要在右子树处理之前打印
                else {
                    colorPrintln("中: " + peek.val, 36);
                    curr = peek.right;
                }
            }
        }
    }
    public static void colorPrintln(String origin, int color) {
        System.out.printf("\033[%dm%s\033[0m%n", color, origin);
    }

}
