package com.b5wang.javabasics.alg.primary.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class LevelOrderTraversal {

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

    public static void main(String[] args){
        TreeNode root = TreeMaker.exampel1();
        traverse(root);
    }
}
