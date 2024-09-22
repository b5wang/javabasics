package com.b5wang.javabasics.alg.primary.collection;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.Instant;
import java.time.LocalDate;

@Setter
@Getter
public class DemoCL3HashCode {
    private int id;
    private String name;
    private LocalDate birthday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoCL3HashCode that = (DemoCL3HashCode) o;
        return new EqualsBuilder().append(id, that.id).append(name, that.name).append(birthday, that.birthday).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(name).append(birthday).toHashCode();
    }
}
