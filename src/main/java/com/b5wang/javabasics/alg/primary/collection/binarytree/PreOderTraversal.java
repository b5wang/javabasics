package com.b5wang.javabasics.alg.primary.collection.binarytree;

import java.util.*;

/**
 * https://cloud.tencent.com/developer/article/1632481
 * */
class PreOderTraversal {

    /**
     * Pre-Order: Root node --> Left node --> Right node
     * */
    static void traverse(TreeNode root, List<Integer> values) {
        if(root == null) {
            return;
        }

        Deque<TreeNode> nodeStack = new LinkedList<>();
        nodeStack.push(root);
        TreeNode cur = null;

        while(!nodeStack.isEmpty()){
            cur = nodeStack.pop();

            values.add(cur.val);// Visit root

            if(cur.right != null){
                nodeStack.push(cur.right);// Push right node in stack
            }

            if(cur.left != null){
                nodeStack.push(cur.left);// Push left node in stack. LIFO, so access left child first
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
        traverse(root,values);
        RecursiveTraversal.preorderPrint(root);
        System.out.println("Values: " + Arrays.toString(values.toArray()));
    }

    static void sample2(){
        List<Integer> values = new LinkedList<>();
        TreeNode root = TreeMaker.tree2();
        traverse(root,values);
        RecursiveTraversal.preorderPrint(root);
        System.out.println("Values: " + Arrays.toString(values.toArray()));
    }

}
