package io.pro.educare.application.school.create;

import io.pro.educare.employee.Employee;
import io.pro.educare.school.School;

import java.util.UUID;

public record CreateSchoolOutput(
        UUID id
) {
    public static CreateSchoolOutput with(UUID id) {
        return new CreateSchoolOutput(id);
    }


    public static CreateSchoolOutput with(School school) {
        return new CreateSchoolOutput(school.getId());
    }
    
}
