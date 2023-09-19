package io.school.application.employer.retriver.get;

import io.school.employee.Employee;
import io.school.employee.EmployeeGateway;
import io.school.employee.EmployeeID;
import io.school.exceptions.NotFoundException;

import java.util.UUID;
import java.util.function.Supplier;

public class DefaultGetEmployerUseCase extends GetEmployerUseCase {
    private final EmployeeGateway employeeGateway;

    public DefaultGetEmployerUseCase(EmployeeGateway employeeGateway) {
        this.employeeGateway = employeeGateway;
    }

    @Override
    public EmployerOutput execute(UUID uuid) throws Exception {
        return employeeGateway.findById(uuid)
                .map(EmployerOutput::from)
                .orElseThrow(notFoundException(uuid));
    }

    private Supplier<? extends Exception> notFoundException(UUID uuid) {
        return () -> NotFoundException.with(Employee.class, EmployeeID.from(uuid));
    }
}
