package com.b5wang.javabasics.java.datatype;

public class ImmutableString {

    public static void main(String[] args) {
        String s1 = "Hello!";
        String s2 = new String("Hello!");
        String s3 = "Hel" + "lo!";
        String s4 = "Hel";
        String s5 = "lo!";
        String s6 = s4 + s5;

        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1 == s3: " + (s1 == s3));
        System.out.println("s1 == s6: " + (s1 == s6));

    }

}
