package br.com.senior.library.controller;

import br.com.senior.library.model.TokenList;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Profile("!dev")
@Service
public class TokenServiceProd implements TokenService {

    @Override
    public boolean verify(String token) {

        return TokenList.tokens.contains(token);
    }
}
