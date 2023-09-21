package io.pro.educare.address;

import io.pro.educare.Entity;

import java.util.UUID;

public class Address extends Entity<UUID> {
    protected UUID id;
    protected String road;
    protected String neighborhood;
    protected Integer number;
    protected String reference;

    public Address(String road, String neighborhood, Integer number, String reference) {
        this.road = road;
        this.neighborhood = neighborhood;
        this.number = number;
        this.reference = reference;
    }

    public UUID getId() {
        return id;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
