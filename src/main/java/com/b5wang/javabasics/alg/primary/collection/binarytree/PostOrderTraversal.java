package com.b5wang.javabasics.alg.primary.collection.binarytree;

import java.util.*;

/**
 * https://cloud.tencent.com/developer/article/1632481
 * */
class PostOrderTraversal {

    /**
     * Idea A
     * */
    static void traverse1(TreeNode root, List<Integer> values) {
        if(root == null){
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode lastAccess = null;

        while(!stack.isEmpty() || cur != null){
            /**
             * 1. Go to end of left nodes
             * */
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            if(!stack.isEmpty()){
                cur = stack.peek();// 取值不删除

                if(cur.right == null || cur.right == lastAccess){
                    /**
                     * 2. 一个节点被访问有两个条件：
                     * (1) 左右节点为空（叶子），上面的步骤中已经隐含了左节点为空
                     * or
                     * (2) 右节点已经被访问过
                     * */
                    stack.pop();
                    values.add(cur.val);
                    lastAccess = cur;
                    cur = null;
                }else{
                    // 3. Go to right sub-tree
                    cur = cur.right;
                }
            }
        }
    }

    /**
     * Idea B
     * Like Pre-Order
     * */
    static void traverse2(TreeNode root, List<Integer> values) {
        if(root == null){
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode cur = null;
        TreeNode lastAccess = null;

        while(!stack.isEmpty()){
            cur = stack.peek();

            if((cur.left == null && cur.right == null) || cur.right == lastAccess){
                values.add(cur.val);
                stack.pop();
                lastAccess = cur;
            }else{
                if(cur.right != null){
                    stack.push(cur.right);
                }
                if(cur.left != null){
                    stack.push(cur.left);
                }
            }
        }
    }

    public static void main(String[] args){
        sample1();
    }

    static void sample1(){
        List<Integer> values = new LinkedList<>();
        TreeNode root = TreeMaker.tree1();
        //traverse1(root,values);
        traverse2(root,values);
        RecursiveTraversal.postorderPrint(root);
        System.out.println("Values: " + Arrays.toString(values.toArray()));
    }
}
