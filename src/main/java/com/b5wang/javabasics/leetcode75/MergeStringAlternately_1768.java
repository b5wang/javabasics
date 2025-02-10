package com.b5wang.javabasics.leetcode75;

public class MergeStringAlternately_1768 {

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
        int len = word1.length();
        for(int i=0; i<len; i++){
            String c1 = 
        }

        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
