package io.school.application.peoples.create;

import java.util.UUID;

public record CreatePeoplesOutput(
        UUID id
) {
    public static CreatePeoplesOutput with(UUID id) {
        return new CreatePeoplesOutput(id);
    }
}
