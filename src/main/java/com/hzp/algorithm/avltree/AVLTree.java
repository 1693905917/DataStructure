package com.hzp.algorithm.avltree;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.avltree
 * @Author: ASUS
 * @CreateTime: 2023-10-10  23:22
 * @Description: TODO AVL
 * @Version: 1.0
 */
public class AVLTree {

    //处理高度

    static class AVLNode {
        int height = 1;  //高度  初始化高度为1
        int key;
        Object value;
        AVLNode left;
        AVLNode right;
        // ...


        public AVLNode(int key) {
            this.key = key;
        }

        public AVLNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }
    }


    //**求高度代码**
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }


    //更新高度（在新增、删除、旋转的时候需要更新高度）
    private void updateHeight(AVLNode node) {
        node.height = Integer.max(height(node.left), height(node.right)) + 1;
    }

    //获取平衡因子
    private int bf(AVLNode node) {
        return height(node.left) - height(node.right);
    }

    //解决失衡:基础操作：
    //1.**右旋**
    //参数：要旋转的节点 也就是失衡节点
    private AVLNode rightRotate(AVLNode red) {
        //黄色节点，旧根的左孩子
        AVLNode yellow = red.left;
        //绿色节点：当黄色节点有右孩子不是null，则要执行下面的red.left = green;  如果黄色节点有右孩子是null，就不需要执行red.left = green;
        //但是如果黄色节点有右孩子是null 执行red.left = green; 指向Null也没事
        AVLNode green = yellow.right;
        yellow.right = red;
        red.left = green;
        //做完失衡调整以后 记得要做更新高度操作 更新高度的操作不能改变
        updateHeight(red);
        updateHeight(yellow);
        return yellow;
    }
    //2.**左旋**
    //参数：要旋转的节点 也就是失衡节点
    private AVLNode leftRotate(AVLNode red) {
        AVLNode yellow = red.right;
        AVLNode green = yellow.left;
        yellow.left = red;
        red.right = green;
        //做完失衡调整以后 记得要做更新高度操作 更新高度的操作不能改变
        updateHeight(yellow);
        updateHeight(red);
        return yellow;
    }

    //**左右旋**
    private AVLNode leftRightRotate(AVLNode root) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }

    //**右左旋**
    private AVLNode rightLeftRotate(AVLNode root) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }

    //检查节点是否失衡，重新平衡代码
    private AVLNode balance(AVLNode node) {
        if (node == null) {
            return null;
        }
        int bf = bf(node);

        if (bf > 1 && bf(node.left) >= 0) { //LL
            return rightRotate(node);
        } else if (bf > 1 && bf(node.left) < 0) { //LR
            return rightLeftRotate(node);
        } else if (bf < -1 && bf(node.right) > 0) { //RL
            return leftRightRotate(node);
        } else if (bf < -1 && bf(node.right) <= 0) {//RR
            return rightRotate(node);
        }
        return node;
    }


}
