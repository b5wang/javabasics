package com.b5wang.javabasics.alg.primary.collection.binarytree;

import java.util.*;

class LevelTraversal {

    static void traverse(TreeNode root){
        List<TreeNode> nodeList = new ArrayList<>();
        TreeNode cur = root;
        nodeList.add(cur);

        while(nodeList.size() > 0){
            List<TreeNode> newNodeList = new ArrayList<>();
            int size = nodeList.size();
            for(int i = 0; i < size; i++){
                TreeNode n = nodeList.get(i);

                System.out.print(n.val);
                if(i < size - 1){
                    System.out.print(",");
                }

                if(n.left != null){
                    newNodeList.add(n.left);
                }
                if(n.right != null){
                    newNodeList.add(n.right);
                }
            }
            System.out.println();
            nodeList = newNodeList;
        }
    }

    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> values = new ArrayList<>();
        List<Integer> levelNodes = null;

        List<TreeNode> nodeList = new ArrayList<>();
        TreeNode cur = root;
        nodeList.add(cur);

        while(nodeList.size() > 0){
            List<TreeNode> newNodeList = new ArrayList<>();
            levelNodes = new ArrayList<>();

            int size = nodeList.size();
            for(int i = 0; i < size; i++){
                TreeNode n = nodeList.get(i);
                levelNodes.add(n.val);
                if(n.left != null){
                    newNodeList.add(n.left);
                }
                if(n.right != null){
                    newNodeList.add(n.right);
                }
            }

            values.add(levelNodes);
            nodeList = newNodeList;
        }

        return values;
    }

    static void levelTraverse(TreeNode root, List<Integer> values){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();// FIFO
        queue.add(root);
        TreeNode cur = null;

        while(!queue.isEmpty()){
            cur = queue.poll();
            values.add(cur.val);

            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    public static void main(String[] args){
        sample1();
        sample2();
    }

    static void sample1(){
        TreeNode root = TreeMaker.tree1();
        traverse(root);
    }

    static void sample2(){
        List<Integer> values = new LinkedList<>();
        TreeNode root = TreeMaker.tree1();
        levelTraverse(root,values);
        System.out.println("Values: " + Arrays.toString(values.toArray()));
    }
}
