package com.b5wang.javabasics.alg.primary.collection.binarytree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://cloud.tencent.com/developer/article/1632481
 * */
class InOrderTraversal {

    /**
     * In-Order: Left node --> Root node --> Right node
     *
     * */
    static void traverse(TreeNode root, List<Integer> values) {
        if(root == null){
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur.left);
                cur = cur.left;
            }

            cur = stack.pop();
            values.add(cur.val);

            cur = cur.right;
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
        RecursiveTraversal.inorderPrint(root);
        System.out.println("Values: " + Arrays.toString(values.toArray()));
    }

    static void sample2(){
        List<Integer> values = new LinkedList<>();
        TreeNode root = TreeMaker.tree2();
        traverse(root,values);
        RecursiveTraversal.inorderPrint(root);
        System.out.println("Values: " + Arrays.toString(values.toArray()));
    }
}
