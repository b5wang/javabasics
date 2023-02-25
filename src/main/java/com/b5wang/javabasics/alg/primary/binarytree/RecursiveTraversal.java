package com.b5wang.javabasics.alg.primary.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class RecursiveTraversal {

    static void preorderPrint(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.val);
        preorderPrint(node.left);
        preorderPrint(node.right);
    }

    static void inorderPrint(TreeNode node){
        if(node == null){
            return;
        }
        inorderPrint(node.left);
        System.out.println(node.val);
        inorderPrint(node.right);
    }

    static void postorderPrint(TreeNode node){
        if(node == null){
            return;
        }
        postorderPrint(node.left);
        postorderPrint(node.right);
        System.out.println(node.val);
    }

    static void preorder(TreeNode node, List<Integer> values){
        if(node == null){
            return;
        }
        values.add(node.val);
        preorder(node.left,values);
        preorder(node.right,values);
    }

    static void inorder(TreeNode node, List<Integer> values){
        if(node == null){
            return;
        }
        inorder(node.left,values);
        values.add(node.val);
        inorder(node.right,values);
    }

    static void postorder(TreeNode node, List<Integer> values){
        if(node == null){
            return;
        }
        postorder(node.left,values);
        postorder(node.right,values);
        values.add(node.val);
    }

    public static void main(String[] args){
        TreeNode root = TreeMaker.exampel1();

        System.out.println("--- preoder traversal");
        preorderPrint(root);
        System.out.println("--- inoder traversal");
        inorderPrint(root);
        System.out.println("--- postoder traversal");
        postorderPrint(root);

        System.out.println();

        System.out.println("--- preoder traversal");
        List<Integer> values = new LinkedList<>();
        preorder(root,values);
        System.out.println(Arrays.toString(values.toArray()));
        System.out.println("--- inoder traversal");
        values.clear();
        inorder(root,values);
        System.out.println(Arrays.toString(values.toArray()));
        System.out.println("--- postoder traversal");
        values.clear();
        postorder(root,values);
        System.out.println(Arrays.toString(values.toArray()));
    }
}
