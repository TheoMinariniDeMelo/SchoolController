package io.school.school;

import io.school.address.Address;

import java.util.UUID;

public class School {
    protected UUID id;
    protected Address address;
    protected String cnpj;
    protected String name;
<<<<<<< HEAD
=======
    public School(){}


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
>>>>>>> c5c7136a1eee1c621aff9e1335b6983ff58f5ac8
}
