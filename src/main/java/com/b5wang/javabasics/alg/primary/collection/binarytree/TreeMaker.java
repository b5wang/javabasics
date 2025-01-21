package com.b5wang.javabasics.alg.primary.collection.binarytree;

public class TreeMaker {

    private static TreeNode[] getTreeNodes(int no){
        TreeNode[] nodes = new TreeNode[no];
        for(int i = 0; i < no; i++){
            nodes[i] = new TreeNode(i);
        }
        return nodes;
    }


    public static TreeNode tree1(){
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

    /**
     * Tree from
     * https://blog.csdn.net/lb812913059/article/details/83313360
     * */
    public static TreeNode tree2(){
        // root
        TreeNode root = new TreeNode(35);

        // level 1
        TreeNode node1 = new TreeNode(20);
        TreeNode node2 = new TreeNode(40);
        root.left = node1;
        root.right = node2;

        // level 2
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(29);
        TreeNode node5 = new TreeNode(50);
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        // level 3
        TreeNode node6 = new TreeNode(16);
        TreeNode node7 = new TreeNode(28);
        TreeNode node8 = new TreeNode(30);
        TreeNode node9 = new TreeNode(45);
        TreeNode node10 = new TreeNode(55);
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node5.left = node9;
        node5.right = node10;

        return root;
    }

}
