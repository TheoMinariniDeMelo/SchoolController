package io.pro.educare.application.employer.update;

import io.pro.educare.application.UseCase;
import io.pro.educare.notifications.Notification;
import io.vavr.control.Either;

public abstract class UpdateEmployerUseCase implements UseCase<UpdateCommandEmployer, Either<Notification, UpdateResponseEmployer>> {
}
