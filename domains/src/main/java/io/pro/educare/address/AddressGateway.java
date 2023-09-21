package io.pro.educare.address;

import io.pro.educare.Pagination;

import java.util.Optional;
import java.util.UUID;

public interface AddressGateway {
    Optional<Address> findById(UUID id);

    Address create(Address people);

    void deleteById(UUID id);

    Pagination<Address> findAll();
}
