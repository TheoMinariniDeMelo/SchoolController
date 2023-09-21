package io.pro.educare.application.school.update;

import io.pro.educare.application.UseCase;
import io.pro.educare.notifications.Notification;
import io.vavr.control.Either;

public abstract class UpdateSchoolUseCase implements UseCase<UpdateCommandSchool, Either<Notification, UpdateResponseEmployer>> {
}
