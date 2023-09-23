package io.pro.educare.validate;


import java.io.IOException;


public interface Validator<EN, N> {
    void validate(EN value, N notification) throws IOException;

}
