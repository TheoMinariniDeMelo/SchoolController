package io.pro.educare.application.employer.update;

import io.pro.educare.address.AddressID;
import io.pro.educare.employee.Employee;
import io.pro.educare.employee.EmployeeGateway;
import io.pro.educare.employee.EmployeeID;
import io.pro.educare.exceptions.NotFoundException;
import io.pro.educare.notifications.Notification;
import io.pro.educare.notifications.NotificationHandler;
import io.pro.educare.role.RoleGroup;
import io.pro.educare.school.School;
import io.pro.educare.school.SchoolGateway;
import io.pro.educare.school.SchoolID;
import io.pro.educare.transport.Transport;
import io.vavr.control.Either;

import static io.vavr.API.Try;

import java.time.LocalDate;
import java.util.UUID;
import java.util.function.Supplier;

public class DefaultUpdateEmployer extends UpdateEmployerUseCase {
    private final SchoolGateway schoolGateway;
    private final EmployeeGateway employeeGateway;

    public DefaultUpdateEmployer(SchoolGateway schoolGateway, EmployeeGateway employeeGateway) {
        this.schoolGateway = schoolGateway;
        this.employeeGateway = employeeGateway;
    }

    @Override
    public Either<Notification, UpdateResponseEmployer> execute(UpdateCommandEmployer updateCommandEmployer) throws Exception {
        Employee employee = this.employeeGateway.findById(updateCommandEmployer.id()).orElseThrow(notFoundEmployer(EmployeeID.from(updateCommandEmployer.id())));
        final var name = updateCommandEmployer.name();
        final var transport = updateCommandEmployer.transport();
        final var telephone = updateCommandEmployer.telephone();
        final var dateOfBirth = updateCommandEmployer.dateOfBirth();
        final var email = updateCommandEmployer.email();
        final var addressID = updateCommandEmployer.addressID();
        final var schoolID = updateCommandEmployer.schoolID();
        final var password = updateCommandEmployer.password();
        final var role = updateCommandEmployer.roleGroup();
        final var numberOfCountrySerial = updateCommandEmployer.numberOfCountrySerial();
        Employee updatedEmployee = employee.update(name, email, transport, telephone, password, numberOfCountrySerial, schoolID, dateOfBirth, addressID, role);

        NotificationHandler notification = new NotificationHandler();

        updatedEmployee.validator(notification);

        return notification.hasNotification() ? Either.left(notification) : Either.right(update(updatedEmployee)).get();
    }

    private Either<Notification, UpdateResponseEmployer> update(Employee employee) {
        final var schoolId = employee.getSchoolID();
        return Try(() -> {
            this.schoolGateway.findById(schoolId.getValue()).orElseThrow(notFoundSchool(schoolId));
            return this.employeeGateway.create(employee);
        }).toEither().bimap(NotificationHandler::create, UpdateResponseEmployer::from);
    }

    private Supplier<? extends Exception> notFoundEmployer(EmployeeID schoolID) {
        return () -> NotFoundException.with(Employee.class, schoolID);
    }

    private Supplier<? extends Exception> notFoundSchool(SchoolID schoolID) {
        return () -> NotFoundException.with(School.class, schoolID);
    }
}
