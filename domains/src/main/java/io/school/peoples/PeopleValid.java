package io.school.peoples;

import io.school.address.Address;
import io.school.validate.NameParser;
import io.school.validate.Validator;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class PeopleValid implements Validator<People> {


    @Override
    public void validate(People people) throws IOException {
        this.addressValidator(people.address);
        this.nameValidator(people.name);
    }

    public static void toValidate(People people) throws IOException {
        new PeopleValid().validate(people);
    }

    public void nameValidator(String name) throws IOException {
        if(NameParser.parseName(name).isEmpty()) getNotificationHandler().addNotification(new Exception("Name is invalid!"));
    }

    public void addressValidator(Address address) throws IOException {
        if (!Objects.isNull(address)) ;
        else {
            getNotificationHandler().addNotification(new Exception("Address is invalid!"));
        }
    }
}
