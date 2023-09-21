package io.pro.educare.application.school.retriver.get;

import io.pro.educare.address.Address;
import io.pro.educare.address.AddressID;
import io.pro.educare.employee.Employee;
import io.pro.educare.role.RoleGroup;
import io.pro.educare.school.School;
import io.pro.educare.school.SchoolID;
import io.pro.educare.transport.Transport;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.UUID;

public record SchoolOutput(
        UUID id,
        String name,
        LinkedHashSet<String> email,
        LinkedHashSet<String> telephone,
        String password,
        String numberOfCountrySerial,
        Address addressID,
        Instant createdAt,
        Instant updateAt,
        Instant deletedAt
) {
    public static SchoolOutput from(
            School school
    ) {
        return new SchoolOutput(
                school.getId(),
                school.getName(),
                school.getEmail(),
                school.getTelephone(),
                school.getPassword(),
                school.getNumberOfCountrySerial(),
                school.getAddress(),
                school.getCreatedAt(),
                school.getUpdatedAt(),
                school.getDeletedAt()
        );
    }
}
