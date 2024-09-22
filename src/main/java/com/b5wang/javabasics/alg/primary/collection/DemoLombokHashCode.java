package com.b5wang.javabasics.alg.primary.collection;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.time.Instant;
import java.time.LocalDate;


@AllArgsConstructor
@EqualsAndHashCode
public class DemoLombokHashCode {

    private int id;
    private String name;
    private LocalDate birthday;

}
