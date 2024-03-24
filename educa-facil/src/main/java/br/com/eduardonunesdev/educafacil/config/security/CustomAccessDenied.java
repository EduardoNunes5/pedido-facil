package br.com.eduardonunesdev.educafacil.config.security;

import br.com.eduardonunesdev.educafacil.exceptions.CustomErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

@RequiredArgsConstructor
@Component
public class CustomAccessDenied implements AccessDeniedHandler {

    private final ObjectMapper mapper;
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");

        CustomErrorResponse customErrorResponse = new CustomErrorResponse(
                "Usuário não autorizado",
                HttpStatus.FORBIDDEN.value(),
                Collections.emptyList()
        );

        mapper.writeValue(response.getOutputStream(), customErrorResponse);
    }
}