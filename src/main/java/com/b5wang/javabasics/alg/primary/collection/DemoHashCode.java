package com.b5wang.javabasics.alg.primary.collection;

import java.util.Arrays;

public class DemoHashCode {

    public static void main(String[] args) {
        // Intellij generated hash code
        DemoIntellijGenHashCode intellijGenHashCode = new DemoIntellijGenHashCode();
        // Common lang hash code
        DemoCLHashCode demoCLHashCode = new DemoCLHashCode();
        // Common lang 3
        DemoCL3HashCode demoCL3HashCode = new DemoCL3HashCode();
        // Lombok
        DemoLombokHashCode demoLombokHashCode = new DemoLombokHashCode();

        System.out.println("intellijGenHashCode = " + intellijGenHashCode.hashCode());
        System.out.println("demoCLHashCode      = " + demoCLHashCode.hashCode());
        System.out.println("demoCL3HashCode     = " + demoCL3HashCode.hashCode());
        System.out.println("demoLombokHashCode  = " + demoLombokHashCode.hashCode());
    }

}
