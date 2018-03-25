package br.sp.fair.fredericoalves.skipthedishes.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Rest - Entry Point 401 error
 * 
 * @author frederico.alves
 */
@Component
public final class RestAuthentication implements AuthenticationEntryPoint {

    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response, 
    			final AuthenticationException authException) throws IOException {

    	response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}