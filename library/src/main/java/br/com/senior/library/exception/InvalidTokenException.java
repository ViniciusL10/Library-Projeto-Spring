package br.com.senior.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Token Inválido")
public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException(String msg) {
        super(msg);
    }
}
