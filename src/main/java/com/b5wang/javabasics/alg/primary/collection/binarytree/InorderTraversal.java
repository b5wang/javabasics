package com.b5wang.javabasics.alg.primary.collection.binarytree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 中序遍历，一路向左，闷到头！
 * 再右转！
 *
 * */
class InorderTraversal {

    static void traverse(TreeNode root, List<Integer> values) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            if(!stack.isEmpty()){
                cur = stack.pop();

                // Access node
                values.add(cur.val);

                // 1. 叶子节点有可能为空，下次循环继续从栈中取节点
                // 2. 不是叶子节点，右节点不为空，下次循环拐去右侧
                cur = cur.right;
            }

        }
    }

    public static void main(String[] args){
        List<Integer> values = new LinkedList<>();
        TreeNode root = TreeMaker.exampel1();
        traverse(root,values);
        RecursiveTraversal.inorderPrint(root);
        System.out.println("Values: " + Arrays.toString(values.toArray()));
    }

}
