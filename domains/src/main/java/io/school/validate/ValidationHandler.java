package io.school.validate;

import io.school.notifications.NotificationHandler;

public interface ValidationHandler {
    default NotificationHandler etNotificationHandler() {
        return new NotificationHandler();
    }

    ;
}
