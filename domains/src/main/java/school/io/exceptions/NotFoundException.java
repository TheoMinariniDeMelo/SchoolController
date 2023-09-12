package io.school.exceptions;

import io.school.NotNull;

public class NotFoundException extends Exception {
    NotFoundException(@NotNull String message) {
        super(message);
    }

}
