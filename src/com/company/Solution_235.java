package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *示例 1:
 *输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 *输出: 6
 *解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 *示例 2:
 *输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 *输出: 2
 *解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * 
 *说明:
 *所有节点的值都是唯一的。
 *p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 */
public class Solution_235 {

    List<List<Integer>> list = new ArrayList<>();
    Stack stack = new Stack();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        loop(root,  p,  q);
        int length = 0;
        if(list.get(0).size() > list.get(1).size()){
            length = list.get(1).size();
        }else{
            length = list.get(0).size();
        }
        int gt=0;
        for (int i = 0; i < length; i++) {
            if(list.get(0).get(i) == list.get(1).get(i)) {
                gt=list.get(0).get(i);
            }
        }
        return new TreeNode(gt);
    }

    void loop(TreeNode node, TreeNode p, TreeNode q){
        stack.push(node.val);
        if(node.val == p.val || node.val == q.val) {
            List<Integer> integerList = new ArrayList<>();
            integerList.addAll(stack);
            list.add(integerList);
            System.out.println(list);
        }
        if(node.left!=null) {
            loop(node.left,  p,  q);
        }
        if(node.right!=null) {
            loop(node.right,  p,  q);
        }
        stack.pop();

    }
}

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
