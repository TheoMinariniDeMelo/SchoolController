package io.school.application.models.school;

import io.school.application.models.Address;
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

}
