package com.b5wang.javabasics.alg.primary.collection.binarytree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://cloud.tencent.com/developer/article/1632481
 * */
class InOrderTraversal {

    static void traverse(TreeNode root, List<Integer> values) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode cur = null;

        while(!stack.isEmpty()){
            cur = stack.pop();

            if(cur.right != null){
                stack.push(cur.right);
            }

            values.add(cur.val);

            if(cur.left != null){
                stack.push(cur.left);
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
