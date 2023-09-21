package io.pro.educare.application.employer.delete;

import io.pro.educare.employee.Employee;
import io.pro.educare.employee.EmployeeGateway;
import io.pro.educare.employee.EmployeeID;
import io.pro.educare.exceptions.NotFoundException;
import io.pro.educare.notifications.Notification;
import io.pro.educare.notifications.NotificationHandler;
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
