package io.school.validate;

import io.school.notifications.Notification;
import io.school.peoples.People;

import java.io.IOException;


public interface Validator<EN, N> {
    void validate(EN value, N notification) throws IOException;

}
