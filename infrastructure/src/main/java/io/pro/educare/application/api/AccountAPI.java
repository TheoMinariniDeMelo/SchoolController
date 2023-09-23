package io.pro.educare.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("user")
@Tag(name = "user")
public interface AccountAPI {
    @PostMapping(
            produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "'Account' register"),
            @ApiResponse(responseCode = "422", description = "'Account' already exists'"),
            @ApiResponse(responseCode = "406", description = "No process"),
            @ApiResponse(responseCode = "500", description = "Internal server error")}
    )
    @Operation(summary = "Register account")
    public ResponseEntity<?> createAccount();
}
