package com.hzp.algorithm.twothreetree;

import java.util.Arrays;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.twothreetree
 * @Author: ASUS
 * @CreateTime: 2023-10-14  16:52
 * @Description: TODO
 * @Version: 1.0
 */
public class BTree {
    static class Node {
        boolean leaf = true;
        int keyNumber;
        int t;
        int[] keys;
        Node[] children;

        public Node(int t) {
            this.t = t;
            this.keys = new int[2 * t - 1];
            this.children = new Node[2 * t];
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys, 0, keyNumber));
        }
    }
}
