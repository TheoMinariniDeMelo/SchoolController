package io.school.peoples;

import io.school.address.Address;
import io.school.role.Role;
import io.school.transport.Transport;

import java.util.UUID;

public class People {
    protected UUID id;
    protected String name;
    protected Transport transport;
    protected String telephone;

    protected Address address;
    protected Role role ;

    public People() {
    }

    public People(String name, Transport transport, String telephone, Address address, Role role) {
        this.name = name;
        this.transport = transport;
        this.telephone = telephone;
        this.address = address;
        this.role = role;
    }
    public static People newPeople(String name, Transport transport, String telephone, Address address, Role role){
        return new People(name,transport,telephone,address,role);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
