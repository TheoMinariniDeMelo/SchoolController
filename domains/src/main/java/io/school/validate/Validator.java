package io.school.validate;

import io.school.peoples.People;


public interface Validator<EN> extends ValidationHandler {

    void validate(EN people);
}
