package ru.yas.user_service.config.context;

import org.springframework.stereotype.Component;

@Component
public class UserContext {

    public Long getUserId() {
        return 1L;
    }
}
