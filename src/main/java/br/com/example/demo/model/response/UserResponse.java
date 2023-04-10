package br.com.example.demo.model.response;

public record UserResponse(
        String id,
        String name,
        String email,
        String password
) {
}
