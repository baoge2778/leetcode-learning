package com.company;

/**
 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。

 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 */
public class Solution_701 {

    public static void main(String[] args) {
	// write your code here
//        System.out.println(PredictTheWinner(""));
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        recursive(root, val);
        return root;
    }

    void recursive(TreeNode root, int val){
        if(root.val>val) {
            if(root.left == null) {
                root.left = new TreeNode(val);
                return;
            }
            recursive(root.left, val);
        }else{
            if(root.right == null) {
                root.right = new TreeNode(val);
                return;
            }
            recursive(root.right, val);
        }

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
