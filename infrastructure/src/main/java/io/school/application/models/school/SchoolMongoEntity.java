package school.io.models.school;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import school.io.models.Address;

import java.util.UUID;

@Document(collection = "school")
public class SchoolMongoEntity {
    @Id
    protected UUID id;
    protected Address address;
    protected String cnpj;
    protected String name;
}
