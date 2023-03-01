package com.b5wang.javabasics.java.syntax;

class ReturnAndFinal {

    static String whatReturn(String name){
        try{
            return "Hello, " + name + "!";
        }finally {
            return "Good morning, " + name + "!";
        }
    }

    static String whatReturn2(int i) throws Exception{
        try{
            if(i == 0){
                // normal
            }else{
                throw new Exception("i != 0!");
            }
            System.out.println("Before return 1!");
            return "Successfully!";
        }catch (Exception ex){
            System.out.println("Get an exception!");
            throw ex;
        }finally {
            return "Still ok!";
        }
    }


    public static void main(String[] args) throws Exception {
        System.out.println(whatReturn("Tom"));

        System.out.println(whatReturn2(0));
    }

}
