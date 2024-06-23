package com.spring.mongodb.DTOS;

import com.mongodb.lang.NonNull;

public record UserDTO(@NonNull String name, @NonNull String email) {
}
