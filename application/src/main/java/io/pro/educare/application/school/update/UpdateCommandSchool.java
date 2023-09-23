package io.pro.educare.application.school.update;

import io.pro.educare.address.Address;
import io.pro.educare.role.RoleGroup;
import io.pro.educare.school.SchoolID;
import io.pro.educare.transport.Transport;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateCommandSchool(
        UUID id,
        String name,
        String email,
        Transport transport,
        String telephone,
        String password,
        String numberOfCountrySerial,
        SchoolID schoolID,
        LocalDate dateOfBirth,
        Address address,
        RoleGroup roleGroup
) {

}
