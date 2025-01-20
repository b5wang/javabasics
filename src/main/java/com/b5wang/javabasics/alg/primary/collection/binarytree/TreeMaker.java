package com.b5wang.javabasics.alg.primary.collection.binarytree;

public class TreeMaker {

    private static TreeNode[] getTreeNodes(int no){
        TreeNode[] nodes = new TreeNode[no];
        for(int i = 0; i < no; i++){
            nodes[i] = new TreeNode(i);
        }
        return nodes;
    }


    public static TreeNode exampel1(){
        TreeNode[] nodes = getTreeNodes(7);
        TreeNode root = nodes[0];

        // level 1
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        // level 2
        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];

        nodes[2].right = nodes[5];

        // level 3
        nodes[4].right = nodes[6];

        return root;
    }

}
