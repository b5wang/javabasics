package com.b5wang.javabasics.alg.primary.collection;


import java.time.LocalDate;
import java.time.Month;

public class DemoHashCode {

    public static void main(String[] args) {
        int id = 1;
        String name = "Tommy";
        LocalDate birthday = LocalDate.of(1994, Month.AUGUST,9);

        // Intellij generated hash code
        DemoIntellijGenHashCode intellijGenHashCode = new DemoIntellijGenHashCode(id,name,birthday);

        // Common lang hash code
        DemoCLHashCode demoCLHashCode = new DemoCLHashCode(id,name,birthday);
        // Common lang 3
        DemoCL3HashCode demoCL3HashCode = new DemoCL3HashCode(id,name,birthday);
        // Lombok
        DemoLombokHashCode demoLombokHashCode = new DemoLombokHashCode(id,name,birthday);
        // Guava
        DemoGuavaHashCode demoGuavaHashCode = new DemoGuavaHashCode(id,name,birthday);

        System.out.println("intellijGenHashCode = " + intellijGenHashCode.hashCode());
        System.out.println("demoCLHashCode      = " + demoCLHashCode.hashCode());
        System.out.println("demoCL3HashCode     = " + demoCL3HashCode.hashCode());
        System.out.println("demoLombokHashCode  = " + demoLombokHashCode.hashCode());
        System.out.println("demoGuavaHashCode   = " + demoGuavaHashCode.hashCode());
    }

}
