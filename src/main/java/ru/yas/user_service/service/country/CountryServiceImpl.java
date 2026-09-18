package ru.yas.user_service.service.country;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yas.user_service.dto.country.CountryDto;
import ru.yas.user_service.repository.user.CountryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CountryDto> getAll() {
        return countryRepository.findAllByOrderByTitleAsc()
                .stream()
                .map(country -> new CountryDto(
                        country.getId(),
                        country.getTitle()
                ))
                .toList();
    }
}