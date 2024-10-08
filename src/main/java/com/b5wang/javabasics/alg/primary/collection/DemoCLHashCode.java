package com.b5wang.javabasics.alg.primary.collection;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.time.Instant;
import java.time.LocalDate;

public class DemoCLHashCode {
    private int id;
    private String name;
    private LocalDate birthday;

    public DemoCLHashCode(int id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoCLHashCode that = (DemoCLHashCode) o;
        return new EqualsBuilder().append(id, that.id).append(name, that.name).append(birthday, that.birthday).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(name).append(birthday).toHashCode();
    }

}
