package io.pro.educare.application.employer.update;

import io.pro.educare.NotNull;
import io.pro.educare.employee.Employee;

import java.util.UUID;

public record UpdateResponseEmployer(UUID id) {
    public static UpdateResponseEmployer from(@NotNull UUID id) {
        return new UpdateResponseEmployer(id);
    }

    public static UpdateResponseEmployer from( Employee employee) {
        return new UpdateResponseEmployer(employee.getId());
    }

}
