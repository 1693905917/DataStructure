package com.hzp.algorithm.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    /**
     * <h3>查找关键字对应的值</h3>
     *
     * @param key 关键字
     * @return 关键字对应的值
     */
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

    /**
     * <h3>查找最小关键字对应值</h3>
     *
     * @return 关键字对应的值
     */
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


    /**
     * <h3>查找最大关键字对应值</h3>
     *
     * @return 关键字对应的值
     */
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
    /**
     * <h3>存储关键字和对应值</h3>
     *
     * @param key   关键字
     * @param value 值
     */
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

    /**
     * 查找关键字的前任值
     *
     * @param key 关键字
     * @return 前任值 比如：4的前任是3  7的前任是6
     */
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

    /**
     * <h3>查找关键字的后任值</h3>
     *
     * @param key 关键字
     * @return 后任值
     */
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


    /**
     * <h3>根据关键字删除</h3>
     *
     * @param key 关键字
     * @return 被删除关键字对应值
     */
    public Object delete(int key) {
        BSTNode p = root;
        BSTNode parent = null;//记录待删除节点的父亲
        while (p != null) {
            if (key < p.key) {
                parent = p;
                p = p.left;
            } else if (p.key < key) {
                parent = p;
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return null;
        }
        // 删除操作
        if (p.left == null) {
            shift(parent, p, p.right); // 情况1
        } else if (p.right == null) {
            shift(parent, p, p.left); // 情况2
        } else {
            // 情况4：被删除节点是左、右都有子节点，所以找后继节点：节点有右子树，此时后继节点即为右于树的最小值
            // 4.1 被删除节点找后继
            BSTNode s = p.right;//后继节点
            BSTNode sParent = p; // 后继父亲
            while (s.left != null) {  //当循环结束，后继节点即为s
                sParent = s;
                s = s.left;
            }
            // 4.2 删除和后继不相邻, 处理后继的后事
            if (sParent != p) {
                shift(sParent, s, s.right); // 不可能有左孩子：因为节点有右子树，此时后继节点即为右于树的最小值
                s.right = p.right;//顶上去的后继节点的右孩子==被删除节点的右孩子
            }
            // 4.3 后继取代被删除节点
            shift(parent, p, s);
            s.left = p.left;//shift方法只改变了父类节点的左右孩子的指向，而没有改变你后继节点的做左右孩子的指向
        }
        return p.value;
    }

    /**
     * 托孤方法
     *
     * @param parent  被删除节点的父亲
     * @param deleted 被删除节点
     * @param child   被顶上去的节点
     */
// 只考虑让 n1父亲的左或右孩子指向 n2, n1自己的左或右孩子并未在方法内改变
    private void shift(BSTNode parent, BSTNode deleted, BSTNode child) {
        //情况讨论：当被删除节点就是根节点，而根节点是没有父亲的
        if (parent == null) {
            root = child;//你们被删除节点的子节点就成根节点
        } else if (deleted == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }
    /**
     * <h3>根据关键字删除</h3>
     *
     * @param key 关键字
     * @return 被删除关键字对应值  是删除单个节点，当该节点被删除，则它的子节点将会与该节点的父类节点进行连接
     */

    public Object remove(int key) {
        ArrayList<Object> result = new ArrayList<>(); // 保存被删除节点的值
        root = doRemove(root, key, result);
        return result.isEmpty() ? null : result.get(0);
    }


        /*
              4
             / \
            2   6
           /     \
          1       7

        node 起点
        返回值 删剩下的孩子(找到) 或 null(没找到)
     */
    //递归实现删除操作  BSTNode node:我要删除时，从哪个节点开始删除  node是起点
    private BSTNode doRemove(BSTNode node, int key, ArrayList<Object> result) {
        //1.没有找到的情况：
        if (node == null) {
            return null;
        }
        //2.找到的情况：
        if (key < node.key) {//向左查找
            node.left = doRemove(node.left, key, result);
            return node;
        }
        if (node.key < key) {//向右查找
            node.right = doRemove(node.right, key, result);
            return node;
        }
        result.add(node.value);
        if (node.left == null) { // 情况1 - 只有右孩子
            return node.right;
        }
        if (node.right == null) { // 情况2 - 只有左孩子
            return node.left;
        }
        //s：后继节点
        BSTNode s = node.right; // 情况3 - 有两个孩子
        while (s.left != null) {
            s = s.left;
        }
        //while循环结束以后，找到了后继节点
        s.right = doRemove(node.right, s.key, new ArrayList<>());
        s.left = node.left;
        return s;
    }

    // 找 < key 的所有 value
    /*
             4
           /   \
          2     6
         / \   / \
        1   3 5   7
 */
//解题思路：我们利用中序遍历的特性：遍历出来的都是升序的结果
    public List<Object> less(int key) { //当我们输入的是6
        //result：将符合条件的加入到result中
        ArrayList<Object> result = new ArrayList<>();
        //中序遍历过程：
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode pop = stack.pop();
                if (pop.key < key) {
                    result.add(pop.value);
                } else {
                    //当我们遇到比key大的分支时，该分支的子分支就没必要多此一举的进行判断，直接跳出
                    //比如：当key=6，那么我们6右节点就不需要多此一举的去判断，而是直接跳出
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }

    //找 > key 的所有 value
    public List<Object> greater(int key) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        //RNL 遍历:得到的是降序的结果
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.right;
            } else {
                BSTNode pop = stack.pop();
                if (pop.key > key) {
                    result.add(pop.value);
                } else {
                    break;
                }
                p = pop.left;
            }
        }
        return result;
    }

    //找 >= key1 且 <= key2 的所有值
    public List<Object> between(int key1, int key2) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode pop = stack.pop();
                if (pop.key >= key1 && pop.key <= key2) {
                    result.add(pop.value);
                } else if (pop.key > key2) {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }



}
