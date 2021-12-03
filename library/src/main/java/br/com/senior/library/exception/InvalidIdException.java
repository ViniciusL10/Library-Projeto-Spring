package br.com.senior.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Id inválido")
public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String  msg) {
        super(msg);
    }
}
