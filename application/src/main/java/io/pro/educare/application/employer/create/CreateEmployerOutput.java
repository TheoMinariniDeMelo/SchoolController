package io.pro.educare.application.employer.create;

import io.pro.educare.employee.Employee;

import java.util.UUID;

public record CreateEmployerOutput(
        UUID id
) {
    public static CreateEmployerOutput with(UUID id) {
        return new CreateEmployerOutput(id);

    }


    public static CreateEmployerOutput with(Employee employee) {
        return new CreateEmployerOutput(employee.getId());
    }
}
