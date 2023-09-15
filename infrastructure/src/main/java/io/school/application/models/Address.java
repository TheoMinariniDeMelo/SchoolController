package io.school.application.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "address")
public class Address {
    @Id
    protected UUID id;
    protected String road;
    protected String neighborhood;
    protected Integer number;
    protected String reference;
}
