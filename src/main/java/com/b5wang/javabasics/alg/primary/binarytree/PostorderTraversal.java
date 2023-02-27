package com.b5wang.javabasics.alg.primary.binarytree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class PostorderTraversal {

    static void traverse(TreeNode root, List<Integer> values) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode lastAccess = null;

        while(cur != null || !stack.isEmpty()){
            // Go to end of left nodes
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            // 剩下两种情况: 被访问或者右转
            if(!stack.isEmpty()){
                cur = stack.peek();// 取值不删除

                if(cur.right == null || cur.right == lastAccess){
                    /**
                     * 一个节点被访问有两个条件：
                     * 1. 左右节点为空（叶子），上面的步骤中已经隐含了左节点为空
                     * 2. 右节点已经被访问过
                     * */
                    values.add(cur.val);
                    lastAccess = cur;
                    cur = null;
                    stack.pop();
                }else{
                    // 右转
                    cur = cur.right;
                }
            }
        }
    }

    public static void main(String[] args){
        List<Integer> values = new LinkedList<>();
        TreeNode root = TreeMaker.exampel1();
        traverse(root,values);
        RecursiveTraversal.postorderPrint(root);
        System.out.println("Values: " + Arrays.toString(values.toArray()));
    }
}
