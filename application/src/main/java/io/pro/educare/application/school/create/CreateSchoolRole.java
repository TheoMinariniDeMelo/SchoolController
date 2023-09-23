package io.pro.educare.application.school.create;

import io.pro.educare.address.Address;
import io.pro.educare.TimeZone;
import io.pro.educare.address.Address;

import java.time.Instant;
import java.util.LinkedHashSet;

public record CreateSchoolRole(

        String name,
        LinkedHashSet<String> email,
        String password,
        LinkedHashSet<String> telephone,
        Address address,
        TimeZone timeZone,
        String numberOfCountrySerial,
        Instant createdAt,
        Instant updateAt,
        Instant deletedAt,
        boolean isActivate
) {
    public static CreateSchoolRole with(
            String name,
            LinkedHashSet<String> email,
            String password,
            LinkedHashSet<String> telephone,
            String numberOfCountrySerial,
            Address Address,
            TimeZone timeZone,
            Instant createdAt,
            Instant updateAt,
            Instant deletedAt,
            boolean isActivate
    ) {
        return new CreateSchoolRole(name, email, password, telephone, Address, timeZone, numberOfCountrySerial, createdAt, updateAt, deletedAt, isActivate);
    }
}
