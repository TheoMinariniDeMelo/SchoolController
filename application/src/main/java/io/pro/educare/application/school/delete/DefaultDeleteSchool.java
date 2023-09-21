package io.pro.educare.application.school.delete;

import io.pro.educare.employee.Employee;
import io.pro.educare.employee.EmployeeGateway;
import io.pro.educare.employee.EmployeeID;
import io.pro.educare.exceptions.NotFoundException;
import io.pro.educare.notifications.Notification;
import io.pro.educare.notifications.NotificationHandler;
import io.pro.educare.school.School;
import io.pro.educare.school.SchoolGateway;
import io.pro.educare.school.SchoolID;
import io.vavr.control.Either;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

import static io.vavr.API.Try;

public class DefaultDeleteSchool extends DeleteSchoolUseCase {
    protected SchoolGateway schoolGateway;

    public DefaultDeleteSchool(SchoolGateway schoolGateway) {
        this.schoolGateway = Objects.requireNonNull(schoolGateway);
    }

    @Override
    protected Either<Notification, Object> execute(UUID uuid) throws NotFoundException {
        SchoolID schoolID = SchoolID.from(uuid);

        schoolGateway.findById(uuid).orElseThrow(notFound(schoolID));

        return Try(() -> {
                    this.schoolGateway.deleteById(uuid);
                    return null;
                }
        ).toEither().mapLeft(NotificationHandler::create);
    }

    protected Supplier<NotFoundException> notFound(SchoolID employeeID) {
        return () -> NotFoundException.with(School.class, employeeID);
    }
}
