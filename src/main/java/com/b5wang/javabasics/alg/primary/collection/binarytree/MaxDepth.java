package com.b5wang.javabasics.alg.primary.collection.binarytree;

import java.util.ArrayList;
import java.util.List;

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

    static int maxDepth2(TreeNode root){
        if(root == null){
            return 0;
        }
        int depth = 0;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        while(!nodes.isEmpty()){

            depth++;

            List<TreeNode> nextLevelNodes = new ArrayList<>();
            for (TreeNode node:nodes){
                if(node.left != null){
                    nextLevelNodes.add(node.left);
                }
                if(node.right != null){
                    nextLevelNodes.add(node.right);
                }
                nodes = nextLevelNodes;
            }
        }
        return depth;
    }

    public static void main(String[] args){
        TreeNode root = TreeMaker.tree1();
        System.out.println(maxDepth(root));

        System.out.println("Level: " + maxDepth2(root));
    }
}
