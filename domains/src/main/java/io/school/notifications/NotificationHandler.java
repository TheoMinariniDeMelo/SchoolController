package io.school.notifications;


import io.school.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NotificationHandler implements Notification {
    private final List<Exception> exceptionList = new ArrayList<>();

    public static void create(Exception exception) {
        new NotificationHandler().addNotification(new Exception(exception.getMessage()));
    }

    public static void create() {
        new NotificationHandler();
    }

    @Override
    public void addNotification(@NotNull Exception exception) {
        exceptionList.add(exception);
    }

    @Override
    public void addNotification(@NotNull List<Exception> exception) {
        exception.addAll(exception);
    }

    @Override
    public boolean hasNotification() {
        return !exceptionList.isEmpty();
    }

    @Override
    public List<Exception> getException() {
        return exceptionList;
    }


    @Override
    public Exception getException(@NotNull int exception) {
        return exceptionList.get(exception);
    }

    public static NotificationHandler create(Throwable throwable) {
        return new NotificationHandler();
    }
}
