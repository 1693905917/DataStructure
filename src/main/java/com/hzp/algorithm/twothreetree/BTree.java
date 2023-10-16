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

//孩子数:	   下限：    ceil(m/2)     ~    上限：m
//关键字数n: 下限：	ceil(m/2)-1  ~    上限：m-1
//**度	degree	指树中节点孩子数**
//**阶	order	   指所有节点孩子数最大值**
public class BTree {
    static class Node {
        boolean leaf = true; //是否是叶子节点 默认刚刚开始是叶子节点
        int keyNumber;//有效关键字的个数
        int t; //最小度数：最少有几个孩子  度数决定了未来树的高度  度数越大，高度越小
        int[] keys; //关键字  由于一个节点的关键字可能有多个所以用数组来表示
        Node[] children;//一个节点的子节点也有可能是多个

        public Node(int t) { //注意：度数要>=2
            this.t = t;
            this.keys = new int[2 * t - 1];//比孩子数少1
            this.children = new Node[2 * t];//最多的孩子数
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys, 0, keyNumber));
        }

        //多路查找
        Node get(int key) {
            int i = 0;//索引值
            while (i < keyNumber && keys[i] < key) { //由于B-树特性：是属于升序的key
                if (i < keyNumber && keys[i] == key) { //找到
                    return this;
                }
                if(keys[i]>key){ //在该节点没有找到
                    break;
                }
                i++;
            }

            //执行到此时keys[i]>key或i==keyNumber
            if (leaf) { //到达叶子节点时就没找到
                return null;
            }
            return children[i].get(key);
        }
    }
}
