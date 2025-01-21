package com.b5wang.javabasics.alg.primary.collection.binarytree;

import java.util.*;

/**
 * https://cloud.tencent.com/developer/article/1632481
 * */
class PreOderTraversal {

    /**
     * [2025-01-20] This method seems wrong, I am wrong!!!
     * */
    @Deprecated
    static void traverse(TreeNode root, List<Integer> values) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        stack.push(root);

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                values.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }

    /**
     * 从一个3节点的完全二叉树来思考
     * */
    static void traverse2(TreeNode root, List<Integer> values) {
        Deque<TreeNode> nodeStack = new LinkedList<>();
        nodeStack.push(root);
        TreeNode cur = null;

        while(!nodeStack.isEmpty()){
            cur = nodeStack.pop();

            values.add(cur.val);// Visit

            if(cur.right != null){
                nodeStack.push(cur.right);
            }
            if(cur.left != null){
                nodeStack.push(cur.left);
            }
        }
    }


    public static void main(String[] args){
        sample1();
        sample2();
    }

    static void sample1(){
        List<Integer> values = new LinkedList<>();
        TreeNode root = TreeMaker.tree1();
        traverse2(root,values);
        RecursiveTraversal.preorderPrint(root);
        System.out.println("Values: " + Arrays.toString(values.toArray()));
    }

    static void sample2(){
        List<Integer> values = new LinkedList<>();
        TreeNode root = TreeMaker.tree2();
        traverse2(root,values);
        RecursiveTraversal.preorderPrint(root);
        System.out.println("Values: " + Arrays.toString(values.toArray()));
    }

}
