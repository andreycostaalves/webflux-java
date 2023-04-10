package br.com.example.demo.model.request;

public record UserRequest(
        String name,
        String email,
        String password
) { }
