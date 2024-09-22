package com.b5wang.javabasics.alg.primary.collection;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

/**
 * IDE-based generated code equals() and hashCode()
 * Coed -> Generate... -> equals() and hashCode() -> java.util.Objects.equals() and hashCode() (Java 7 and higher)
 * */
public class DemoIntellijGenHashCode {

    private int id;
    private String name;
    private LocalDate birthday;

    public DemoIntellijGenHashCode(int id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoIntellijGenHashCode that = (DemoIntellijGenHashCode) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthday);
    }
}
