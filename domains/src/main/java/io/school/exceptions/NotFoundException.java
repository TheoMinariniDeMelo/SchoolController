package io.school.exceptions;

import io.school.Entity;
import io.school.Identify;
import io.school.NotNull;

import java.util.Collections;
import java.util.List;

public class NotFoundException extends DomainException {

    protected NotFoundException(@NotNull String message, final List<Error> anErrors) {
        super(message, anErrors);
    }

    public static NotFoundException with(
            final Class<? extends Entity> entity,
            final Identify id
    ) {
        final var anError = "%s with ID %s was not found".formatted(
                entity.getSimpleName(),
                id.getValue()
        );
        return new NotFoundException(anError, Collections.emptyList());
    }
}
