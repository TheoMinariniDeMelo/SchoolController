package io.pro.educare.student;

import io.pro.educare.address.AddressID;
import io.pro.educare.transport.Transport;
import io.pro.educare.role.Role;
import io.pro.educare.school.SchoolID;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student {
    protected String name;
    protected String email;
    protected Transport transport;
    protected String telephone;
    protected String password;
    protected String numberOfCountrySerial;
    protected SchoolID schoolID;
    protected LocalDate dateOfBirth;
    protected AddressID addressID;
    protected Role role;
    protected LocalDateTime createdAt;
    protected LocalDateTime updateAt;
    protected LocalDateTime deletedAt;

    public Student() {
    }

    public Student(String name, String email, Transport transport, String telephone, String password, String numberOfCountrySerial, SchoolID schoolID, LocalDate dateOfBirth, AddressID addressID, Role role, LocalDateTime createdAt, LocalDateTime updateAt, LocalDateTime deletedAt) {
        this.name = name;
        this.email = email;
        this.transport = transport;
        this.telephone = telephone;
        this.password = password;
        this.numberOfCountrySerial = numberOfCountrySerial;
        this.schoolID = schoolID;
        this.dateOfBirth = dateOfBirth;
        this.addressID = addressID;
        this.role = role;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.deletedAt = deletedAt;
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

    public AddressID getAddressID() {
        return addressID;
    }

    public void setAddressID(AddressID addressID) {
        this.addressID = addressID;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
