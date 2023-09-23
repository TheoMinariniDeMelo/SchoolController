package io.pro.educare.application.configure.useCases;

import io.pro.educare.application.school.SchoolNeo4jGateway;
import io.pro.educare.application.school.persistence.SchoolNeo4jRepository;
import io.pro.educare.application.school.create.DefaultCreateSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchoolUseCase {

    @Autowired
    private SchoolNeo4jGateway schoolMongoGateway;

    /*@Autowired
    private*/
    @Autowired
    public SchoolUseCase(SchoolNeo4jRepository schoolMongoRepository) {
    }

    @Bean
    public DefaultCreateSchool defaultCreateSchool() {
        return new DefaultCreateSchool(schoolMongoGateway);
    }
}
