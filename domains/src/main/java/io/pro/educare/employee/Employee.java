package io.pro.educare.employee;

import io.pro.educare.Entity;
import io.pro.educare.address.Address;
import io.pro.educare.address.AddressID;
import io.pro.educare.notifications.NotificationHandler;
import io.pro.educare.role.RoleGroup;
import io.pro.educare.transport.Transport;
import io.pro.educare.Production;
import io.pro.educare.school.SchoolID;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Production(Production.Stage.IN_PRODUCTION)
public class Employee extends Entity<UUID> {

    protected UUID id;
    protected String name;
    protected String email;
    protected Transport transport;
    protected String telephone;
    protected String password;
    protected String numberOfCountrySerial;
    protected SchoolID schoolID;
    protected LocalDate dateOfBirth;
    protected Address address;
    protected RoleGroup roleGroup;
    protected LocalDateTime createdAt;
    protected LocalDateTime updateAt;
    protected LocalDateTime deletedAt;

    public void validator(NotificationHandler notification) {
        new EmployeeValidate().validate(this, notification);
    }

    public static Employee newEemployee(String name, String email, Transport transport, String telephone, String password, String numberOfCountrySerial, SchoolID schoolID, LocalDate dateOfBirth, Address address, RoleGroup roleGroup) {
        return new Employee(
                name,
                email,
                transport,
                telephone,
                password,
                numberOfCountrySerial,
                schoolID,
                dateOfBirth,
                address,
                roleGroup
        );
    }


    public Employee(String name, String email, Transport transport, String telephone, String password, String numberOfCountrySerial, SchoolID schoolID, LocalDate dateOfBirth, Address address, RoleGroup role) {
        this.name = name;
        this.email = email;
        this.transport = transport;
        this.telephone = telephone;
        this.password = password;
        this.numberOfCountrySerial = numberOfCountrySerial;
        this.schoolID = schoolID;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.roleGroup = role;
    }

    public Employee update(String name, String email, Transport transport, String telephone, String password, String numberOfCountrySerial, SchoolID schoolID, LocalDate dateOfBirth, Address address, RoleGroup role) {
        this.setName(name);
        this.setEmail(email);
        this.setTransport(transport);
        this.setTelephone(telephone);
        this.setPassword(password);
        this.setNumberOfCountrySerial(numberOfCountrySerial);
        this.setSchoolID(schoolID);
        this.setDateOfBirth(dateOfBirth);
        this.setAddress(address);
        this.setRoleGroup(role);
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public UUID getId() {
        return id;
    }

    public RoleGroup getRoleGroup() {
        return roleGroup;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumberOfCountrySerial() {
        return numberOfCountrySerial;
    }

    public void setNumberOfCountrySerial(String numberOfCountrySerial) {
        this.numberOfCountrySerial = numberOfCountrySerial;
    }

    public SchoolID getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(SchoolID schoolID) {
        this.schoolID = schoolID;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address addressID) {
        this.address = addressID;
    }


    public void setRoleGroup(RoleGroup roleGroup) {
        this.roleGroup = roleGroup;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
