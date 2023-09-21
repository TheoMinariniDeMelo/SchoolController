package io.pro.educare.application.employer.create;

import io.pro.educare.application.UseCase;
import io.vavr.control.Either;
import io.pro.educare.notifications.NotificationHandler;
public abstract class CreateEmployerUseCase implements UseCase<CreateEmployerRole, Either<NotificationHandler, CreateEmployerOutput>> {
}
