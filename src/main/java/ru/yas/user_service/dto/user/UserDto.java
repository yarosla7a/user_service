package ru.yas.user_service.dto.user;

public record UserDto(
        Long id,
        String username,
        String email,
        String phone,
        String aboutMe,
        Long countryId,
        String countryTitle,
        String city
) {
}
