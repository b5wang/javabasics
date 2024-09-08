package com.b5wang.javabasics.alg.primary.collection;

import java.time.Instant;
import java.util.Objects;

/**
 * IDE-based generated code equals() and hashCode()
 * Coed -> Generate... -> equals() and hashCode() -> java.util.Objects.equals() and hashCode() (Java 7 and higher)
 * */
public class DemoHashCode {

    private int id;
    private String name;
    private Instant birthday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoHashCode that = (DemoHashCode) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthday);
    }
}
