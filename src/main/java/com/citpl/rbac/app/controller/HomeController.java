package com.citpl.rbac.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Tag(name = "Home", description = "Home controller endpoints")
public class HomeController {

    @GetMapping("/")
    @Operation(
        summary = "Get application status",
        description = "Returns the current status of the application along with server time"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Successfully retrieved application status"
    )
    public ResponseEntity<Map<String, Object>> getStatus() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("timestamp", LocalDateTime.now());
        response.put("message", "Welcome to RBAC Application");
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    @Operation(
        summary = "Check application health",
        description = "Simple health check endpoint"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Application is healthy"
    )
    public ResponseEntity<Map<String, String>> healthCheck() {
        Map<String, String> health = new HashMap<>();
        health.put("status", "healthy");
        health.put("service", "RBAC Application");
        
        return ResponseEntity.ok(health);
    }
}
