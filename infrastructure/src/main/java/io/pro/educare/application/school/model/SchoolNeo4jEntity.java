package io.pro.educare.application.school.model;

import io.pro.educare.TimeZone;
import io.pro.educare.address.Address;
import io.pro.educare.school.School;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.UUID;

@Node("school")
public class SchoolNeo4jEntity {
    @Id
    protected UUID id;
    protected String password;
    protected LinkedHashSet<String> telephone;
    protected Address address;
    protected String numberOfCountrySerial;
    protected LinkedHashSet<String> email;
    protected String name;
    protected TimeZone timeZone;
    protected boolean isActivate;
    protected Instant createdAt;
    protected Instant updatedAt;
    protected Instant deletedAt;

    public SchoolNeo4jEntity() {

    }

    public SchoolNeo4jEntity(UUID id, String password, LinkedHashSet<String> telephone, Address address, String numberOfCountrySerial, LinkedHashSet<String> email, String name, TimeZone timeZone, boolean isActivate, Instant createdAt, Instant updatedAt, Instant deletedAt) {
        this.id = id;
        this.password = password;
        this.telephone = telephone;
        this.address = address;
        this.numberOfCountrySerial = numberOfCountrySerial;
        this.email = email;
        this.name = name;
        this.timeZone = timeZone;
        this.isActivate = isActivate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static SchoolNeo4jEntity from(School school) {
        return new SchoolNeo4jEntity(
                school.getId(),
                school.getPassword(),
                school.getTelephone(),
                school.getAddress(),
                school.getNumberOfCountrySerial(),
                school.getEmail(),
                school.getName(),
                school.getTimeZone(),
                school.getIsActivate(),
                school.getCreatedAt(),
                school.getUpdatedAt(),
                school.getDeletedAt()
        );
    }

    public School toAggregate() {
        return School.with(
                this.getId(),
                this.getAddress(),
                this.getPassword(),
                this.getTelephone(),
                this.getNumberOfCountrySerial(),
                this.getName(),
                this.getEmail(),
                this.getTimeZone(),
                this.isActivate(),
                this.getCreatedAt(),
                this.getUpdatedAt(),
                this.getDeletedAt()
        );
    }

    public UUID getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public LinkedHashSet<String> getTelephone() {
        return telephone;
    }

    public Address getAddress() {
        return address;
    }

    public String getNumberOfCountrySerial() {
        return numberOfCountrySerial;
    }

    public LinkedHashSet<String> getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public boolean isActivate() {
        return isActivate;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
}
