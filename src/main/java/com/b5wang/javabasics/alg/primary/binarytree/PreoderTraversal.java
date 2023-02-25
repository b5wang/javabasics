package com.b5wang.javabasics.alg.primary.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 要做一个算法，需要思考的几个要点：
 * - 绝大部分是循环的逻辑
 * - 终止条件
 * - 每次循环的动作
 *
 * */
class PreoderTraversal {

    static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> histNodes = new Stack<>();

        TreeNode cur = root;
        while(cur != null){
            values.add(cur.val);

            if(cur.left != null){
                histNodes.push(cur);
                cur = cur.left;
            }else if(cur.right != null){
                cur = cur.right;
            }else{
                cur = histNodes.pop();
            }
        }

        return values;
    }


    public static void main(String[] args){
        TreeNode root = TreeMaker.exampel1();
        List values = preorderTraversal(root);

        System.out.println("Values: " + Arrays.toString(values.toArray()));
    }

}
