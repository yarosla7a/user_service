package ru.yas.user_service.service.country;

import ru.yas.user_service.dto.country.CountryDto;

import java.util.List;

public interface CountryService {

    List<CountryDto> getAll();
}