package io.school.application;

import io.school.exceptions.NotFoundException;
import io.school.notifications.Notification;
import io.school.notifications.NotificationHandler;
import io.vavr.control.Either;

public abstract class UnitUseCase<In> {
    protected abstract Either<Notification, Object> execute(In in) throws NotFoundException;
}
