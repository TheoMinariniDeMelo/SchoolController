package io.pro.educare.application.school.response;

import io.pro.educare.application.school.model.SchoolNeo4jEntity;

import java.util.UUID;

public record SchoolResponse(UUID id) {
    public static SchoolResponse with(SchoolNeo4jEntity schoolMongoEntity) {
        return new SchoolResponse(schoolMongoEntity.getId());
    }
}
