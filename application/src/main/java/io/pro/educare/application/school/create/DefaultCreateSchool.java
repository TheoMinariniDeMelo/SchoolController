package io.pro.educare.application.school.create;

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


public class DefaultCreateSchool extends CreateEmployerUseCase {
    public SchoolGateway schoolGateway;
    public AddressGateway addressGateway;

    @Override
    public Either<NotificationHandler, CreateSchoolOutput> execute(CreateSchoolRole createPeoplesRole) {
        var name = createPeoplesRole.name();
        var address = createPeoplesRole.address();
        var numberOfCountrySerial = createPeoplesRole.numberOfCountrySerial();
        var email = createPeoplesRole.email();
        var password = createPeoplesRole.password();
        var telephone = createPeoplesRole.telephone();
        var aSchool = School.newSchool(
                address,
                password,
                telephone,
                numberOfCountrySerial,
                name,
                email
        );
        var notification = new NotificationHandler();

        aSchool.validator(notification);

        return notification.hasNotification() ? Either.left(notification) : create(aSchool);
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

    public Either<NotificationHandler, CreateSchoolOutput> create(School school) {
        return Try(() -> schoolGateway.create(school))
                .toEither()
                .bimap(NotificationHandler::create, CreateSchoolOutput::with);
    }
}
