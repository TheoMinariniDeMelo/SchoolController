package io.school.school;

import io.school.Pagination;

import java.util.Optional;
import java.util.UUID;

public interface SchoolGateway {
    Optional<School> findById(UUID id);

    School save(School school);

    void deleteById(UUID id);

    Pagination<School> findAll();
}
