package io.pro.educare.validate;

import io.school.peoples.People;

import java.io.IOException;


public interface Validator<EN, N> {
    void validate(EN value, N notification) throws IOException;

}
