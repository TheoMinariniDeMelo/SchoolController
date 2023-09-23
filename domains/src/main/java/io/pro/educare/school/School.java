package io.pro.educare.school;

import io.pro.educare.Entity;
import io.pro.educare.Production;
import io.pro.educare.TimeZone;
import io.pro.educare.address.Address;
import io.pro.educare.address.Address;
import io.pro.educare.notifications.NotificationHandler;

import java.time.*;
import java.util.LinkedHashSet;
import java.util.UUID;

@Production(Production.Stage.IN_PRODUCTION)
public class School extends Entity<UUID> {
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

    public School() {
    }

    public School update(Address address, String password, LinkedHashSet<String> telephone, String numberOfCountySerial, String name, LinkedHashSet<String> email) {
        this.setAddress(address);
        this.setNumberOfCountrySerial(numberOfCountySerial);
        this.setName(name);
        this.setEmail(email);
        this.updatedAt = ZonedDateTime.now(ZoneId.of(timeZone.getTimezone())).toInstant();
        return this;
    }

    public static School newSchool(
            final Address address,
            final String password,
            final LinkedHashSet<String> telephone,
            final String numberOfCountySerial,
            final String name,
            final LinkedHashSet<String> email,
            final TimeZone timeZone,
            final boolean isActivate
    ) {
        final var now = ZonedDateTime.now(ZoneId.of(timeZone.getTimezone())).toInstant();
        return new School(
                UUID.randomUUID(),
                address,
                password,
                telephone,
                numberOfCountySerial,
                name,
                email,
                timeZone,
                isActivate,
                now,
                now,
                isActivate ? null : now
        );
    }

    public static School with(
            final UUID id,
            final Address address,
            final String password,
            final LinkedHashSet<String> telephone,
            final String numberOfCountySerial,
            final String name,
            final LinkedHashSet<String> email,
            final TimeZone timeZone,
            final boolean isActivate,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt) {
        return new School(
                id,
                address,
                password,
                telephone,
                numberOfCountySerial,
                name,
                email,
                timeZone,
                isActivate,
                createdAt,
                updatedAt,
                deletedAt
        );
    }

    private School(UUID id, Address address, String password, LinkedHashSet<String> telephone, String numberOfCountySerial, String name, LinkedHashSet<String> email, TimeZone timeZone, boolean isActivate, Instant createdAt, Instant updatedAt, Instant deletedAt) {
        this.id = id;
        this.address = address;
        this.password = password;
        this.telephone = telephone;
        this.numberOfCountrySerial = numberOfCountySerial;
        this.name = name;
        this.email = email;
        this.timeZone = timeZone;
        this.isActivate = isActivate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public void validator(NotificationHandler notificationHandler) {
        new SchoolValid(this, notificationHandler);
    }

    public LinkedHashSet<String> getTelephone() {
        return telephone;
    }

    public boolean getIsActivate() {
        return isActivate;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setActivate(boolean activate) {
        isActivate = activate;
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


    public void setTelephone(LinkedHashSet<String> telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LinkedHashSet<String> getEmail() {
        return email;
    }

    public void setEmail(LinkedHashSet<String> email) {
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getNumberOfCountrySerial() {
        return numberOfCountrySerial;
    }

    public void setNumberOfCountrySerial(String cnpj) {
        this.numberOfCountrySerial = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
