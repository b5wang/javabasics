package com.b5wang.javabasics.alg.primary.binarytree;

import java.util.*;

/**
 * 要做一个算法，需要思考的几个要点：
 * - 绝大部分是循环的逻辑
 * - 终止条件
 * - 每次循环的动作
 *
 * */
class PreoderTraversal {

    static void traverse(TreeNode root, List<Integer> values) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();

            values.add(cur.val);

            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }


    public static void main(String[] args){
        List<Integer> values = new LinkedList<>();
        TreeNode root = TreeMaker.exampel1();
        traverse(root,values);
        RecursiveTraversal.preorderPrint(root);
        System.out.println("Values: " + Arrays.toString(values.toArray()));
    }

}