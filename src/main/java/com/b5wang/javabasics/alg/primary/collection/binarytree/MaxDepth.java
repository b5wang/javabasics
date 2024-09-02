package com.b5wang.javabasics.alg.primary.collection.binarytree;

/**
 * 用递归解决一些问题：
 * 比如二叉树的最大深度
 * */
class MaxDepth {

    static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;
        return (leftDepth > rightDepth) ? leftDepth : rightDepth;
    }

    public static void main(String[] args){
        TreeNode root = TreeMaker.exampel1();
        System.out.println(maxDepth(root));
    }
}
