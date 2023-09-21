package io.pro.educare.school;

import io.pro.educare.Entity;
import io.pro.educare.address.Address;

import java.util.UUID;

public class School extends Entity<UUID> {
    protected UUID id;
    protected Address address;
    protected String cnpj;
    protected String name;

    public School() {
    }


    public School(Address address, String cnpj, String name) {
        this.address = address;
        this.cnpj = cnpj;
        this.name = name;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
