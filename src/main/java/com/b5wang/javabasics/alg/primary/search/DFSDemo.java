package com.b5wang.javabasics.alg.primary.search;

import com.b5wang.javabasics.alg.primary.collection.binarytree.TreeMaker;
import com.b5wang.javabasics.alg.primary.collection.binarytree.TreeNode;

import java.util.Stack;

public class DFSDemo {

    public static void main(String[] args) {
        TreeNode root = TreeMaker.exampel1();


    }

    static void dfs(TreeNode root){
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        TreeNode node;
        while((node = nodeStack.peek()) != null){
            //if(node.left)
        }
    }

}
