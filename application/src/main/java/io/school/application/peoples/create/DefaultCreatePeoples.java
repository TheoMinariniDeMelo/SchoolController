package io.school.application.peoples.create;

import io.school.NotNull;
import io.school.notifications.Notification;
import io.school.notifications.NotificationHandler;
import io.school.peoples.People;
import io.school.peoples.PeopleValid;
import io.school.school.SchoolGateway;
import io.vavr.control.Either;

import java.lang.reflect.Field;

public class DefaultCreatePeoples extends CreatePeoplesUseCase {
    public SchoolGateway schoolGateway;

    @Override
    public Either<NotificationHandler, CreatePeoplesRole> execute(CreatePeoplesRole createPeoplesRole) {
        var name = createPeoplesRole.name();
        var address = createPeoplesRole.address();
        var role = createPeoplesRole.role();
        var transport = createPeoplesRole.transport();
        var telephone = createPeoplesRole.telephone();
        var notification = new NotificationHandler();
        var aPeople = People.newPeople(name, transport, telephone, address, role);
        aPeople.validator(notification);
        return null;
    }
}
