package io.school.employee;

import io.school.Identify;
import io.school.address.AddressID;

import java.util.Objects;
import java.util.UUID;

public class EmployeeID implements Identify<UUID> {
    private final UUID value;

    private EmployeeID(final UUID id) {
        this.value = Objects.requireNonNull(id);
    }

    public static EmployeeID from(final UUID value) {
        return new EmployeeID(value);
    }

    @Override
    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeID addressID = (EmployeeID) o;
        return Objects.equals(value, addressID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
