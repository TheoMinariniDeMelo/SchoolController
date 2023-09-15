package io.school.address;

import io.school.Pagination;
import io.school.peoples.People;

import java.util.Optional;
import java.util.UUID;

public interface AddressGateway {
    Optional<Address> findById(UUID id);

    Address create(Address people);

    void deleteById(UUID id);

    Pagination<Address> findAll();
}
