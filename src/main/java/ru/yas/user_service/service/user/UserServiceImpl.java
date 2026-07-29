package ru.yas.user_service.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yas.user_service.config.context.UserContext;
import ru.yas.user_service.dto.user.CreateUserDto;
import ru.yas.user_service.dto.user.UpdateUserDto;
import ru.yas.user_service.dto.user.UserDto;
import ru.yas.user_service.entity.user.Country;
import ru.yas.user_service.entity.user.User;
import ru.yas.user_service.exception.DataValidationException;
import ru.yas.user_service.exception.ForbiddenException;
import ru.yas.user_service.mapper.UserMapper;
import ru.yas.user_service.repository.user.CountryRepository;
import ru.yas.user_service.repository.user.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CountryRepository countryRepository;
    private final UserMapper userMapper;
    private final UserContext userContext;

    @Value("${user.password.min.length}")
    private int minPasswordLength;

    @Override
    @Transactional
    public UserDto create(CreateUserDto userDto) {
        log.info("Creating user with username: {}", userDto.username());

        validatePassword(userDto.password());

        Country country = countryRepository.getByIdOrThrow(userDto.countryId());

        User user = userMapper.toUser(userDto);
        user.setCountry(country);

        User savedUser = userRepository.save(user);

        log.info("Created user with id: {}", savedUser.getId());
        return userMapper.toUserDto(savedUser);
    }

    @Override
    @Transactional
    public UserDto update(long userId, UpdateUserDto userDto) {
        log.info("Updating user with id: {}", userId);

        Long currentUserId = userContext.getUserId();
        if (!currentUserId.equals(userId)) {
            throw new ForbiddenException("User can update only own profile");
        }

        User user = userRepository.getByIdOrThrow(userId);
        Country country = countryRepository.getByIdOrThrow(userDto.countryId());

        userMapper.update(userDto, user);
        user.setCountry(country);

        User savedUser = userRepository.save(user);

        log.info("Updated user with id: {}", savedUser.getId());
        return userMapper.toUserDto(savedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getById(Long userId) {
        log.info("Getting user by id: {}", userId);

        User user = userRepository.getByIdOrThrow(userId);
        return userMapper.toUserDto(user);
    }

    private void validatePassword(String password) {
        if (password == null || password.length() < minPasswordLength) {
            throw new DataValidationException(
                    "Password must contain at least " + minPasswordLength + " characters"
            );
        }
    }
}
