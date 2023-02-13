package com.b5wang.javabasics.designpattern.proxy;

public class EnglishGreetings implements Greetings{
    @Override
    public String hello(String people) {
        return "Hello " + people + "!";
    }

    @Override
    public String goodMorning(String people) {
        return "Good morning " + people + "!";
    }
}
