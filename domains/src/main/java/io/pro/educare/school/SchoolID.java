package io.pro.educare.school;

import io.pro.educare.Identify;

import java.util.Objects;
import java.util.UUID;

public class SchoolID implements Identify<UUID> {
    private final UUID value;

    private SchoolID(final UUID id) {
        this.value = Objects.requireNonNull(id);
    }

    private static SchoolID from(final UUID value) {
        return new SchoolID(value);
    }

    @Override
    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolID schoolID = (SchoolID) o;
        return Objects.equals(value, schoolID.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
