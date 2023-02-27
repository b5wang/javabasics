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
        TreeNode cur = root;
        stack.push(root);

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                values.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                cur = cur.right;
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
