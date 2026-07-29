package ru.yas.user_service.service.user;

import ru.yas.user_service.dto.user.CreateUserDto;
import ru.yas.user_service.dto.user.UpdateUserDto;
import ru.yas.user_service.dto.user.UserDto;

/**
 * Service for user profile operations.
 */
public interface UserService {

    /**
     * Creates a new user profile.
     *
     * @param userDto user creation data
     * @return created user data without password
     */
    UserDto create(CreateUserDto userDto);

    /**
     * Updates an existing user profile.
     *
     * @param userId id of the user to update
     * @param userDto new user data
     * @return updated user data without password
     */
    UserDto update(long userId, UpdateUserDto userDto);

    /**
     * Returns user profile by id.
     *
     * @param userId user id
     * @return user data without password
     */
    UserDto getById(Long userId);
}
