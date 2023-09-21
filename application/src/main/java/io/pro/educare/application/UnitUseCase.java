package io.pro.educare.application;

import io.pro.educare.exceptions.NotFoundException;
import io.pro.educare.notifications.Notification;
import io.vavr.control.Either;

public abstract class UnitUseCase<In> {
    protected abstract Either<Notification, Object> execute(In in) throws NotFoundException;
}
