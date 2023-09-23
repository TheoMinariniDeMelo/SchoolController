package io.pro.educare.application.api.controllers;

import io.pro.educare.application.api.AccountAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements AccountAPI {
    @Override
    public ResponseEntity<?> createAccount() {
        return null;
    }
}
