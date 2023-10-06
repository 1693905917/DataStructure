package com.hzp.algorithm.binarysearchtree;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.binarysearchtree
 * @Author: ASUS
 * @CreateTime: 2023-10-06  09:30
 * @Description: TODO 二叉搜索树：以Object类型的key进行查询
 * @Version: 1.0
 */
//<T extends Comparable<T>>:将来我的泛型T就有个上限了，必须是Comparable的子类型，那么T就再也不是任意类型
public class BSTTree2<T extends Comparable<T>> {
    //定义根节点
    BSTNode<T> root;

    //定义节点
    static class BSTNode<T> {
        //随便给个泛型T就能参与大小比较吗？不能,所以我们要对T进行限制，让它能够参与大小比较，那么就需要实现一个接口： Comparable 接口
        T key; // 若希望任意类型作为 key, 则后续可以将其设计为 Comparable 接口
        Object value;
        BSTNode<T> left;
        BSTNode<T> right;

        public BSTNode(T key) {
            this.key = key;
            this.value = key;
        }

        public BSTNode(T key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(T key, Object value, BSTNode<T> left, BSTNode<T> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

//    public Object get(T key) {
//        return doGet(root, key);
//    }

    //注意：key.compareTo(p.key)的方法比较
    //-1： key p.key
    //0： key =p.key
    //1： key p.key
    //递归的实现
    private Object doGet(BSTNode<T> node, T key) {
        if (node == null) {
            return null;
        }
        int result = node.key.compareTo(key);
        if (result > 0) {
            return doGet(node.left, key);
        } else if (result < 0) {
            return doGet(node.right, key);
        } else {
            return node.value;
        }
    }
    //注意：key.compareTo(p.key)的方法比较
    //-1： key p.key
    //0： key =p.key
    //1： key p.key
    //非递归的实现
    public Object get(T key){
        BSTNode<T> p=root;
        while (p!=null){
            int result = key.compareTo(p.key);
            if(result<0){
                p=p.left;
            }else if(result>0){
                p=p.right;
            }else {
                return p.value;
            }
        }
        return null;
    }


}
