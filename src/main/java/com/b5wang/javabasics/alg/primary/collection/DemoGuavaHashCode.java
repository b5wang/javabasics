package com.b5wang.javabasics.alg.primary.collection;

import com.google.common.base.Objects;

import java.time.LocalDate;

public class DemoGuavaHashCode {

    private int id;
    private String name;
    private LocalDate birthday;

    public DemoGuavaHashCode(int id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoGuavaHashCode that = (DemoGuavaHashCode) o;
        return id == that.id && Objects.equal(name, that.name) && Objects.equal(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, birthday);
    }
}
