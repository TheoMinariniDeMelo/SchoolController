package io.school.application.peoples.create;

import io.school.address.Address;
import io.school.address.AddressID;
import io.school.role.Role;
import io.school.school.SchoolID;
import io.school.transport.Transport;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record CreatePeoplesRole(

        String name,
        String email,
        String password,
        Transport transport,
        SchoolID schoolID,
        String telephone,
        AddressID addressID,
        String numberOfCountrySerial,
        Role role,
        LocalDate dateOfBirth,
        LocalDateTime createdAt,
        LocalDateTime updateAt,
        LocalDateTime deletedAt
) {
    public static CreatePeoplesRole with(
            String name,
            Transport transport,
            String email,
            String password,
            SchoolID schoolID,
            String telephone,
            String numberOfCountrySerial,
            AddressID addressID,
            Role role,
            LocalDate dateOfBirth,
            LocalDateTime createdAt,
            LocalDateTime updateAt,
            LocalDateTime deletedAt
    ) {
        return new CreatePeoplesRole(name, email, password, transport, schoolID, telephone, addressID, numberOfCountrySerial, role, dateOfBirth, createdAt, updateAt, deletedAt);
    }
}
