package com.b5wang.javabasics.alg.primary.binarytree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class PostorderTraversal {

    static void traverse(TreeNode root, List<Integer> values) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            if(!stack.isEmpty()){
                cur = stack.peek();
                // 右转
                cur = cur.right;
            }

        }
    }

    public static void main(String[] args){
        List<Integer> values = new LinkedList<>();
        TreeNode root = TreeMaker.exampel1();
        traverse(root,values);
        RecursiveTraversal.inorderPrint(root);
        System.out.println("Values: " + Arrays.toString(values.toArray()));
    }
}
