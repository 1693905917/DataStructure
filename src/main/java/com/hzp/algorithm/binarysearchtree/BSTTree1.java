package com.hzp.algorithm.binarysearchtree;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.binarysearchtree
 * @Author: ASUS
 * @CreateTime: 2023-10-05  23:06
 * @Description: TODO 二叉搜索树：以int类型的key进行查询
 * @Version: 1.0
 */
public class BSTTree1 {

    BSTNode root; // 根节点

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

    //解题思路：从根节点出发 比根节点大的向右找 比根节点小的向左找  如果相等则返回
//    public Object get(int key) {
//        return doGet(root, key);
//    }
    //查询方法：递归实现
    private Object doGet(BSTNode node, int key) {
        if (node == null) {
            return null; // 没找到
        }
        if (key < node.key) {
            return doGet(node.left, key); // 向左找
        } else if (node.key < key) {
            return doGet(node.right, key); // 向右找
        } else {
            return node.value; // 找到了
        }
    }

    //查询方法：非递归实现

    public Object get(int key) {
        BSTNode node = root;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (node.key < key) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    //思路：从根节点开始，一直往左走，一直走到最后的节点没有左孩子就停止
//    public Object min() {
//        return doMin(root);
//    }

    //递归实现
    public Object doMin(BSTNode node) {
        if (node == null) {//当给的节点为Null 我们就不需要去找
            return null;
        }
        // 左边已走到头
        if (node.left == null) { //最小的节点
            return node.value;
        }
        return doMin(node.left);
    }
    //非递归实现
    public Object min() {
        return min(root);
//        if (root == null) {
//            return null;
//        }
//        BSTNode p = root;
//        // 左边未走到头
//        while (p.left != null) {
//            p = p.left;
//        }
//        return p.value;
    }

    private Object min(BSTNode node){
        if (node == null) {
            return null;
        }
        BSTNode p = node;
        // 左边未走到头
        while (p.left != null) {
            p = p.left;
        }
        return p.value;
    }


//    public Object max() {
//        return doMax(root);
//    }
    //递归实现
    public Object doMax(BSTNode node) {
        if (node == null) {
            return null;
        }
        // 右边已走到头
        if (node.left == null) {
            return node.value;
        }
        return doMin(node.right);
    }
    //非递归实现  针对于root的max方法
    public Object max() {
     return   max(root);
//        if (root == null) {
//            return null;
//        }
//        BSTNode p = root;
//        // 右边未走到头
//        while (p.right != null) {
//            p = p.right;
//        }
//        return p.value;
    }


    //通用的Max方法
    private Object max(BSTNode node){
        if (node == null) {
            return null;
        }
        BSTNode p = node;
        // 右边未走到头
        while (p.right != null) {
            p = p.right;
        }
        return p.value;
    }

    //1.key在该二叉树中有 那就更新key所对应的value值
    //2.key在该二叉树中没有 那就新增key与所对应的value值
    public void put(int key, Object value) {
        BSTNode node = root;
        BSTNode parent = null;
        while (node != null) {
            parent = node;// 4 7 8
            if (key < node.key) {
                node = node.left;
            } else if (node.key < key) {
                node = node.right;//4->7 7->8 8->null
            } else {
                // 1. key 存在则更新
                node.value = value;
                return;
            }
        }
        // 2. key 不存在则新增
        if (parent == null) {
            //当我二叉树是null，那么parent初始就是Null 那么新增的key就是根节点
            root = new BSTNode(key, value);
        } else if (key < parent.key) {
            parent.left = new BSTNode(key, value);
        } else {
            parent.right = new BSTNode(key, value);
        }
    }

    public Object predecessor(int key) {
        BSTNode ancestorFromLeft = null;
        BSTNode p = root;
        //查找用户给的Key在二叉树中是否有
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (p.key < key) {
                ancestorFromLeft = p;
                p = p.right;
            } else {
                break;
            }
        }
        //key没找到，说明也就没有前任节点
        if (p == null) {
            return null;
        }
        // 情况1 - 有左孩子
        if (p.left != null) {
            return max(p.left);
        }
        // 情况2 - 有祖先自左而来
        //对于情况2，我们如何知道哪些节点是要找节点的祖先，又是如何知道这些祖先节点哪些是自从左而来的呢？
        //以5节点为例，那我要找到5这个节点的过程中，它必然已经经历过一些节点了，从根节点4开始找，5比4大就向右找，7比5大就向左找，6比5大就像左找，找到了
        //在从根节点开始4 7 6是不是都是5的祖先？是的  其实循环的每步都是在经历他这些祖先节点，好，现在知道怎么去获取祖先节点。
        //那我们怎么去进一步判断 它这个祖先是左边来还是从右边来呢？
        //答：你看4到7是不是向右走，那么以5为参考点，那么4是不是在左边？那么7到6、6到5都是向左走，但是以5为参考点，那么7到6、6到5都是向右走
        //所以只要我们看到这种向右走的代码if (p.key < key) {p = p.right;}那就表示祖先是自左而来
        //而且我们每次循环更新都是最新也就是最近的自左而来的祖先节点

        return ancestorFromLeft != null ? ancestorFromLeft.value : null;
    }


    public Object successor(int key) {
        BSTNode ancestorFromRight = null;
        BSTNode p = root;
        while (p != null) {
            if (key < p.key) {
                ancestorFromRight = p;
                p = p.left;
            } else if (p.key < key) {
                p = p.right;
            } else {
                break;
            }
        }

        if (p == null) {
            return null;
        }
        // 情况1 - 有右孩子
        if (p.right != null) {
            return min(p.right);
        }
        // 情况2 - 有祖先自右而来
        return ancestorFromRight != null ? ancestorFromRight.value : null;
    }




}