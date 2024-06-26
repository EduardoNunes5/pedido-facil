package br.com.eduardonunesdev.educafacil.dtos.authentication;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequestDTO(
        @NotEmpty
        String username,
        @NotEmpty
        String password
) {
}
