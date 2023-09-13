package io.school.peoples;

import io.school.address.Address;
import io.school.notifications.Notification;
import io.school.notifications.NotificationHandler;
import io.school.validate.NameParser;
import io.school.validate.Validator;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public abstract class PeopleValid implements Validator<People, NotificationHandler> {

    public Notification notification;

    @Override
    public void validate(People people, NotificationHandler notification) {
        try {
            this.notification = notification;
            this.addressValidator(people.address);
            this.nameValidator(people.name);
        } catch (Exception e) {
            notification.addNotification(new Exception("Internal error!"));
            ;
        }
    }


    protected void nameValidator(String name) throws IOException {
        if (NameParser.parseName(name).isEmpty())
            notification.addNotification(new Exception("Name is invalid!"));
    }

    protected void addressValidator(Address address) throws IOException {
        if (!Objects.isNull(address)) ;
        else {
            notification.addNotification(new Exception("Address is invalid!"));
        }
    }
}
