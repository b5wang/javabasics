package com.b5wang.javabasics.java.syntax;

import java.util.LinkedList;
import java.util.List;

class LambdaExpression {

    public static void main(String[] args){
        List<Integer> integerList = new LinkedList<>();
        for(int i = 0; i < 9000000; i++){
            integerList.add(i);
        }
//        integerList.stream().forEach(i -> {
//            System.out.print(i);
//            System.out.print(" ");
//        });

        long t1 = System.currentTimeMillis();
        for(int i : integerList){
        }
        long t2 = System.currentTimeMillis();
        integerList.parallelStream().forEach(i -> {
        });
        long t3 = System.currentTimeMillis();

        System.out.println("--" + (t2-t1) + "--" + (t3-t2));
    }

}
