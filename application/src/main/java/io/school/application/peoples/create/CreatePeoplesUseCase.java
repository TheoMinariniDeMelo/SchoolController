package io.school.application.peoples.create;

import io.school.application.UseCase;
import io.vavr.control.Either;
import io.school.notifications.NotificationHandler;
public abstract class CreatePeoplesUseCase implements UseCase<CreatePeoplesRole, Either<NotificationHandler,CreatePeoplesOutput>> {
}
