package io.pro.educare.application.school.retriver.get;

import io.pro.educare.employee.Employee;
import io.pro.educare.employee.EmployeeGateway;
import io.pro.educare.employee.EmployeeID;
import io.pro.educare.exceptions.NotFoundException;
import io.pro.educare.school.SchoolGateway;

import java.util.UUID;
import java.util.function.Supplier;

public class DefaultGetSchoolUseCase extends GetSchoolUseCase {
    private final SchoolGateway schoolGateway;

    public DefaultGetSchoolUseCase(SchoolGateway schoolGateway) {
        this.schoolGateway = schoolGateway;
    }

    @Override
    public SchoolOutput execute(UUID uuid) throws Exception {
        return schoolGateway.findById(uuid)
                .map(SchoolOutput::from)
                .orElseThrow(notFoundException(uuid));
    }

    private Supplier<? extends Exception> notFoundException(UUID uuid) {
        return () -> NotFoundException.with(Employee.class, EmployeeID.from(uuid));
    }
}
