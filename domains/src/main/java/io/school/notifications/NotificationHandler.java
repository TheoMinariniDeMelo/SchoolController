package io.school.notifications;


import io.school.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NotificationHandler implements Notification {
    private final List<Exception> exceptionList = new ArrayList<>();

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
}
