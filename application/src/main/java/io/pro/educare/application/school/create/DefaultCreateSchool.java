package io.pro.educare.application.school.create;

import io.pro.educare.address.Address;
import io.pro.educare.address.AddressGateway;
import io.pro.educare.address.AddressID;
import io.pro.educare.exceptions.NotFoundException;
import io.pro.educare.notifications.NotificationHandler;
import io.pro.educare.school.School;
import io.pro.educare.school.SchoolGateway;
import io.pro.educare.school.SchoolID;
import io.vavr.control.Either;

import java.util.function.Supplier;

import static io.vavr.API.Try;


public class DefaultCreateSchool extends CreateEmployerUseCase {
    public final SchoolGateway schoolGateway;


    public DefaultCreateSchool(SchoolGateway schoolGateway) {
        this.schoolGateway = schoolGateway;

    }

    @Override
    public Either<NotificationHandler, CreateSchoolOutput> execute(CreateSchoolRole createPeoplesRole) {
        var name = createPeoplesRole.name();
        var address = createPeoplesRole.address();
        var numberOfCountrySerial = createPeoplesRole.numberOfCountrySerial();
        var email = createPeoplesRole.email();
        var password = createPeoplesRole.password();
        var telephone = createPeoplesRole.telephone();
        var timeZone = createPeoplesRole.timeZone();
        var isActivate = createPeoplesRole.isActivate();
        var aSchool = School.newSchool(
                address,
                password,
                telephone,
                numberOfCountrySerial,
                name,
                email,
                timeZone,
                isActivate
        );
        var notification = new NotificationHandler();

        aSchool.validator(notification);

        return notification.hasNotification() ? Either.left(notification) : create(aSchool);
    }


    public Either<NotificationHandler, CreateSchoolOutput> create(School school) {
        return Try(() -> schoolGateway.create(school))
                .toEither()
                .bimap(NotificationHandler::create, CreateSchoolOutput::with);
    }
}
