package ru.yas.user_service.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateUserDto(
        @NotBlank
        String username,

        @Email
        @NotBlank
        String email,

        String phone,

        String aboutMe,

        @NotNull
        Long countryId,

        String city
) {
}
