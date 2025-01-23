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
     * In-Order: Left child --> root --> right child
     * */
    static void traverse(TreeNode root, List<Integer> values) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;// Record visited node or right child

        /**
         * 1. cur is always treated as root node
         * */
        while(!stack.isEmpty() || cur != null){
            /**
             * 2. Access lift sub-tree first, till the most left node
             * */
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            /**
             * 3. Visit the most left node
             * */
            cur = stack.pop();
            values.add(cur.val);

            /**
             * 4. Access right sub-tree (root node of right sub-tree)
             * */
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
