package com.spring.mongodb.DTOS;

import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotNull String name, @NotNull String email) {
}
