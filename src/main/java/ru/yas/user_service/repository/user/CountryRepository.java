package ru.yas.user_service.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yas.user_service.entity.user.Country;
import ru.yas.user_service.exception.EntityNotFoundException;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

    default Country getByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Country not found by id: " + id
                ));
    }

    List<Country> findAllByOrderByTitleAsc();
}