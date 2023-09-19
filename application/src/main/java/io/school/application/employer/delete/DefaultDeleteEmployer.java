package io.school.application.employer.delete;

import io.school.employee.Employee;
import io.school.employee.EmployeeGateway;
import io.school.employee.EmployeeID;
import io.school.exceptions.NotFoundException;
import io.school.notifications.Notification;
import io.school.notifications.NotificationHandler;
import io.vavr.control.Either;

import static io.vavr.API.Try;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

public class DefaultDeleteEmployer extends DeleteEmployerUseCase {
    protected EmployeeGateway employeeGateway;

    public DefaultDeleteEmployer(EmployeeGateway employeeGateway) {
        this.employeeGateway = Objects.requireNonNull(employeeGateway);
    }

    @Override
    protected Either<Notification, Object> execute(UUID uuid) throws NotFoundException {
        EmployeeID employeeID = EmployeeID.from(uuid);

        employeeGateway.findById(uuid).orElseThrow(notFound(employeeID));

        return Try(() -> {
                    this.employeeGateway.deleteById(uuid);
                    return null;
                }
        ).toEither().mapLeft(NotificationHandler::create);
    }

    protected Supplier<NotFoundException> notFound(EmployeeID employeeID) {
        return () -> NotFoundException.with(Employee.class, employeeID);
    }
}
