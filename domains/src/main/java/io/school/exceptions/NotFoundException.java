package io.school.exceptions;

import io.school.Entity;
import io.school.Identify;
import io.school.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class NotFoundException extends DomainException {

    protected NotFoundException(@NotNull String message, final List<Error> anErrors) {
        super(message, anErrors);
    }

    public static NotFoundException with(
            final Class<? extends Entity> entity,
            final Identify<UUID> id
    ) {
        final var anError = "%s with ID %s was not found".formatted(
                entity.getSimpleName(),
                id.getValue()
        );
        return new NotFoundException(anError, Collections.emptyList());
    }
}
