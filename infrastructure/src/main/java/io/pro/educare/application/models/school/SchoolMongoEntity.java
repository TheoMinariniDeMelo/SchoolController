package io.pro.educare.application.models.school;

import io.pro.educare.application.models.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "school")
public class SchoolMongoEntity {
    @Id
    protected UUID id;
    protected Address address;
    protected String number;
    protected String name;

    public SchoolMongoEntity() {
        
    }

    public SchoolMongoEntity(Address address, String number, String name) {
        this.address = address;
        this.number = number;
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
