package com.b5wang.javabasics.java.oop.polymorphism.blueprint;

public abstract class AbstractTransportation implements Transportation {

    private String privateName;

    protected String protectedName;

    String packageName;

    public String publicName;

    public void commute(String departure, String arrival){
        System.out.println("Take " + getTransportationName() + ", from " + departure + " to " + arrival);
    }

}
