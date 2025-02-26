package com.b5wang.javabasics.java.oop.polymorphism;

import com.b5wang.javabasics.java.oop.polymorphism.blueprint.AbstractTransportation;
import com.b5wang.javabasics.java.oop.polymorphism.blueprint.Transportation;

class Car extends AbstractTransportation {

    @Override
    public String getTransportationName() {
        protectedName = "Car";
        publicName = "Car";
        return "Car";
    }

    public static void main(String[] args) {
        Transportation t1 = new Car();
        t1.commute("Singapore","USA");

        Transportation t2 = new AirPlane();
        t2.commute("Singapore","USA");
    }
}
