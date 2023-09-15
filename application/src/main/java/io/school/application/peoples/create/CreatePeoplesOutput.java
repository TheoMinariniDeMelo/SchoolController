package io.school.application.peoples.create;

import io.school.peoples.People;
import io.school.peoples.PeopleID;

import java.util.UUID;

public record CreatePeoplesOutput(
        UUID id
) {
    public static CreatePeoplesOutput with(UUID id) {
        return new CreatePeoplesOutput(id);
    }

    public static CreatePeoplesOutput with(People people) {
        return new CreatePeoplesOutput(people.getId());
    }
}
