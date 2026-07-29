package ru.yas.user_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.yas.user_service.dto.user.CreateUserDto;
import ru.yas.user_service.dto.user.UpdateUserDto;
import ru.yas.user_service.dto.user.UserDto;
import ru.yas.user_service.entity.user.User;

@Mapper(componentModel = "spring")
// @Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "aboutMe", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "city", ignore = true)
    @Mapping(target = "experience", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    User toUser(CreateUserDto userDto);

    @Mapping(target = "countryId", source = "country.id")
    @Mapping(target = "countryTitle", source = "country.title")
    UserDto toUserDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "experience", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void update(UpdateUserDto userDto, @MappingTarget User entity);
}
