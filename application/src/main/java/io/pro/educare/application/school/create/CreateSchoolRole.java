package io.pro.educare.application.school.create;

import io.pro.educare.address.Address;
import io.pro.educare.address.AddressID;
import io.pro.educare.role.RoleGroup;
import io.pro.educare.school.SchoolID;
import io.pro.educare.transport.Transport;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;

public record CreateSchoolRole(

        String name,
        LinkedHashSet<String> email,
        String password,
        LinkedHashSet<String> telephone,
        Address address,
        String numberOfCountrySerial,
        LocalDateTime createdAt,
        LocalDateTime updateAt,
        LocalDateTime deletedAt
) {
    public static CreateSchoolRole with(
            String name,
            LinkedHashSet<String> email,
            String password,
            LinkedHashSet<String> telephone,
            String numberOfCountrySerial,
            Address address,
            LocalDateTime createdAt,
            LocalDateTime updateAt,
            LocalDateTime deletedAt
    ) {
        return new CreateSchoolRole(name, email, password, telephone, address, numberOfCountrySerial, createdAt, updateAt, deletedAt);
    }
}
