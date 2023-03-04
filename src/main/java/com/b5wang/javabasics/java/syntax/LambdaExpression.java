package com.b5wang.javabasics.java.syntax;

import java.util.LinkedList;
import java.util.List;

class LambdaExpression {

    public static void main(String[] args){
        List<Integer> integerList = new LinkedList<>();
        for(int i = 0; i < 100; i++){
            integerList.add(i);
        }

        integerList.stream().filter(i->{
            // Predicate
            if(i%2==0){
                System.out.println("-" + i);
                return true;
            }else{
                return false;
            }
        }).map(i->{
            System.out.println("--" + i);
            return i+1;
        }).forEach(i->{
            System.out.println(i);
        });



        System.out.println("CPU: " + Runtime.getRuntime().availableProcessors());

//        long t1 = System.currentTimeMillis();
//        for(int i : integerList){
//        }
//        long t2 = System.currentTimeMillis();
//        integerList.parallelStream().forEach(i -> {
//        });
//        long t3 = System.currentTimeMillis();
//
//        System.out.println("--" + (t2-t1) + "--" + (t3-t2));
    }

}
