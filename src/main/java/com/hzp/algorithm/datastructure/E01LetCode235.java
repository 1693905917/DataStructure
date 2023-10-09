package com.hzp.algorithm.datastructure;

import com.hzp.algorithm.queue.TreeNode;

/**
 * @BelongsProject: arithmetic
 * @BelongsPackage: com.hzp.algorithm.datastructure
 * @Author: ASUS
 * @CreateTime: 2023-10-09  16:10
 * @Description: TODO 二叉搜索树的最近公共祖先
 * @Version: 1.0
 */
public class E01LetCode235 {
    /*
            __ 6 __
           /       \
          2         8
         / \       / \
        0   4     7   9
           / \
          3   5
          比如：2与8的祖先有：2、8、6  而6是公共祖先也是最近的
          4与5的祖先有：4、5、2、6  公共祖先有4 2 6   最近的祖先是4
          我们利用这个结论：待查找节点 p q 在某一节点的两侧，那么此节点就是最近的公共祖先
          举一个特殊案例：4与5的祖先有：4、5、2、6  公共祖先有4 2 6
          先判断6的两侧是不是4与5 如果不是 就进行下一个祖先两侧是否是4与5
          当然在这里，到后面判断4两侧是否是4与5的时候，我们也可以看作是在两侧
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        //ancestor.val > p.val && ancestor.val > q.val：p和q在当前节点的左边
        //ancestor.val < p.val && ancestor.val < q.val：p和q在当前节点的右边
        while (ancestor.val > p.val && ancestor.val > q.val ||
                ancestor.val < p.val && ancestor.val < q.val) {
            if (ancestor.val > p.val) {
                //这个时候祖先值要开始靠近p或者q
                ancestor = ancestor.left;
            } else {
                ancestor = ancestor.right;
            }
        }
        return ancestor;
    }
}
