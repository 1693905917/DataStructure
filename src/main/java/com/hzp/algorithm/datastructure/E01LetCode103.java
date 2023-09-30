package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.queue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-09-29  10:55
 * @Description: TODO 二叉树 Z 字层序遍历
 * @Version: 1.0
 */
public class E01LetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true; //判断是奇数层还是偶数层 如果是偶数层，我们就从尾部开始添加,初始时都是从奇数层开始
        int c1 = 1; //当前节点数
        while (!queue.isEmpty()) {
            int c2 = 0;//下一层节点数
            LinkedList<Integer> deque = new LinkedList<>(); //保持每一次结果
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                if (leftToRight) { //判断是奇数层，则将节点从尾部开始添加
                    deque.offerLast(n.val);
                } else {
                    deque.offerFirst(n.val);
                }
                if (n.left != null) {
                    queue.offer(n.left);
                    c2++;
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    c2++;
                }
            }
            c1 = c2;
            leftToRight = !leftToRight;//奇数层变偶数层  偶数层变奇数层 为什么下一层做好准备
            result.add(deque);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );
        List<List<Integer>> lists = new E01LetCode103().zigzagLevelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
