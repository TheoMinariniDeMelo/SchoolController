package io.school.application.employeer.create;

import io.school.employee.Employee;
import io.school.peoples.People;

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
