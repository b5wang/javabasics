package com.b5wang.javabasics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCode {

    public static void main(String[] args){

        String str = "{\"page\":1,\"per_page\":500,\"total\":1,\"total_pages\":1,\"data\":[{\"barcode\":\"74002314\",\"item\":\"Nightgown\",\"category\":\"Underwear\",\"price\":3705,\"discount\":20,\"available\":1}]}";
        // {"barcode":"74002314","item":"Nightgown","category":"Underwear","price":3705,"discount":20,"available":1}

        // Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Pattern pattern = Pattern.compile("\\\"price\":(.*?)\\,");
        Matcher matcher = pattern.matcher(str);
//        while(matcher.find()){
//            System.out.print(matcher.group(1));
//        }
        matcher.find();
        System.out.print(matcher.group(1));
    }

}
