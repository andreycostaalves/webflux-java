package br.com.example.demo.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @Size(min = 3, max = 50, message = "Must be between 3 and 50 characters")
        @NotBlank(message = "Must not be null or empty")
        String name,
        @Email(message = "Invalid email")
        @NotBlank(message = "Must not be null or empty")
        String email,
        @Size(min = 3, max = 20, message = "Must be between 3 and 50 characters")
        @NotBlank(message = "Must not be null or empty")
        String password
) { }
