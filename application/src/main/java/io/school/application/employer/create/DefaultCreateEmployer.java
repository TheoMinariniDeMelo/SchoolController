package io.school.application.employer.create;

import io.school.address.Address;
import io.school.address.AddressGateway;
import io.school.address.AddressID;
import io.school.employee.Employee;
import io.school.employee.EmployeeGateway;
import io.school.exceptions.NotFoundException;
import io.school.notifications.NotificationHandler;
import io.school.school.School;
import io.school.school.SchoolGateway;
import io.school.school.SchoolID;
import io.vavr.control.Either;

import java.util.function.Supplier;

import static io.vavr.API.Try;


public class DefaultCreateEmployer extends CreateEmployerUseCase {
    public SchoolGateway schoolGateway;
    public AddressGateway addressGateway;
    public EmployeeGateway employeeGateway;

    @Override
    public Either<NotificationHandler, CreateEmployerOutput> execute(CreateEmployerRole createPeoplesRole) {
        var name = createPeoplesRole.name();
        var addressID = createPeoplesRole.addressID();
        var roleGroup = createPeoplesRole.roleGroup();
        var numberOfCountrySerial = createPeoplesRole.numberOfCountrySerial();
        var transport = createPeoplesRole.transport();
        var schoolId = createPeoplesRole.schoolID();
        var email = createPeoplesRole.email();
        var password = createPeoplesRole.password();
        var telephone = createPeoplesRole.telephone();
        var dateOfBirth = createPeoplesRole.dateOfBirth();
        var aEmployee = Employee.newEemployee(
                name,
                email,
                transport,
                telephone,
                password,
                numberOfCountrySerial,
                schoolId,
                dateOfBirth,
                addressID,
                roleGroup
        );
        var notification = new NotificationHandler();

        aEmployee.validator(notification);

        return notification.hasNotification() ? Either.left(notification) : create(aEmployee);
    }

    public Supplier<NotFoundException> notFoundAddress(AddressID addressID) {
        return () -> NotFoundException.with(Address.class, addressID);
    }

    public Address toAddress(AddressID addressID) throws NotFoundException {
        return addressID == null ? null : this.addressGateway.findById(addressID.getValue())
                .orElseThrow(notFoundAddress(addressID));
    }

    public School toSchool(SchoolID schoolID) throws NotFoundException {
        return schoolID == null ? null : this.schoolGateway.findById(schoolID.getValue())
                .orElseThrow(notFoundSchool(schoolID));
    }

    private Supplier<NotFoundException> notFoundSchool(SchoolID schoolID) {
        return () -> NotFoundException.with(School.class, schoolID);
    }

    public Either<NotificationHandler, CreateEmployerOutput> create(Employee employee) {
        return Try(() -> employeeGateway.create(employee))
                .toEither()
                .bimap(NotificationHandler::create, CreateEmployerOutput::with);
    }
}
