package com.b5wang.javabasics.alg.primary.datatype.string;

import java.util.Arrays;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnhbqj/
 *
 * Reverse the string, for example, "hello" -> "olleh"
 * Space complexity O(1).
 * */
public class ReverseString {

    /**
     * First idea: double pointers
     * */
    public void reverseString(char[] s) {
        int len = s.length;
        int p = 0, q = len - 1;

        char c;
        while(p < q){
            c = s[p];
            s[p] = s[q];
            s[q] = c;

            p++;
            q--;
        }
    }


    public static void main(String[] args){
        String str = "hello";

        char[] s = str.toCharArray();
        System.out.println(Arrays.toString(s));

        ReverseString opt = new ReverseString();
        opt.reverseString(s);
        System.out.println(Arrays.toString(s));
    }

}
