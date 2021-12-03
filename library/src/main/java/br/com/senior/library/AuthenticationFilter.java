package br.com.senior.library;

import br.com.senior.library.controller.TokenService;
import br.com.senior.library.model.TokenList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {
    @Autowired
    TokenService tokenService;
    @Value("${spring.profiles.active}")
    String profile;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String authorization = request.getHeader("authorization");
        String uri = request.getRequestURI();

        if (tokenService.verify(authorization) || uri.equals("/library/login") || profile.equals("dev")){
            chain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token Inválido");
        }

    }
}
