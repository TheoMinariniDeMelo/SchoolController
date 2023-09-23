package io.pro.educare.application.employer.create;

import io.pro.educare.address.Address;
import io.pro.educare.address.AddressGateway;
import io.pro.educare.address.AddressID;
import io.pro.educare.employee.Employee;
import io.pro.educare.employee.EmployeeGateway;
import io.pro.educare.exceptions.NotFoundException;
import io.pro.educare.notifications.NotificationHandler;
import io.pro.educare.school.School;
import io.pro.educare.school.SchoolGateway;
import io.pro.educare.school.SchoolID;
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
        var address = createPeoplesRole.address();
        var roleGroup = createPeoplesRole.roleGroup();
        var numberOfCountrySerial = createPeoplesRole.numberOfCountrySerial();
        var transport = createPeoplesRole.transport();
        var schoolID = createPeoplesRole.schoolID();
        var email = createPeoplesRole.email();
        var telephone = createPeoplesRole.telephone();
        var dateOfBirth = createPeoplesRole.dateOfBirth();
        var aEmployee = Employee.newEemployee(
                name,
                email,
                transport,
                telephone,
                numberOfCountrySerial,
                schoolID,
                dateOfBirth,
                address,
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
