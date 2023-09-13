package io.school.validate;

import io.school.peoples.People;

import java.io.IOException;


public interface Validator<EN> extends ValidationHandler {

    void validate(EN people) throws IOException;
}
