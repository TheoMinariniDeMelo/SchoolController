package io.school.application.peoples.create;

import io.school.notifications.NotificationHandler;
import io.school.school.SchoolGateway;
import io.vavr.control.Either;

public class DefaultCreatePeoples extends CreatePeoplesUseCase {
    public SchoolGateway schoolGateway;

    @Override
    public Either<NotificationHandler, CreatePeoplesRole> execute(CreatePeoplesRole createPeoplesRole) {
        createPeoplesRole.

    }
}
