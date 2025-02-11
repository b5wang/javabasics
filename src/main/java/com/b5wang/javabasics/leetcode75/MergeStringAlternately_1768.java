package com.b5wang.javabasics.leetcode75;

import lombok.extern.slf4j.Slf4j;

class MergeStringAlternately_1768 {

    /**
     * Idea: double pointers
     * */
    private static void demoSubString(String str){
        int len = str.length();
        System.out.println("Str: " + str);
        System.out.println("Len: " + len);
        System.out.println("substring:");
        for(int i = 0; i < len; i++){
            System.out.println("" + i + ": " + str.substring(i,i+1));
        }
        System.out.println("charAt:");
        for(int i = 0; i < len; i++){
            System.out.println("" + i + ": " + str.charAt(i));
            System.out.println("" + (str.charAt(i) == '1'));
        }
    }

    private static String solution(String word1,String word2){
        if(word1.isEmpty() && word2.isEmpty()){
            return "";
        }

        if(word1.isEmpty()){
            return word2;
        }
        if(word2.isEmpty()){
            return word1;
        }

        StringBuilder sb = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int len = len1>len2?len1:len2;

        String c1 = null;
        String c2 = null;
        for(int i=0; i<len; i++){
            if(i < len1){
                c1 = word1.substring(i,i+1);
            }
            if(i < len2){
                c2 = word2.substring(i,i+1);
            }

            if(c1 != null){
                sb.append(c1);
                c1 = null;
            }
            if(c2 != null){
                sb.append(c2);
                c2 = null;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String word1 = "12345";
        String word2 = "ABCDEFGHIJK";

        // demoSubString(word1);

        System.out.println("Result: " + solution(word1,word2));
    }


}
