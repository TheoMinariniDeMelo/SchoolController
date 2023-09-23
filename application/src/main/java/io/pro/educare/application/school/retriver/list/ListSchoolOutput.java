package io.pro.educare.application.school.retriver.list;

import io.pro.educare.address.Address;
import io.pro.educare.employee.Employee;
import io.pro.educare.role.RoleGroup;
import io.pro.educare.school.SchoolID;
import io.pro.educare.transport.Transport;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record ListSchoolOutput(
        UUID id,
        String name,
        String email,
        Transport transport,
        String telephone,
        String numberOfCountrySerial,
        SchoolID schoolID,
        LocalDate dateOfBirth,
        Address addressID,
        RoleGroup roleGroup,
        Instant createdAt,
        Instant updateAt,
        Instant deletedAt) {
    public static ListSchoolOutput from(Employee employee) {
        return new ListSchoolOutput(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getTransport(),
                employee.getTelephone(),
                employee.getNumberOfCountrySerial(),
                employee.getSchoolID(),
                employee.getDateOfBirth(),
                employee.getAddress(),
                employee.getRoleGroup(),
                employee.getCreatedAt(),
                employee.getUpdateAt(),
                employee.getDeletedAt()
        );
    }

}
