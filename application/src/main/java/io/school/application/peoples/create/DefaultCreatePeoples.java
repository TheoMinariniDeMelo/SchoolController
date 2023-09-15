package io.school.application.peoples.create;

import io.school.address.Address;
import io.school.address.AddressGateway;
import io.school.address.AddressID;
import io.school.exceptions.NotFoundException;
import io.school.notifications.NotificationHandler;
import io.school.peoples.People;
import io.school.peoples.PeopleGateway;
import io.school.school.SchoolGateway;
import io.vavr.control.Either;

import java.util.function.Supplier;

import static io.vavr.API.Try;


public class DefaultCreatePeoples extends CreatePeoplesUseCase {
    public SchoolGateway schoolGateway;
    public AddressGateway addressGateway;
    public PeopleGateway peopleGateway;

    @Override
    public Either<NotificationHandler, CreatePeoplesOutput> execute(CreatePeoplesRole createPeoplesRole) {
        var name = createPeoplesRole.name();
        var addressID = createPeoplesRole.addressID();
        var role = createPeoplesRole.role();
        var numberOfCountrySerial = createPeoplesRole.numberOfCountrySerial();
        var transport = createPeoplesRole.transport();
        var schoolId = createPeoplesRole.schoolID();
        var email = createPeoplesRole.email();
        var password = createPeoplesRole.password();
        var telephone = createPeoplesRole.telephone();
        var dateOfBirth = createPeoplesRole.dateOfBirth();
        var createdAt = createPeoplesRole.createdAt();
        var updateAt = createPeoplesRole.updateAt();
        var deletedAt = createPeoplesRole.deletedAt();
        var aPeople = People.newPeople(
                name,
                email,
                password,
                transport,
                numberOfCountrySerial,
                schoolId,
                telephone,
                dateOfBirth,
                addressID,
                role,
                createdAt,
                updateAt,
                deletedAt
        );
        var notification = new NotificationHandler();

        aPeople.validator(notification);

        return notification.hasNotification() ? Either.left(notification) : create(aPeople);
    }

    public Supplier<NotFoundException> notFoundAddress(AddressID addressID) {
        return () -> NotFoundException.with(Address.class, addressID);
    }

    public Address toAddress(AddressID addressID) throws NotFoundException {
        return addressID == null ? null : this.addressGateway.findById(addressID.getValue())
                .orElseThrow(notFoundAddress(addressID));
    }

    public Either<NotificationHandler, CreatePeoplesOutput> create(People people) {
        return Try(() -> peopleGateway.create(people))
                .toEither()
                .bimap(NotificationHandler::create, CreatePeoplesOutput::with);
    }
}
