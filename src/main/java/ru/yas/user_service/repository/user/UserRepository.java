package ru.yas.user_service.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yas.user_service.entity.user.User;
import ru.yas.user_service.exception.EntityNotFoundException;

public interface UserRepository extends JpaRepository<User, Long> {

    default User getByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found by id: " + id));
    }
}
