package io.school.peoples;

import io.school.address.Address;
import io.school.filesReader.PropertiesHandler;
import io.school.validate.Validator;

import java.io.IOException;
import java.util.Objects;
import java.util.regex.Pattern;

public class PeopleValid implements Validator<People> {


    @Override
    public void validate(People people) {

    }

    public static void toValidate(People people) {
        new PeopleValid().validate(people);
    }

    public void nameValidator(String name) throws IOException {
        if (!name.isBlank() && Pattern.matches(PropertiesHandler.matcher(), name)) ;
        else {
            getNotificationHandler().addNotification(new Exception("Name are invalid!"));
        }
    }

    public void addressValidator(Address address) throws IOException {
        if (!Objects.isNull(address) && Pattern.matches(PropertiesHandler.matcher(), null)) ;
        else {
            getNotificationHandler().addNotification(new Exception("Address are invalid!"));
        }
    }
}
