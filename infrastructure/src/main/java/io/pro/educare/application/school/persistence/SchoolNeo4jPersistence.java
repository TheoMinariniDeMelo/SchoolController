package io.pro.educare.application.school.persistence;

import io.pro.educare.address.Address;

import java.util.LinkedHashSet;
import java.util.UUID;

public record SchoolNeo4jPersistence(
        UUID id,
        String password,
        LinkedHashSet<String> telephone,
        Address address,
        String numberOfCountrySerial,
        LinkedHashSet<String> email,
        String name,
        String timeZone,
        boolean isActivate
) {

}
