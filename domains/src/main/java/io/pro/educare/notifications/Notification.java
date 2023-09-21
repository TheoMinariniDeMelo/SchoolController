package io.pro.educare.notifications;

import java.util.List;

public interface Notification {

    void addNotification(Exception exception);

    void addNotification(List<Exception> exception);

    boolean hasNotification();

    List<Exception> getException();

    Exception getException(int exception);

}
