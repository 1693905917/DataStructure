package com.hzp.algorithm.binarysearchtree;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.binarysearchtree
 * @Author: ASUS
 * @CreateTime: 2023-10-05  23:06
 * @Description: TODO
 * @Version: 1.0
 */
public class BSTTree1 {
    //定义节点
    static class BSTNode {
        int key; // 若希望任意类型作为 key, 则后续可以将其设计为 Comparable 接口
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key) {
            this.key = key;
            this.value = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
