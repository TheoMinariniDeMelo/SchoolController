package io.pro.educare.application.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllTest {
    @GetMapping("test")
    public ResponseEntity<String> getTest() {
        return new ResponseEntity<>("test admin", HttpStatus.OK);
    }
    @GetMapping("user")
    public ResponseEntity<String> getUser() {
        return new ResponseEntity<>("test user", HttpStatus.OK);
    }
}
