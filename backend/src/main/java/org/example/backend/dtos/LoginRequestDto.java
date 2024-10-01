package org.example.backend.dtos;

public record LoginRequestDto(
        String username,
        String password
) {
}
