package io.pro.educare.validate;

import io.pro.educare.notifications.NotificationHandler;

public interface ValidationHandler {
    default NotificationHandler getNotificationHandler() {
        return new NotificationHandler();
    }

    ;
}
