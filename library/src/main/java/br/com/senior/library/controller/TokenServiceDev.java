package br.com.senior.library.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Profile("dev")
@Service
public class TokenServiceDev implements TokenService {

    @Override
    public boolean verify(String token) {
        return true;
    }
}
