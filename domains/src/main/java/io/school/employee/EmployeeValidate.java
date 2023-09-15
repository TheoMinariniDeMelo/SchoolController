package io.school.employee;

import io.school.address.AddressID;
import io.school.notifications.Notification;
import io.school.notifications.NotificationHandler;
import io.school.peoples.People;
import io.school.validate.NameParser;
import io.school.validate.Validator;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class EmployeeValidate implements Validator<Employee, NotificationHandler> {
    private Notification notification;


    public void validate(Employee employee, NotificationHandler notification) {
        try {
            this.notification = notification;
            this.addressValidator(employee.getAddressID().getValue());
            this.nameValidator(employee.getName());
            this.passwordValidator(employee.getPassword());
        } catch (Exception e) {
            notification.addNotification(new Exception("Internal error!"));
            ;
        }
    }

    private void schoolIdValidator(AddressID addressID) {

    }

    private void passwordValidator(String password) {
        if (Objects.isNull(password)) {
            notification.addNotification(new Exception("Password is invalid!"));
        } else if (password.length() < 8) {
            notification.addNotification(new Exception("Password must be at least 8 characters long!"));
        }
        // Verificar a presença de pelo menos um caractere especial, uma letra maiúscula,
        // uma letra minúscula e um número na senha
        else if (!Pattern.compile("^(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$").matcher(password).matches()) {
            notification.addNotification(new Exception("Password does not meet the criteria!"));
        }
    }


    private void nameValidator(String name) throws IOException {
        if (Objects.isNull(NameParser.parseName(name)))
            notification.addNotification(new Exception("Name is invalid!"));
    }

    private void addressValidator(UUID address) throws IOException {
        if (Objects.isNull(address)) notification.addNotification(new Exception("Address is invalid!"));
    }
}
