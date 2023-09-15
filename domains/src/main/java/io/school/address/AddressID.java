package io.school.address;

import io.school.Identify;
import io.school.school.SchoolID;

import java.util.Objects;
import java.util.UUID;

public class AddressID implements Identify<UUID> {
    private final UUID value;

    private AddressID(final UUID id) {
        this.value = Objects.requireNonNull(id);
    }

    private static AddressID from(final UUID value) {
        return new AddressID(value);
    }

    @Override
    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressID addressID = (AddressID) o;
        return Objects.equals(value, addressID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
