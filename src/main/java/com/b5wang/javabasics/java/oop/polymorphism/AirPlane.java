package com.b5wang.javabasics.java.oop.polymorphism;

import com.b5wang.javabasics.java.oop.polymorphism.blueprint.AbstractTransportation;

public class AirPlane extends AbstractTransportation {
    @Override
    public String getTransportationName() {
        return "Airplane";
    }

    public void commute(String departure, String arrival){
        System.out.println("Go to airport");
        super.commute(departure,arrival);
    }
}
