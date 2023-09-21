package io.pro.educare.application.school.create;

import io.pro.educare.application.UseCase;
import io.pro.educare.notifications.NotificationHandler;
import io.vavr.control.Either;
public abstract class CreateEmployerUseCase implements UseCase<CreateSchoolRole, Either<NotificationHandler, CreateSchoolOutput>> {
}
