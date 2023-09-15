package io.school.exceptions;

import java.util.List;

public abstract class DomainException extends Exception {
    public DomainException(String message, List<Error> anErrors) {
        super(message);
    }
}
