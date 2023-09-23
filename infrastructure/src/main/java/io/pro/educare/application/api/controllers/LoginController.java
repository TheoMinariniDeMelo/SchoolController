package io.pro.educare.application.api.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class LoginController {

    @PostMapping
    protected ResponseEntity<?> login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws SQLException {
        return null;
    }
}
