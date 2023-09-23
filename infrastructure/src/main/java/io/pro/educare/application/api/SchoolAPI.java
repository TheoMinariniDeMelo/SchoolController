package io.pro.educare.application.api;

import io.pro.educare.application.school.persistence.SchoolNeo4jPersistence;
import io.pro.educare.application.school.response.SchoolResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("school")
public interface SchoolAPI {

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(description = "create a new school")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Create school"),
            @ApiResponse(responseCode = "406", description = ""),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    public SchoolResponse createSchool(@RequestBody SchoolNeo4jPersistence schoolMongoPersistence);
}
