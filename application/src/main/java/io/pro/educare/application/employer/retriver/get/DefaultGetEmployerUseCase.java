package io.pro.educare.application.employer.retriver.get;

import io.pro.educare.employee.Employee;
import io.pro.educare.employee.EmployeeGateway;
import io.pro.educare.employee.EmployeeID;
import io.pro.educare.exceptions.NotFoundException;

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
