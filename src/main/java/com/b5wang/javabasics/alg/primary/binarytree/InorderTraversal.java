package com.b5wang.javabasics.alg.primary.binarytree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 中序遍历，一路向左，闷到头！
 * 再右转！
 *
 * */
public class InorderTraversal {

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

                // 被访问节点的左节点，要嘛为空，要嘛已经被访问过
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
