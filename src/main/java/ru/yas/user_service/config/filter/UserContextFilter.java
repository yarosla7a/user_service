package ru.yas.user_service.config.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.yas.user_service.config.context.UserContext;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class UserContextFilter extends OncePerRequestFilter {

    private static final String USER_ID_HEADER = "x-user-id";

    private final UserContext userContext;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            String userId = request.getHeader(USER_ID_HEADER);

            if (userId != null && !userId.isBlank()) {
                userContext.setUserId(Long.parseLong(userId));
            }

            filterChain.doFilter(request, response);
        } finally {
            userContext.clear();
        }
    }
}
